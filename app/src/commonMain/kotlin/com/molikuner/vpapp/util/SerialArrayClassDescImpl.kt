package com.molikuner.vpapp.util

import kotlinx.serialization.CompositeDecoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.SerialKind
import kotlinx.serialization.StructureKind
import kotlinx.serialization.elementDescriptors
import kotlinx.serialization.internal.BooleanDescriptor
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.withName
import kotlin.jvm.JvmOverloads
import kotlin.reflect.KProperty1


abstract class SerialArrayClassDescImpl(
    override val name: String,
    vararg classAnnotations: Annotation
) : SerialDescriptor {
    override val kind: SerialKind get() = StructureKind.LIST

    private val _items: MutableMap<String, Pair<Int, Pair<SerialDescriptor, Boolean>>> = mutableMapOf()
    private val items: Map<String, Pair<Int, Pair<SerialDescriptor, Boolean>>> by lazy { _items }
    private val indexedItems: Map<Int, Pair<String, Pair<SerialDescriptor, Boolean>>> by lazy { items.entries.associate { it.value.first to (it.key to it.value.second) } }

    private val classAnnotations: List<Annotation> = classAnnotations.toList()

    fun addElement(property: KProperty1<*, *>, listIndex: Int, descriptor: SerialDescriptor, isOptional: Boolean = false) {
        _items[property.name] = listIndex to (descriptor.nullable(property.returnType.isMarkedNullable) to isOptional)
    }

    fun addElement(property: KProperty1<*, String?>, listIndex: Int, isOptional: Boolean = false) {
        this.addElement(property, listIndex, StringDescriptor.of(property), isOptional)
    }

    fun addElement(property: KProperty1<*, Boolean?>, listIndex: Int, isOptional: Boolean = false) {
        this.addElement(property, listIndex, BooleanDescriptor.of(property), isOptional)
    }

    private fun getElementOfIndex(index: Int) = indexedItems.getOrNull(0) ?: throw IllegalArgumentException("unknown index $index in array")

    private fun isValidIndex(index: Int): Boolean = items.any { it.value.first == index }

    override fun getElementDescriptor(index: Int): SerialDescriptor = getElementOfIndex(index).second.first

    override fun isElementOptional(index: Int): Boolean = getElementOfIndex(index).second.second

    override fun getEntityAnnotations(): List<Annotation> = classAnnotations
    override fun getElementAnnotations(index: Int): List<Annotation> =
        getElementOfIndex(index).second.first.getEntityAnnotations()

    override val elementsCount: Int
        get() = items.size

    override fun getElementName(index: Int): String = index.toString()
    override fun getElementIndex(name: String): Int {
        val index = name.toIntOrNull() ?: throw IllegalArgumentException("$name is not a valid array index")
        if (!isValidIndex(index)) return CompositeDecoder.UNKNOWN_NAME
        return index
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SerialArrayClassDescImpl) return false

        if (name != other.name) return false
        if (elementDescriptors() != other.elementDescriptors()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + elementDescriptors().hashCode()
        return result
    }

    override fun toString() = "$name${items.map { it.key }}"
}

package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.Menu
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import com.molikuner.vpapp.util.SerialArrayClassDescImpl
import com.molikuner.vpapp.util.serializer
import com.molikuner.vpapp.util.use
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer

@Serializer(forClass = Menu::class)
object MenuSerializer : KSerializer<Menu> {
    override val descriptor: SerialDescriptor
        get() = object : SerialArrayClassDescImpl("Menu") {
            init {
                addElement(Menu::id, 0)
                addElement(Menu::day, 1, Time.Day.descriptor)
                addElement(Menu::_default_, 2)
                addElement(Menu::vegetarian, 3)
                addElement(Menu::dessert, 4)
                addElement(Menu::evening, 5)
            }
        }

    override fun deserialize(decoder: Decoder): Menu {
        return decoder.use(descriptor) {
            Menu.Impl(
                id = decodeSerializableElement(0, UUID.serializer()),
                day = decodeSerializableElement(1, Time.Day.serializer()),
                _default_ = decodeStringElement(2),
                vegetarian = decodeNullableStringElement(3),
                dessert = decodeNullableStringElement(4),
                evening = decodeNullableStringElement(5)
            )
        }
    }

    override fun patch(decoder: Decoder, old: Menu): Menu {
        return MenuSerializer.deserialize(decoder)
    }

    override fun serialize(encoder: Encoder, obj: Menu) {
        return encoder.use(descriptor) {
            encodeSerializableElement(0, UUID.serializer(), obj.id)
            encodeSerializableElement(1, Time.Day.serializer(), obj.day)
            encodeStringElement(2, obj._default_)
            encodeNullableStringElement(3, obj.vegetarian)
            encodeNullableStringElement(4, obj.dessert)
            encodeNullableStringElement(5, obj.evening)
        }
    }
}

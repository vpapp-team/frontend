package com.molikuner.vpapp.data.remote.types

import com.molikuner.vpapp.data.local.MOTD
import com.molikuner.vpapp.data.local.StandIn
import com.molikuner.vpapp.data.types.MOTDSerializer
import com.molikuner.vpapp.data.types.StandInSerializer
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import kotlinx.serialization.CompositeDecoder
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.ArrayListSerializer
import kotlinx.serialization.internal.SerialClassDescImpl
import kotlinx.serialization.internal.StringSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonInput
import kotlinx.serialization.json.JsonOutput

@Serializable(with = StandInResponse.Companion::class)
data class StandInResponse(
    override val requestTime: Time,
    val addStandIn: List<StandIn>,
    val addMOTD: List<MOTD>,
    val remove: List<UUID>
) : CommonResponse() {
    private val add: List<String> by lazy {
        addMOTD.map { Json.plain.stringify(MOTDSerializer, it) } +
                addStandIn.map { Json.plain.stringify(StandInSerializer, it) }
    }

    @Serializer(forClass = StandInResponse::class)
    companion object {
        const val STAND_IN = 0
        const val MOTD = 1

        override val descriptor: SerialDescriptor = object : SerialClassDescImpl("StandInResponse") {
            init {
                addElement(StandInResponse::requestTime.name)
                addElement(StandInResponse::add.name)
                addElement(StandInResponse::remove.name)
            }
        }

        override fun deserialize(decoder: Decoder): StandInResponse {
            if (decoder !is JsonInput) throw SerializationException("RemoteStandIn should always be of type json")
            val struct = decoder.beginStructure(descriptor)
            lateinit var requestTime: Time
            lateinit var addStandIn: List<StandIn>
            lateinit var addMOTD: List<MOTD>
            lateinit var remove: List<UUID>
            loop@ while (true) {
                when (val i = struct.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> requestTime = struct.decodeSerializableElement(descriptor, i, Time)
                    1 -> {
                        val standIns: MutableList<StandIn> = mutableListOf()
                        val motds: MutableList<MOTD> = mutableListOf()
                        struct.decodeSerializableElement(descriptor, i, ArrayListSerializer(StringSerializer)).map {
                            Json.plain.parseJson(it).jsonArray
                        }.forEach {
                            when (it[1].primitive.int) {
                                STAND_IN -> standIns.add(Json.plain.fromJson(StandInSerializer, it))
                                MOTD -> motds.add(Json.plain.fromJson(MOTDSerializer, it))
                                else -> throw IllegalArgumentException("unknown json array format")
                            }
                        }
                        addStandIn = standIns
                        addMOTD = motds
                    }
                    2 -> remove = struct.decodeSerializableElement(descriptor, i, ArrayListSerializer(UUID))
                }
            }
            struct.endStructure(descriptor)
            return StandInResponse(requestTime, addStandIn, addMOTD, remove)
        }

        override fun serialize(encoder: Encoder, obj: StandInResponse) {
            if (encoder !is JsonOutput) throw SerializationException("RemoteStandIn should always be of type json")
            val struct = encoder.beginStructure(descriptor)
            struct.encodeSerializableElement(descriptor, 0, Time, obj.requestTime)
            struct.encodeSerializableElement(descriptor, 1, ArrayListSerializer(StringSerializer), obj.add)
            struct.encodeSerializableElement(descriptor, 2, ArrayListSerializer(UUID), obj.remove)
            struct.endStructure(descriptor)
        }
    }
}

package com.molikuner.vpapp.data.types

import com.molikuner.vpapp.data.local.Menu
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer

@Serializer(forClass = Menu::class)
object MenuSerializer : KSerializer<Menu>

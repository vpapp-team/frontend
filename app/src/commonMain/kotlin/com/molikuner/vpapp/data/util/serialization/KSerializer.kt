package com.molikuner.vpapp.data.util.serialization

import kotlinx.serialization.KSerializer

fun <T> KSerializer<T>.serializer() = this

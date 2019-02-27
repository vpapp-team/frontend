package com.molikuner.vpapp.util

import io.ktor.http.HttpStatusCode

val HttpStatusCode.Companion.NothingNew
    get() = HttpStatusCode.NotModified

val HttpStatusCode.Companion.Version2Low
    get() = HttpStatusCode(424, "Request version is too low")

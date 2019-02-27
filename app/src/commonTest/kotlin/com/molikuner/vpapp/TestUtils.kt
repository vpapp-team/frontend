package com.molikuner.vpapp

import com.molikuner.vpapp.data.remote.types.DataStatus
import com.molikuner.vpapp.types.UUID

operator fun DataStatus.Companion.invoke(vararg has: UUID) = DataStatus(has.toList())

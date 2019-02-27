package com.molikuner.vpapp.data.repository

import com.molikuner.vpapp.data.local.DB
import com.molikuner.vpapp.data.local.StandIn

object StandInRepository {

    suspend fun getAll(): List<StandIn> {
        return DB.queries.getAllStandIns().executeAsList()
    }

    suspend fun add(s: StandIn) {
        DB.queries.addStandIn(s.id, s.day, s.message, s.teacher, s.subject, s.clazz, s.lesson, s.room, s.origTeacher, s.origSubject, s.isEliminated)
    }
}
package com.molikuner.vpapp.data.repository

import com.molikuner.vpapp.data.local.DB
import com.molikuner.vpapp.data.local.StandIn
import com.molikuner.vpapp.data.types.LastUpdateTypes

object StandInRepository : BaseRepository<StandIn>() {

    override suspend fun saveData(l: List<StandIn>) {
        val dbData = getData()
        dbData.filter { !l.any { nStandIn -> nStandIn.id == it.id } }.also {
            it.forEach { toDel ->
                DB.queries.deleteStandIn(toDel.id)
            }
        }
        l.filter { !dbData.contains(it) }.also {
            it.forEach { newStandIn -> add(newStandIn) }
        }
    }

    override suspend fun getData(): List<StandIn> {
        if (UpdatesRepository.shouldRequest(LastUpdateTypes.STAND_IN)) {
            TODO("should request stand-ins from remote")
        }
        return DB.queries.getAllStandIns().executeAsList()
    }

    private suspend fun add(s: StandIn) {
        DB.queries.addStandIn(
            s.id,
            s.day,
            s.message,
            s.teacher,
            s.subject,
            s.clazz,
            s.lesson,
            s.room,
            s.origTeacher,
            s.origSubject,
            s.isEliminated
        )
    }
}

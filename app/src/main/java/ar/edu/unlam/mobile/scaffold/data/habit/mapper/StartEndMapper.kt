package ar.edu.unlam.mobile.scaffold.data.habit.mapper

import ar.edu.unlam.mobile.scaffold.data.habit.local.ActivityEndEntity
import ar.edu.unlam.mobile.scaffold.data.habit.local.ActivityStartEntity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityEnd
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityStart

class StartEndMapper {
    fun toActivityStartDB(activityStart: ActivityStart): ActivityStartEntity {
        return ActivityStartEntity(
            id = activityStart.id,
            date = activityStart.date,
            activityId = activityStart.activityId,
        )
    }

    fun toActivityEndDB(activityEnd: ActivityEnd): ActivityEndEntity {
        return ActivityEndEntity(
            id = activityEnd.id,
            date = activityEnd.date,
            startId = activityEnd.startId,
            minutes = activityEnd.minutes
        )
    }
}

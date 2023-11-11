package ar.edu.unlam.mobile.scaffold.data.habit.mapper

import ar.edu.unlam.mobile.scaffold.data.habit.local.ActivityEntity
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.Day
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.State
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.StateLocalModel
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.Week
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity

class ActivityMapper {
    fun toActivityDB(activity: Activity): ActivityEntity {
        val listDay = activity.days.map {
            Day(it, Week.values()[it.toInt()])
        }
        val state = StateLocalModel(activity.state, State.values()[activity.state.toInt()])
        return ActivityEntity(
            id = activity.id,
            activityName = activity.name,
            category = activity.category,
            days = listDay,
            goal = activity.dailyGoal,
            currentState = state,
        )
    }
}

package ar.edu.unlam.mobile.scaffold.data.habit.mapper

import ar.edu.unlam.mobile.scaffold.data.habit.local.HabitEntity
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.Day
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.State
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.StateLocalModel
import ar.edu.unlam.mobile.scaffold.data.habit.local.models.Week
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit

class HabitMapper {
    fun toHabitDB(habit: Habit): HabitEntity {
        val listDay = habit.days.map {
            Day(it, Week.values()[it.toInt()])
        }
        val state = StateLocalModel(habit.state, State.values()[habit.state.toInt()])
        return HabitEntity(
            id = habit.id,
            habitName = habit.name,
            category = habit.category,
            days = listDay,
            hour = habit.hour,
            currentState = state,
        )
    }
}

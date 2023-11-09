package ar.edu.unlam.mobile.scaffold.domain.mapper

import ar.edu.unlam.mobile.scaffold.data.habit.local.Day
import ar.edu.unlam.mobile.scaffold.data.habit.local.HabitLocalModel
import ar.edu.unlam.mobile.scaffold.data.habit.local.StateLocalModel
import ar.edu.unlam.mobile.scaffold.data.habit.local.StateRoutine
import ar.edu.unlam.mobile.scaffold.data.habit.local.Week
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit

class HabitMapper {
    fun toHabitDB(habit: Habit): HabitLocalModel {
        val listDay = habit.days.map {
            Day(it, Week.values()[it.toInt()])
        }
        val state = StateLocalModel(habit.state, StateRoutine.values()[habit.state.toInt()])
        return HabitLocalModel(
            id = 0,
            habitName = habit.name,
            category = habit.category,
            days = listDay,
            hour = habit.hour,
            currentState = state,
        )
    }
}
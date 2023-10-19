package ar.edu.unlam.mobile.scaffold.domain.habit.services

import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow


interface HabitGetter {
    suspend fun getHabit(): Flow<Habit>
}
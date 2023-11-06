package ar.edu.unlam.mobile.scaffold.domain.habit.services

import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow

interface HabitGetter {
    suspend fun getHabit(): Flow<List<Habit>>
    suspend fun insertHabit(habit: Habit)
    suspend fun deleteHabitById(habitId: Long)
}

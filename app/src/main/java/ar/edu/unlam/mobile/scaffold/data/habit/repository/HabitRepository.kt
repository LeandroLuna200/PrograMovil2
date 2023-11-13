package ar.edu.unlam.mobile.scaffold.data.habit.repository

import ar.edu.unlam.mobile.scaffold.data.habit.local.HabitLocalModel
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {

    suspend fun updateHabitState(habit: Habit)

    fun getHabits(): Flow<List<Habit>>

    suspend fun insertHabit(habitLocalModel: HabitLocalModel)

    suspend fun deleteHabitById(habitId: Long)
}
package ar.edu.unlam.mobile.scaffold.data.habit.repository

import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {
    suspend fun getHabit(): Flow<Habit>
}
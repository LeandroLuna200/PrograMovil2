package ar.edu.unlam.mobile.scaffold.data.habit.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Update
    suspend fun updateHabitState(habit: HabitEntity)

    @Insert
    suspend fun insertHabit(habitEntity: HabitEntity)

    @Query("SELECT * FROM habit_table")
    fun getAllHabits(): Flow<List<HabitEntity>>

    @Query("DELETE FROM habit_table WHERE id = :habitId")
    suspend fun deleteHabitById(habitId: Long)
}

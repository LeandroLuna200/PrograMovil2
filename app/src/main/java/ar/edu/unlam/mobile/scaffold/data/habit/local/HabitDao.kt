package ar.edu.unlam.mobile.scaffold.data.habit.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Insert
    suspend fun insertHabit(habitLocalModel: HabitLocalModel)

    @Query("SELECT * FROM habit_table")
    fun getAllHabits(): Flow<List<HabitLocalModel>>
}

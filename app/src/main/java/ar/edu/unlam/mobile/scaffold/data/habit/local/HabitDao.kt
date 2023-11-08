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

    @Query("DELETE FROM habit_table WHERE id = :habitId")
    suspend fun deleteHabitById(habitId: Long)

    @Insert
    suspend fun insertActivity(activityLocalModel: ActivityLocalModel)

    @Query("SELECT * FROM activity_table")
    fun getAllActivities(): Flow<List<ActivityLocalModel>>

    @Query("DELETE FROM activity_table WHERE id= :id")
    suspend fun deleteActivityById(id: Long)
}

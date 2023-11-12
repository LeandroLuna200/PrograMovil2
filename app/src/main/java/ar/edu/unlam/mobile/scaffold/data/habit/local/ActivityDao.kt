package ar.edu.unlam.mobile.scaffold.data.habit.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {
    @Update
    suspend fun updateActivityState(habit: ActivityEntity)

    @Insert
    suspend fun insertActivity(activityLocalModel: ActivityEntity)

    @Query("SELECT * FROM activity_table")
    fun getAllActivities(): Flow<List<ActivityEntity>>

    @Query("DELETE FROM activity_table WHERE id= :id")
    suspend fun deleteActivityById(id: Long)

    @Insert
    suspend fun insertStart(activityStart: ActivityStartEntity)

    @Query("SELECT * FROM activityStart_tb WHERE id= :id")
    suspend fun selectStartById(id: Long): ActivityStartEntity

    @Insert
    suspend fun insertEnd(activityEnd: ActivityEndEntity)

    @Query("SELECT * FROM activityEnd_tb WHERE id= :id")
    suspend fun selectEndById(id: Long): ActivityEndEntity
}

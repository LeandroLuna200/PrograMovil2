package ar.edu.unlam.mobile.scaffold.domain.habit.services

import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityEnd
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityStart
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow

interface HabitGetter {
    suspend fun updateHabitState(habit: Habit)
    suspend fun getHabit(): Flow<List<Habit>>
    suspend fun insertHabit(habit: Habit)
    suspend fun deleteHabitById(habitId: Long)

    // Activity
    suspend fun insertActivity(activity: Activity)
    suspend fun deleteActivityById(id: Long)
    suspend fun getAllActivities(): Flow<List<Activity>>

    suspend fun updateActivityState(activity: Activity)

    suspend fun insertStart(activityStart: ActivityStart)

    suspend fun selectStartById(id: Long): ActivityStart

    fun getAllActivitiesStart(): Flow<List<ActivityStart>>

    suspend fun insertEnd(activityEnd: ActivityEnd)

    suspend fun selectEndById(id: Long): ActivityEnd

    suspend fun selectStartMaxById(id: Long): Long

    fun getAllActivitiesEnd(): Flow<List<ActivityEnd>>

    fun getActivityStarts(activityId: Long): Flow<List<ActivityStart>>

    fun getActivityEndsForActivity(startIds: List<Long>): Flow<List<ActivityEnd>>
    suspend fun getTiempoDeActividades(): List<Activity?>
}

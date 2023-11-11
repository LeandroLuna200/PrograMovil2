package ar.edu.unlam.mobile.scaffold.data.habit.repository

import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityEnd
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityStart
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {

    suspend fun updateHabitState(habit: Habit)

    fun getHabits(): Flow<List<Habit>>

    suspend fun insertHabit(habit: Habit)

    suspend fun deleteHabitById(habitId: Long)

    // Activity

    suspend fun updateActivityState(activity: Activity)

    suspend fun insertActivity(activity: Activity)

    fun getAllActivities(): Flow<List<Activity>>

    suspend fun deleteActivityById(id: Long)

    suspend fun insertStart(activityStart: ActivityStart)

    suspend fun selectStartById(id: Long): ActivityStart?

    suspend fun insertEnd(activityEnd: ActivityEnd)

    suspend fun selectEndById(id: Long): ActivityEnd?
}

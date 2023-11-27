package ar.edu.unlam.mobile.scaffold.data.habit.repository

import ar.edu.unlam.mobile.scaffold.data.habit.local.ActivityDao
import ar.edu.unlam.mobile.scaffold.data.habit.local.HabitDao
import ar.edu.unlam.mobile.scaffold.data.habit.mapper.ActivityMapper
import ar.edu.unlam.mobile.scaffold.data.habit.mapper.HabitMapper
import ar.edu.unlam.mobile.scaffold.data.habit.mapper.StartEndMapper
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityEnd
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityStart
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HabitDefaultRepository @Inject constructor(
    private val habitDao: HabitDao,
    private val activityDao: ActivityDao,
) : HabitRepository {
    override suspend fun updateHabitState(habit: Habit) {
        habitDao.updateHabitState(HabitMapper().toHabitDB(habit))
    }

    override fun getHabits(): Flow<List<Habit>> {
        return this.habitDao.getAllHabits().map { habitEntities ->
            habitEntities.map { habitEntity ->
                habitEntity.toHabitDomain()
            }
        }
    }

    override suspend fun insertHabit(habit: Habit) {
        habitDao.insertHabit(HabitMapper().toHabitDB(habit))
    }

    override suspend fun deleteHabitById(habitId: Long) {
        habitDao.deleteHabitById(habitId)
    }

    // Activity

    override suspend fun updateActivityState(activity: Activity) {
        activityDao.updateActivityState(ActivityMapper().toActivityDB(activity))
    }

    override suspend fun insertActivity(activity: Activity) {
        activityDao.insertActivity(ActivityMapper().toActivityDB(activity))
    }

    override fun getAllActivities(): Flow<List<Activity>> {
        return this.activityDao.getAllActivities().map { activitiesEntities ->
            activitiesEntities.map { activityEntity ->
                activityEntity.toActivityDomain()
            }
        }
    }

    override suspend fun deleteActivityById(id: Long) {
        activityDao.deleteActivityById(id)
    }

    override suspend fun insertStart(activityStart: ActivityStart) {
        activityDao.insertStart(StartEndMapper().toActivityStartDB(activityStart))
    }

    override suspend fun selectStartById(id: Long): ActivityStart {
        return activityDao.selectStartById(id).toActivityStartDomain()
    }

    override suspend fun insertEnd(activityEnd: ActivityEnd) {
        activityDao.insertEnd(StartEndMapper().toActivityEndDB(activityEnd))
    }

    override suspend fun selectEndById(id: Long): ActivityEnd {
        return activityDao.selectEndById(id).toActivityEndDomain()
    }
}

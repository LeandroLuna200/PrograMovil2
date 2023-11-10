package ar.edu.unlam.mobile.scaffold.data.habit.repository

import android.util.Log
import ar.edu.unlam.mobile.scaffold.data.habit.local.HabitDao
import ar.edu.unlam.mobile.scaffold.data.habit.local.HabitLocalModel
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.mapper.HabitMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HabitDefaultRepository @Inject constructor(
    private val locationDao: HabitDao,
) : HabitRepository {
    override suspend fun updateHabitState(habit: Habit) {
        locationDao.updateHabitState(HabitMapper().toHabitDB(habit))
    }

    override fun getHabits(): Flow<List<Habit>> {
        return this.locationDao.getAllHabits().map { habitEntities ->
            habitEntities.map { habitEntity ->
                habitEntity.toHabitDomain()
            }
        }
    }

//    fun getActivities(): Flow<List<Activity>> {
//        return this.locationDao.getAllActivities().map { activityEntities ->
//            activityEntities.map { activityEntity ->
//                activityEntity.toActivityDomain()
//            }
//        }
//    }

    override suspend fun insertHabit(habitLocalModel: HabitLocalModel) {
        locationDao.insertHabit(habitLocalModel)
    }

//    suspend fun insertActivity(activityLocalModel: ActivityLocalModel) {
//        locationDao.insertActivity(activityLocalModel)
//    }

    override suspend fun deleteHabitById(habitId: Long) {
        locationDao.deleteHabitById(habitId)
    }

//    suspend fun deleteActivityById(id: Long) {
//        locationDao.deleteActivityById(id)
//    }

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
//    @WorkerThread
//    suspend fun updateLocation(habits: Habit) {
//        locationDao.updateLocation(location)
//    }
}

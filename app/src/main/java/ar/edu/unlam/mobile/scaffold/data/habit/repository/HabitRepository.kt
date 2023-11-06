package ar.edu.unlam.mobile.scaffold.data.habit.repository

import ar.edu.unlam.mobile.scaffold.data.habit.local.HabitDao
import ar.edu.unlam.mobile.scaffold.data.habit.local.HabitLocalModel
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HabitRepository @Inject constructor(
    private val locationDao: HabitDao,
) {

    fun getHabits(): Flow<List<Habit>> {
        return this.locationDao.getAllHabits().map { habitEntities ->
            habitEntities.map { habitEntity ->
                Habit(
                    id = habitEntity.id,
                    name = habitEntity.habitName,
                    category = habitEntity.category,
                    days = habitEntity.days,
                    dailyGoal = habitEntity.dailyGoal,
                )
            }
        }
    }

    suspend fun insertHabit(habitLocalModel: HabitLocalModel) {
        locationDao.insertHabit(habitLocalModel)
    }

    suspend fun deleteHabitById(habitId: Long) {
        locationDao.deleteHabitById(habitId)
    }

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
//    @WorkerThread
//    suspend fun updateLocation(habits: Habit) {
//        locationDao.updateLocation(location)
//    }
}

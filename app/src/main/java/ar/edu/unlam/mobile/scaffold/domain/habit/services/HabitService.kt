package ar.edu.unlam.mobile.scaffold.domain.habit.services

import ar.edu.unlam.mobile.scaffold.data.habit.repository.HabitDefaultRepository
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityEnd
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityStart
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HabitService @Inject constructor(val repository: HabitDefaultRepository) :
    HabitGetter {

    override suspend fun insertHabit(habit: Habit) {
        this.repository.insertHabit(habit)
    }

    override suspend fun deleteHabitById(habitId: Long) {
        this.repository.deleteHabitById(habitId)
    }

    override suspend fun updateHabitState(habit: Habit) {
        this.repository.updateHabitState(habit)
    }

    override suspend fun getHabit(): Flow<List<Habit>> {
        return this.repository.getHabits()
    }

    // Activity

    override suspend fun insertActivity(activity: Activity) {
        repository.insertActivity(activity)
    }

    override suspend fun deleteActivityById(id: Long) {
        repository.deleteActivityById(id)
    }

    override suspend fun getAllActivities(): Flow<List<Activity>> {
        return repository.getAllActivities()
    }

    override suspend fun updateActivityState(activity: Activity) {
        repository.updateActivityState(activity)
    }

    override suspend fun insertStart(activityStart: ActivityStart) {
        repository.insertStart(activityStart)
    }

    override suspend fun selectStartById(id: Long): ActivityStart {
        return repository.selectStartById(id)
    }

    override suspend fun insertEnd(activityEnd: ActivityEnd) {
        repository.insertEnd(activityEnd)
    }

    override suspend fun selectEndById(id: Long): ActivityEnd {
        return repository.selectEndById(id)
    }
}

package ar.edu.unlam.mobile.scaffold.domain.habit.services

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import ar.edu.unlam.mobile.scaffold.data.habit.repository.HabitDefaultRepository
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityEnd
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityStart
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import java.time.Duration
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
        return repository.getHabits()
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

    override fun getAllActivitiesStart(): Flow<List<ActivityStart>> {
        return repository.getAllActivitiesStart()
    }

    override suspend fun insertEnd(activityEnd: ActivityEnd) {
        repository.insertEnd(activityEnd)
    }

    override suspend fun selectEndById(id: Long): ActivityEnd {
        return repository.selectEndById(id)
    }

    override suspend fun selectStartMaxById(id: Long): Long {
        return repository.selectStartMaxById(id)
    }

    override fun getAllActivitiesEnd(): Flow<List<ActivityEnd>> {
        return repository.getAllActivitiesEnd()
    }

    override fun getActivityStarts(activityId: Long): Flow<List<ActivityStart>> {
        return repository.getActivityStarts(activityId)
    }

    override fun getActivityEndsForActivity(startIds: List<Long>): Flow<List<ActivityEnd>> {
        return repository.getActivityEndsForActivity(startIds)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getTiempoDeActividades(): List<Activity?> {
        val actividades = repository.getAllActivities().firstOrNull() ?: emptyList()
        Log.i("ESTADO", actividades.toString())
        val actividadesConTiempo = actividades.map { actividad ->
            Log.i("ESTADO0", actividades.toString())
            if (actividad.state != 0L) {
                var startDataList: List<ActivityStart>? = null
                repository.getActivityStarts(actividad.id).map {
                    startDataList = it
                    Log.i("ESTADO2", it.toString())
                }
                val startIds = startDataList?.map { it.id }
                Log.i("ESTADO2", startDataList.toString())
                var endDataList: List<ActivityEnd>? = null
                if (startIds != null) {
                    repository.getActivityEndsForActivity(startIds).map {
                        endDataList = it
                    }
                }
                Log.i("ESTADO3", endDataList.toString())
                val totalDurationMinutes = calculateTotalDuration(startDataList, endDataList)
                Log.i("totalDurationMinutes", totalDurationMinutes.toString())
                // Verificar si se cumplió el dailyGoal
                val cumplioDailyGoal = totalDurationMinutes >= actividad.dailyGoal.toLong()
                // Actualizar el estado de la actividad basado en la duración total y el dailyGoal
                val newState = if (cumplioDailyGoal) {
//                ActivityState.COMPLETED
                    Log.i("ESTADO", totalDurationMinutes.toString())
                } else {
//                ActivityState.INACTIVE
                    Log.i("ESTADO", cumplioDailyGoal.toString())
                }

                // Crear una nueva instancia de la actividad con la información actualizada
                actividad.copy(state = 0)
            } else {
                null
            }
        }
        Log.i("ESTADO", actividadesConTiempo.toString())
        return actividadesConTiempo
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculateTotalDuration(
        startDataList: List<ActivityStart>?,
        endDataList: List<ActivityEnd>?,
    ): Long {
        var totalDurationMinutes = 0L

        if (startDataList != null) {
            for (i in 0 until minOf(startDataList.size, endDataList?.size ?: 0)) {
                val startData = startDataList[i]
                val endData = endDataList?.get(i)

                if (endData != null) {
                    totalDurationMinutes += Duration.between(startData.date, endData.date)
                        .toMinutes()
                }
            }
        }

        return totalDurationMinutes
    }
}

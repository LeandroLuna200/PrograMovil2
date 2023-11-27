package ar.edu.unlam.mobile.scaffold.ui.screens

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import ar.edu.unlam.mobile.scaffold.domain.habit.services.HabitGetter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class PlannerViewModel @Inject constructor(private val habitGetter: HabitGetter) : ViewModel() {
    private val _showDialog = mutableStateOf(false)
    val showDialog: State<Boolean> = _showDialog

    private val _habits = mutableStateOf<List<Habit>>(emptyList())
    private val _activities = mutableStateOf<List<Activity>>(emptyList())
    val habits: State<List<Habit>> = _habits
    val activities: State<List<Activity>> = _activities

    init {
        getHabit()
        getActivity()
    }

    fun getActivity() {
        viewModelScope.launch {
            habitGetter.getAllActivities().collect {
                _activities.value = it
            }
        }
    }

    fun getHabit() {
        Log.i("HABITS MOCK1", "")
        viewModelScope.launch {
            Log.i("HABITS MOCK2", "")
            habitGetter.getHabit().collect { it ->
                _habits.value = it
            }
        }
    }

    fun insertActivity(activity: Activity) {
        viewModelScope.launch {
            habitGetter.insertActivity(activity)
        }
    }

    fun deleteActivity(activityId: Long) {
        viewModelScope.launch { habitGetter.deleteActivityById(activityId) }
    }

    fun insertHabit(habit: Habit) {
        viewModelScope.launch {
            habitGetter.insertHabit(habit)
        }
    }

    fun deleteHabit(habitId: Long) {
        viewModelScope.launch { habitGetter.deleteHabitById(habitId) }
    }

    fun filterHabitByDay(): List<Habit> {
        Log.i("LIST", _habits.value.toString())
        Log.i("LIST", _habits.value.filter { it.category == TypeCategory.ROUTINE }.toString())

        return _habits.value.filter { it.days.contains(getDiaNumber()) }
    }

    fun filterActivityByDay(): List<Activity> {
        return _activities.value.filter { it.days.contains(getDiaNumber()) }
    }

    fun getDiaNumber(): Long {
        var diaActual: Long = 0
        when (getCurrentDate()) {
            "domingo" -> diaActual = 0
            "lunes" -> diaActual = 1
            "martes" -> diaActual = 2
            "miércoles" -> diaActual = 3
            "jueves" -> diaActual = 4
            "viernes" -> diaActual = 5
            "sábado" -> diaActual = 6
        }
        return diaActual
    }

    @SuppressLint("SimpleDateFormat")
    fun getCurrentDate(): String {
        val currentDate = Date()
        val spanishLocale = Locale("es", "ES")
        return SimpleDateFormat("EEEE", spanishLocale).format(currentDate)
    }

    fun showOrDismissDialog(show: Boolean) {
        _showDialog.value = show
    }
}

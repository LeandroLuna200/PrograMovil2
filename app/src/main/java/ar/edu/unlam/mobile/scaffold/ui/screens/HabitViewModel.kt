package ar.edu.unlam.mobile.scaffold.ui.screens

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
class HabitViewModel @Inject constructor(private val habitGetter: HabitGetter) : ViewModel() {
    private val _habits = mutableStateOf<List<Habit>>(emptyList())
    val habits: State<List<Habit>> = _habits

    private val _activities = mutableStateOf<List<Activity>>(emptyList())
    val activities: State<List<Activity>> = _activities

    private val _selectedDays = mutableStateOf(listOf<Long>())
    val selectedDays: State<List<Long>> = _selectedDays

//    private var _actIncompletas = listOf<Activity>()
//    private var actIncompletas: List<Activity> = _actIncompletas
//    var hayIncompletas: Boolean = false

    private val _actIncompletas = MutableLiveData<List<Activity>>()
    val actIncompletas: LiveData<List<Activity>> get() = _actIncompletas

    private val _hayIncompletas = MutableLiveData<Boolean>()
    val hayIncompletas: LiveData<Boolean> get() = _hayIncompletas

    init {
        getHabit()
        getActivity()
        _selectedDays.value = listOf(getDiaNumber())
//        filtrarListasXDia()
        getActivitiesIncompletas()
    }

    private fun getActivitiesIncompletas() {
        viewModelScope.launch {
            _actIncompletas.value = habitGetter.getTiempoDeActividades()
            _hayIncompletas.value = _actIncompletas.value!!.isNotEmpty()
            Log.i("BOOLEAN", hayIncompletas.toString())
        }
    }

    private fun getHabit() {
        viewModelScope.launch {
            habitGetter.getHabit().collect { it ->
                _habits.value = it
            }
        }
    }

    private fun getActivity() {
        viewModelScope.launch {
            habitGetter.getAllActivities().collect {
                _activities.value = it
            }
        }
    }

    fun updateHabit(habit: Habit) {
        viewModelScope.launch { habitGetter.updateHabitState(habit) }
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
        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val currentDate = Date()
        val spanishLocale = Locale("es", "ES")
        return SimpleDateFormat("EEEE", spanishLocale).format(currentDate)
    }

    fun dismissIncompletasDialog() {
        _hayIncompletas.value = false
    }
}

package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.services.HabitGetter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitViewModel @Inject constructor(private val habitGetter: HabitGetter) : ViewModel() {
    private val _habits = mutableStateOf<List<Habit>>(emptyList())
    val habits: State<List<Habit>> = _habits

    private val _activities = mutableStateOf<List<Activity>>(emptyList())
    val activities: State<List<Activity>> = _activities

    init {
        getHabit()
        getActivity()
    }

    private fun getHabit() {
        viewModelScope.launch {
            habitGetter.getHabit().collect { it ->
//                it.map {
//                    _habits.value = listOf(it)
//                    Log.i("BASE DE DATOS", it.id.toString())
//                    Log.i("BASE DE DATOS", it.name)
//                }
                _habits.value = it
            }
        }
    }

    private fun getActivity(){
        viewModelScope.launch {
            habitGetter.getAllActivities().collect{
                _activities.value = it
            }
        }
    }

    fun updateHabit(habit: Habit) {
        viewModelScope.launch { habitGetter.updateHabitState(habit) }
    }

    fun updateActivity(activity: Activity){
        viewModelScope.launch{ habitGetter.updateActivityState(activity)}
    }
}

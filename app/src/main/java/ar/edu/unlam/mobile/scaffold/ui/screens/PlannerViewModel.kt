package ar.edu.unlam.mobile.scaffold.ui.screens

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.services.HabitGetter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlannerViewModel @Inject constructor(private val habitGetter: HabitGetter) : ViewModel() {
    private val _showDialog = mutableStateOf(false)
    val showDialog: State<Boolean> = _showDialog

    private val _showSecondDialog = mutableStateOf(false)
    val showSecondDialog: State<Boolean> = _showSecondDialog

    private val _showThirdDialog = mutableStateOf(false)
    val showThirdDialog: State<Boolean> = _showThirdDialog

    private val _habits = mutableStateOf<List<Habit>>(emptyList())
    val habits: State<List<Habit>> = _habits

    init {
        getHabit()
    }

    fun getHabit() {
        Log.i("HABITOS MOCK1", "")
        viewModelScope.launch {
            Log.i("HABITOS MOCK2", "")
            habitGetter.getHabit().collect {
//                Log.i("HABITOS MOCK", it.toString())
//                _habits.value = _habits.value + it
//                Log.i("HABITOS MOCK", habits.toString())
                it.map {
                    Log.i("HABITOS MOCK", it.id.toString())
                    Log.i("HABITOS MOCK", it.name.toString())
                }
            }
        }
    }

    fun showOrDismissDialog(show: Boolean) {
        _showDialog.value = show
    }

    fun showOrDismissSecondDialog(show: Boolean) {
        _showSecondDialog.value = show
    }

    fun showOrDismissThirdDialog(show: Boolean) {
        _showThirdDialog.value = show
    }
}

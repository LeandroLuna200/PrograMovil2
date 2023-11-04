package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlannerViewModel @Inject constructor() : ViewModel() {
    private val _showDialog = mutableStateOf(false)
    val showDialog: State<Boolean> = _showDialog

    private val _showSecondDialog = mutableStateOf(false)
    val showSecondDialog: State<Boolean> = _showSecondDialog

    private val _showThirdDialog = mutableStateOf(false)
    val showThirdDialog: State<Boolean> = _showThirdDialog

    private val _habits = mutableStateOf<List<Habit>>(emptyList())
    val habits: State<List<Habit>> = _habits

    init {
        // Inicializa la lista de hábitos aquí
        val initialHabits = mutableListOf<Habit>()
        initialHabits.add(Habit("levantarme temprano", TypeCategory.SIMPLE, isSimple = true, 0, 0))
        initialHabits.add(Habit("levantarme temprano", TypeCategory.SIMPLE, isSimple = true, 0, 0))
        initialHabits.add(Habit("estudiar 2hrs", TypeCategory.DEDICATED, isSimple = false, 2, 8))
        initialHabits.add(
            Habit(
                "ir al médico a las 10 am",
                TypeCategory.EVENT,
                isSimple = false,
                0,
                0,
            ),
        )
        _habits.value = initialHabits
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

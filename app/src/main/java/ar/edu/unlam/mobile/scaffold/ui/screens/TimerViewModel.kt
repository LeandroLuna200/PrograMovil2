package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Activity
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityEnd
import ar.edu.unlam.mobile.scaffold.domain.habit.models.ActivityStart
import ar.edu.unlam.mobile.scaffold.domain.habit.services.HabitGetter
import ar.edu.unlam.mobile.scaffold.domain.joke.models.Joke
import ar.edu.unlam.mobile.scaffold.domain.joke.services.JokeGetter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@Immutable
sealed interface JokeUIState {
    data class Success(val joke: Joke) : JokeUIState
    object Loading : JokeUIState
    data class Error(val message: String) : JokeUIState
}

data class TimerUIState(
    val jokeState: JokeUIState = JokeUIState.Loading,
)

@HiltViewModel
class TimerViewModel @Inject constructor(
    private val jokeGetter: JokeGetter,
    private val habitGetter: HabitGetter,
) : ViewModel() {

    private val _jokeState = MutableStateFlow(JokeUIState.Loading)

    private val _uiState = MutableStateFlow(
        TimerUIState(_jokeState.value),
    )

    val uiState = _uiState.asStateFlow()

    init {
        getJoke()
    }

    private fun getJoke() {
        viewModelScope.launch {
            jokeGetter.getJoke().collect {
                _uiState.value = TimerUIState(JokeUIState.Success(it))
            }
        }
    }

    fun updateActivity(activity: Activity) {
        viewModelScope.launch { habitGetter.updateActivityState(activity) }
    }

    fun insertStart(activityStart: ActivityStart) {
        viewModelScope.launch { habitGetter.insertStart(activityStart) }
    }

    suspend fun selectStartById(id: Long): ActivityStart {
        return withContext(Dispatchers.IO) {
            habitGetter.selectStartById(id)
        }
    }

    fun insertEnd(activityEnd: ActivityEnd) {
        viewModelScope.launch { habitGetter.insertEnd(activityEnd) }
    }

    suspend fun selectEndById(id: Long): ActivityEnd {
        return withContext(Dispatchers.IO) {
            habitGetter.selectEndById(id)
        }
    }
}

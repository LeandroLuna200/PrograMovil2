package ar.edu.unlam.mobile.scaffold.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffold.domain.joke.models.Joke
import ar.edu.unlam.mobile.scaffold.domain.joke.services.JokeGetter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
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
class TimerViewModel @Inject constructor(val jokeGetter: JokeGetter) : ViewModel() {

    private val _jokeState = MutableStateFlow(JokeUIState.Loading)

    private val _uiState = MutableStateFlow(
        TimerUIState(_jokeState.value),
    )

    val uiState = _uiState.asStateFlow()

    init {
        getJoke()
    }

    fun getJoke() {
        viewModelScope.launch {
            jokeGetter.getJoke().collect {
                _uiState.value = TimerUIState(JokeUIState.Success(it))
            }
        }
    }
}

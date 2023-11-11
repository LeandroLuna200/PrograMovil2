package ar.edu.unlam.mobile.scaffold.data.habit.local.models

data class StateLocalModel(
    val id: Long = 0,
    val name: State,
)

enum class State {
    COMPLETE,
    INCOMPLETE,
}

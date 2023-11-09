package ar.edu.unlam.mobile.scaffold.data.habit.local

data class StateLocalModel(
    val id: Long = 0,
    val name: StateRoutine,
)

enum class StateRoutine{
    COMPLETE,
    INCOMPLETE,
}
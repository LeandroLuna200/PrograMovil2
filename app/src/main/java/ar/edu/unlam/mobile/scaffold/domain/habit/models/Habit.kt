package ar.edu.unlam.mobile.scaffold.domain.habit.models

data class Habit(
    val name: String,
    val category: TypeCategory,
    val isSimple: Boolean,
    // TODO ver tiempos
    val dailyGoal: Long,
    val weeklyGoal: Long,
)

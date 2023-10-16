package ar.edu.unlam.mobile.scaffold.domain.habit

data class Habit(
    val name: String,
    // TODO Enum de categorias
    val category: String,
    val isSimple: Boolean,
    // TODO ver tiempos
    val dailyGoal: Long,
    val weeklyGoal: Long,
)

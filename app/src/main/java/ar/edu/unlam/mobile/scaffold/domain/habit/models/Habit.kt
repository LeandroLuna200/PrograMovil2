package ar.edu.unlam.mobile.scaffold.domain.habit.models

sealed class Habito {
    abstract val id: Long
    abstract val name: String
    abstract val category: TypeCategory
}

data class Habit(
    override val id: Long,
    override val name: String,
    override val category: TypeCategory,
    val days: List<Long>,
    val hour: Long,
    var state: Long,
) : Habito()

data class Activity(
    override val id: Long,
    override val name: String,
    override val category: TypeCategory,
    val days: List<String>,
    val dailyGoal: Int,
    val state: Long,
) : Habito() {
//    fun toDomain(): ActivityLocalModel {
//        return ActivityLocalModel(
//            id = id,
//            activityName = name,
//            category = category,
//            days = days,
//            goal = dailyGoal,
//        )
//    }
}

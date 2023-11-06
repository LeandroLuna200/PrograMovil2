package ar.edu.unlam.mobile.scaffold.domain.habit.services

import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import ar.edu.unlam.mobile.scaffold.domain.habit.models.TypeCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HabitMockService @Inject constructor() : HabitGetter {

    override suspend fun getHabit(): Flow<List<Habit>> {
        val dias = mutableListOf<String>("D", "L", "S")
//        return flow {
//            emit(Habit(1,"levantarme temprano", TypeCategory.SIMPLE, dias, 0))
//            emit(Habit(2,"levantarme temprano", TypeCategory.SIMPLE, dias, 0))
//            emit(Habit(3, "estudiar 2hrs", TypeCategory.DEDICATED, dias, 8))
//        }
        val prueba = mutableListOf<Habit>(
            Habit(1, "levantarme temprano", TypeCategory.SIMPLE, dias, 0),
            Habit(2, "levantarme temprano", TypeCategory.SIMPLE, dias, 0),
            Habit(3, "estudiar 2hrs", TypeCategory.DEDICATED, dias, 8),
        )
        return flow {
            prueba
        }
    }

    override suspend fun insertHabit(habit: Habit) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteHabitById(habitId: Long) {
        TODO("Not yet implemented")
    }
}

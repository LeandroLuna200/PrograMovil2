package ar.edu.unlam.mobile.scaffold.domain.habit.services

import ar.edu.unlam.mobile.scaffold.data.habit.repository.HabitRepository
import ar.edu.unlam.mobile.scaffold.domain.habit.models.Habit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HabitService @Inject constructor(val repository: HabitRepository) :
    HabitGetter {

    override suspend fun insertHabit(habit: Habit) {
        this.repository.insertHabit(habit.toHabitDB())
    }

    override suspend fun getHabit(): Flow<List<Habit>> {
//        val dias = mutableListOf<String>("D", "L", "S")
//        val prueba = mutableListOf<Habit>(
//            Habit(1, "levantarme temprano", TypeCategory.SIMPLE, dias, 0),
//            Habit(2, "levantarme temprano", TypeCategory.SIMPLE, dias, 0),
//            Habit(9, "estudiar 2hrs", TypeCategory.DEDICATED, dias, 8),
//        )
//        val prueba2 = mutableListOf<HabitLocalModel>(
//            HabitLocalModel( "levantarme temprano", TypeCategory.SIMPLE, dias, 0),
//            HabitLocalModel( "levantarme temprano", TypeCategory.SIMPLE, dias, 0),
//            HabitLocalModel( "estudiar 2hrs", TypeCategory.DEDICATED, dias, 8),
//        )

//        val pruebaBDD = this.repository.getHabits().map { habitEntities ->
//            habitEntities.map { it.name }
//        }
//        val pruebaBDD = this.repository.getHabits().map { habitEntities ->
//            habitEntities.map { it.name }
//        }
//        Log.i(
//            "BASE DE DATOS",
//            pruebaBDD.map { it }.toString(),
//        )
//        this.repository.insertHabit(prueba[2].toHabitDB())
//        Log.i(
//            "BASE DE DATOS",
//            this.repository.getHabits().collect {
//                it[0].id
//            }.toString(),
//        )
//        return flow {
//            emit(
//                prueba.map { it },
//            )
//        }
        return this.repository.getHabits()
//        return emit(Habit(1,"levantarme temprano", TypeCategory.SIMPLE, dias, 0))
//        emit(Habit(2,"levantarme temprano", TypeCategory.SIMPLE, dias, 0))
//        emit(Habit(3, "estudiar 2hrs", TypeCategory.DEDICATED, dias, 8))
    }
}

package ar.edu.unlam.mobile.scaffold.data.joke.network

import ar.edu.unlam.mobile.scaffold.domain.joke.models.Joke

data class JokeAPIModel(
    val id: String,
    val value: String,
) {
    fun toJoke(): Joke {
        return Joke(id = id, value = value)
    }
}


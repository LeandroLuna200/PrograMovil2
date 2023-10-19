package ar.edu.unlam.mobile.scaffold.data.habit.network

import ar.edu.unlam.mobile.scaffold.domain.habit.models.Joke

data class JokeAPIModel(
    val iconUrl: String,
    val id: String,
    val url: String,
    val value: String,
) {
    fun toJoke(): Joke {
        return Joke(iconUrl = iconUrl, id = id, url = url, value = value)
    }
}


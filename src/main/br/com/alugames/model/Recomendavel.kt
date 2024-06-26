package br.com.alugames.model

interface Recomendavel {
    val media: Double

    fun recomendar(nota: Int)
}
package br.com.pedro.allgames.model

interface Recomendavel {

    val media: Double

    fun recomendar(nota: Int)
}
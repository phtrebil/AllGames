package br.com.pedro.allgames.model

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int
):Plano(tipo) {
}
package br.com.pedro.allgames.model

open class Plano(
    val tipo: String
) {
    fun obterPlanoAvulso(aluguel: Aluguel): Double{
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}
package br.com.pedro.allgames.model

data class PlanoAvulso(
    val tipo: String
){
    fun obterPlanoAvulso(aluguel: Aluguel): Double{
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}

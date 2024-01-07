package br.com.pedro.allgames.model

class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
) {
    var valorDoAluguel =  gamer.plano.obterPlanoAvulso(this)
    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo} por ${gamer.nome} pelo valor R$$valorDoAluguel"
    }
}
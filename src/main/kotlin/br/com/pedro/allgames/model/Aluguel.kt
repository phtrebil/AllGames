package br.com.pedro.allgames.model

class Aluguel(
    val gamer: Gamer,
    val jogo: InfoGame
) {
    override fun toString(): String {
        return "Sr. ${gamer.nome} alugou o jogo ${jogo.info.title}"
    }
}
package br.com.pedro.allgames.model

import java.time.LocalDate
import java.time.Period
import kotlin.time.times

class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val dataInicial: LocalDate,
    val dataFinal: LocalDate
) {
    private var periodo = Period.between(dataInicial, dataFinal).days
    var valorDoAluguel =  jogo.preco * periodo
    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo} por ${gamer.nome} pelo valor R$$valorDoAluguel"
    }
}
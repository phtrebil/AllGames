package br.com.pedro.allgames.main

import br.com.pedro.allgames.model.Jogo
import br.com.pedro.allgames.model.Periodo
import br.com.pedro.allgames.services.ConsumeApi
import java.time.LocalDate

fun main() {
    val consumo = ConsumeApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.findGame("146")

//    println(listaGamers)
//    println(jogoApi)

    val gamer = consumo.buscaGamers().get(2)
    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val aluguel = gamer.alugaGame(ConsumeApi().findGame("156"), periodo)

    println(aluguel.toString())

}
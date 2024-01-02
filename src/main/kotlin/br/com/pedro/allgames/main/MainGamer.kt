package br.com.pedro.allgames.main

import br.com.pedro.allgames.model.Jogo
import br.com.pedro.allgames.services.ConsumeApi

fun main() {
    val consumo = ConsumeApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.findGame("146")

//    println(listaGamers)
//    println(jogoApi)

    val gamer = consumo.buscaGamers().get(2)
    val aluguel = gamer.alugaGame(jogoApi)

    println(aluguel.toString())

}
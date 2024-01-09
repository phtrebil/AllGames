package br.com.pedro.allgames.main

import br.com.pedro.allgames.model.Periodo
import br.com.pedro.allgames.model.PlanoAssinatura
import br.com.pedro.allgames.services.ConsumeApi
import java.time.LocalDate

fun main() {
    val consumo = ConsumeApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.buscaJogosJson()

//    println(listaGamers)
//    println(jogoApi)

    val gamer = consumo.buscaGamers().get(2)
    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(5))
    gamer.alugaGame(jogoApi[0], periodo1)
    gamer.alugaGame(jogoApi[2], periodo2)
    gamer.alugaGame(jogoApi[13], periodo3)

    println(gamer.jogosAlugados)

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3)

    gamerCamila.alugaGame(jogoApi[0], periodo1)
    gamerCamila.alugaGame(jogoApi[2], periodo2)
    gamerCamila.alugaGame(jogoApi[13], periodo3)

    println(gamerCamila.jogosAlugados)

}
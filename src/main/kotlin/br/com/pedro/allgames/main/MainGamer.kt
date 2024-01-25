package br.com.pedro.allgames.main

import br.com.pedro.allgames.model.Periodo
import br.com.pedro.allgames.model.PlanoAssinatura
import br.com.pedro.allgames.services.ConsumeApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main() {
    val consumo = ConsumeApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.buscaJogosJson()

    println(listaGamers)
    println(jogoApi)

    val gamer = consumo.buscaGamers().get(2)
    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(5))
    gamer.alugaGame(jogoApi[0], periodo1)
    gamer.alugaGame(jogoApi[2], periodo2)
    gamer.alugaGame(jogoApi[13], periodo3)

    println(gamer.jogosAlugados)

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = jogoApi.get(10)
    val jogoSpider = jogoApi.get(13)
    val jogoTheLastOfUs = jogoApi.get(2)
    val jogoDandara = jogoApi.get(5)
    val jogoAssassins = jogoApi.get(4)
    val jogoCyber = jogoApi.get(6)
    val jogoGod = jogoApi.get(7)
    val jogoSkyrim = jogoApi.get(18)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)


    println(gamerCamila.toString())

    println(gamerCamila.jogosAlugados)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)

    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)

}
package br.com.pedro.allgames.services

import br.com.pedro.allgames.extensions.criaGamer
import br.com.pedro.allgames.model.Gamer
import br.com.pedro.allgames.model.InfoGame
import br.com.pedro.allgames.model.InfoGamerJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumeApi {

    fun findGame(id: String): InfoGame {

        val json = consumeApi("https://www.cheapshark.com/api/1.0/games?id=$id")
        val gson = Gson()
        val myGame = gson.fromJson(json, InfoGame::class.java)

        return myGame
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consumeApi(endereco)

        val meuGameTipo = object : TypeToken<List<InfoGamerJson>>(){}
        val gson = Gson()
        val listaGamer = gson.fromJson(json, meuGameTipo)

        val listaConvertida = listaGamer.map {
            it.criaGamer()
        }

        return listaConvertida
    }


   private fun consumeApi(endereco: String): String{
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()

    }

}
package br.com.pedro.allgames.services

import br.com.pedro.allgames.model.InfoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumeApi {

    fun findGame(id: String): InfoGame {
        val client: HttpClient = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
            .build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()
        val gson = Gson()
        val myGame = gson.fromJson(json, InfoGame::class.java)



        return myGame


    }


}
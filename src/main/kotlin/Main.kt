import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*

fun main() {

    var meuJogo = Jogo("",  "", "")

    val read = Scanner(System.`in`)
    println("Digite o código do jogo!")
    val busca = read.nextLine()

    val client: HttpClient = HttpClient.newHttpClient()

    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$busca"))
        .build()

    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    val gson = Gson()

//    try {
//        val myGame = gson.fromJson(json, InfoGame::class.java)
//        val meuJogo = Jogo(myGame.info.title, myGame.info.thumb, "")
//        println(meuJogo)
//    } catch (e: JsonSyntaxException){
//        println("Jogo não localizado")
//    }

    val result = runCatching {
        val myGame = gson.fromJson(json, InfoGame::class.java)
        meuJogo.nome = myGame.info.title
        meuJogo.capa = myGame.info.thumb
        println(meuJogo)
    }

    result.onFailure {
        println("Jogo não localizado")
    }

    // código omitido

    result.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")

        val opcao = read.nextLine()

        if (opcao.equals("s", true)) {

            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada = read.nextLine();
            meuJogo.descricao = descricaoPersonalizada
        } else {
            meuJogo.descricao = meuJogo.nome
        }

        println(meuJogo)

    }

}




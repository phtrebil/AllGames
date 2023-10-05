package br.com.pedro.allgames.main

import br.com.pedro.allgames.model.Jogo
import br.com.pedro.allgames.services.ConsumeApi
import java.util.*

fun main() {

    do{
        val leitura = Scanner(System.`in`)
        println("Digite um código de jogo para buscar:")
        val busca = leitura.nextLine()

        val buscaApi = ConsumeApi()



        var meuJogo: Jogo? = null

        val resultado = runCatching {
            val informacaoJogo = buscaApi.findGame(busca)
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }

        resultado.onFailure {
            println("Jogo inexistente. Tente outro id.")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val opcao = leitura.nextLine()
            if (opcao.equals("s", true)) {
                println("Insira a descrição personalizado para o jogo:")
                val descricaoPersonalizada = leitura.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.nome

            }

            println(meuJogo)

        }
        println("Deseja buscar um novo jogo? S/N")

        val resposta = leitura.nextLine()
    }while (resposta.equals("s", ignoreCase = true))

    println("Busca finalizada!")

}
package br.com.pedro.allgames.main

import br.com.pedro.allgames.model.Gamer
import br.com.pedro.allgames.model.Jogo
import br.com.pedro.allgames.services.ConsumeApi
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    do {


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

                gamer.jogosBuscados.add(meuJogo)

            }

            println(meuJogo)

        }
        println("Deseja buscar um novo jogo? S/N")

        val resposta = leitura.nextLine()
    } while (resposta.equals("s", ignoreCase = true))



    println(gamer)

    gamer.jogosBuscados.sortBy {
        it?.nome
    }

    gamer.jogosBuscados.forEach {jogo ->

        println("Título: ${jogo?.nome}")
    }

    println("Deseja filtrar algum jogo na lista? S/N")
    if (leitura.nextLine().equals("s", ignoreCase = true)){
        println("Digite o nome do jogo que deseja filtrar")
        val jogosFiltrados = gamer.jogosBuscados.filter {jogo ->
            jogo?.nome?.contains("batman", ignoreCase = true)?: false

        }

        println(jogosFiltrados)
    }

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("s", true)) {
        println("\n Informe a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\n Lista atualizada:")
    println(gamer.jogosBuscados)


    println("Busca finalizada!")

}
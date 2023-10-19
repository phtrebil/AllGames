package br.com.pedro.allgames.main

import br.com.pedro.allgames.services.ConsumeApi

fun main() {
    val consumo = ConsumeApi()
    val listaGamers = consumo.buscaGamers()

    println(listaGamers)
}
package br.com.pedro.allgames.main

import br.com.pedro.allgames.extensions.toAge
import br.com.pedro.allgames.model.Gamer

fun main(){
    val gamer1 = Gamer("Pedro", "phtrebil@gmail.com.br")
    val gamer2 = Gamer("Jenni", "jeni@gmail.com", "19/09/1992", "jeniblo")

    println(gamer1)
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "12/12/1990"
        it.usuario = "phtrebil"
    }

    println(gamer1)

    println("idade do gamer = ${gamer2.dataNascimento?.toAge()}")
}
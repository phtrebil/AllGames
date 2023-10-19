package br.com.pedro.allgames.extensions

import br.com.pedro.allgames.model.Gamer
import br.com.pedro.allgames.model.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer{
    return Gamer(nome = this.nome, email = this.email, dataNascimento = this.dataNascimento, usuario = this.usuario)
}
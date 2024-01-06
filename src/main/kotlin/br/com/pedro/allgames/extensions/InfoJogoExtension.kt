package br.com.pedro.allgames.extensions

import br.com.pedro.allgames.model.InfoJogoJson
import br.com.pedro.allgames.model.Jogo
fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}

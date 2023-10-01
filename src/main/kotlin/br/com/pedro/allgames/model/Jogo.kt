package br.com.pedro.allgames.model

class Jogo(
    var nome:String,
    var capa: String,
    var descricao: String? = null
) {
    override fun toString(): String {
        return "Nome: $nome\n" +
                "Capa: $capa\n" +
                "Descrição: $descricao"
    }
}
package br.com.pedro.allgames.model

import com.google.gson.annotations.Expose

data class Jogo(
    @Expose val titulo:String,
    @Expose val capa:String
) {
    var descricao: String? = null
    var preco = 0.0
    val listaDeNotas = mutableListOf<Int>()
    val nota = listaDeNotas.average()
    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n" +
                "Preço: $preco"
    }

    fun recomendar(nota: Int) {
        listaDeNotas.add(nota)
    }
}
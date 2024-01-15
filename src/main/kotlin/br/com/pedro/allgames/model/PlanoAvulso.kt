package br.com.pedro.allgames.model

class PlanoAvulso(
    tipo: String
): Plano(tipo){
    override fun obterValor(aluguel: Aluguel): Double {
        val valorOriginal = super.obterValor(aluguel)
        val valorComDesconto = super.obterValor(aluguel) * 0.9
        if(aluguel.gamer.media > 8){
            return valorComDesconto
        }
        return valorOriginal
    }
}

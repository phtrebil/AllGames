package br.com.pedro.allgames.model

import java.math.BigDecimal

class PlanoAvulso(
    tipo: String
): Plano(tipo){
    override fun obterValor(aluguel: Aluguel): BigDecimal {
        val valorOriginal = super.obterValor(aluguel)
        val valorComDesconto = super.obterValor(aluguel) * (0.9).toBigDecimal()
        if(aluguel.gamer.media > 8){
            return valorComDesconto
        }
        return valorOriginal
    }
}

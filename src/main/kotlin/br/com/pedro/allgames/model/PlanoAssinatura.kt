package br.com.pedro.allgames.model

import java.math.BigDecimal

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val descontoReputação: Double
):Plano(tipo) {
    override fun obterValor(aluguel: Aluguel): BigDecimal {
        return if(aluguel.gamer.jogosAlugados.size+1 <= jogosIncluidos){
            BigDecimal(0.0)
        }else{
            if(aluguel.gamer.media > 8){
                return super.obterValor(aluguel) *(1 - descontoReputação).toBigDecimal()
            }
            super.obterValor(aluguel)
        }
    }
}
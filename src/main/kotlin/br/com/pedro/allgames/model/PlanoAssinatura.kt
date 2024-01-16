package br.com.pedro.allgames.model

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val descontoReputação: Double
):Plano(tipo) {
    override fun obterValor(aluguel: Aluguel): Double {
        return if(aluguel.gamer.jogosAlugados.size+1 <= jogosIncluidos){
            0.0
        }else{
            if(aluguel.gamer.media > 8){
                return super.obterValor(aluguel) *(1 - descontoReputação)
            }
            super.obterValor(aluguel)
        }
    }
}
package br.com.pedro.allgames.model

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int
):Plano(tipo) {
    override fun obterValor(aluguel: Aluguel): Double {
        return if(aluguel.gamer.jogosAlugados.size+1 <= jogosIncluidos){
            0.0
        }else{
            super.obterValor(aluguel)
        }
    }
}
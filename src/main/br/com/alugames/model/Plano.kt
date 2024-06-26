package br.com.alugames.model

sealed class Plano(tipo: String) {
   open fun obterValor(aluguel: Aluguel): Double{
        return  aluguel.jogo.preco * aluguel.periodo.emDias
    }
}
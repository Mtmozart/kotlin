package br.com.alugames.model

import java.time.LocalDate
import java.time.Period
import kotlin.time.times

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo){

    val valor:Double = gamer.plano.obterValor(this)

    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome} no valor de $valor)"
    }
}

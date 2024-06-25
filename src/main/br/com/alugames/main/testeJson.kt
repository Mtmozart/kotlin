package br.com.alugames.main

import br.com.alugames.model.Periodo
import br.com.alugames.model.PlanoAssinatura
import br.com.alugames.services.Consumer
import java.time.LocalDate

fun main(){
    val consumo = Consumer()
    val listaGamers = consumo.buscaGamers()
    val listaJogoJson = consumo.buscaJogosJson()
//    println(listGamer)

    val gamerMatheus= listaGamers.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)

    println(gamerMatheus)
    println(jogoResidentVillage)

    val dataInicial = LocalDate.of(2023, 6, 1)
    val dataFinal = LocalDate.of(2023, 6, 30)
    val periodo = Periodo(dataInicial, dataFinal)
    val aluguel = gamerMatheus.alugar(jogoResidentVillage, periodo)
    println(aluguel)

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3)
    gamerCamila.alugar(jogoResidentVillage, periodo)
    println(gamerCamila.jogosAlugados)
}
package br.com.alugames.main

import br.com.alugames.services.Consumer

fun main(){
    val consumo = Consumer()
    val listGamer = consumo.buscaGamers()
    val listaJogosJson = consumo.buscaJogosJson()
//    println(listGamer)

    val gamer1 = listGamer.get(3)
    val jogo1 = listaJogosJson.get(5)

    println(gamer1)
    println(jogo1)

    var alugar = gamer1.alugar(jogo1)
    println(alugar)
}
package br.com.alugames.main

import br.com.alugames.services.Consumer

fun main(){
    val consumo = Consumer()
    val listGamer = consumo.buscaGamers()
    println(listGamer)
}
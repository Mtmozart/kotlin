package br.com.alugames.main

import br.com.alugames.dados.Banco
import br.com.alugames.model.Jogo

fun main(){

    val listaJogos: List<Jogo> = Banco.getJogos();
    println(listaJogos)
}
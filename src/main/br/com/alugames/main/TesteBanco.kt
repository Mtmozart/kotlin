package br.com.alugames.main

import br.com.alugames.dados.JogosDao
import br.com.alugames.model.Jogo

fun main(){
    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogoDAO = JogosDao()
//    jogoDAO.adicionarJogo(jogo)

   val listaJogos: List<Jogo> = jogoDAO.getJogos()
    println(listaJogos)

}
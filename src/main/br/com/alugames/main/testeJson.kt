package br.com.alugames.main

import br.com.alugames.services.Consumer
import com.google.gson.GsonBuilder
import java.io.File

fun main(){
    val consumo = Consumer()
    val listaGamers = consumo.buscaGamers()
    val listaJogoJson = consumo.buscaJogosJson()
//    println(listGamer)

  /*  val gamerMatheus= listaGamers.get(3)

    println(gamerMatheus)
    println(jogoResidentVillage)

    val dataInicial = LocalDate.of(2023, 6, 1)
    val dataFinal = LocalDate.of(2023, 6, 30)
    val periodo = Periodo(dataInicial, dataFinal)
    val aluguel = gamerMatheus.alugaJogo(jogoResidentVillage, periodo)
    println(aluguel)

    val gamerCamila = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)
    gamerCamila.alugaJogo(jogoResidentVillage, periodo)
    gamerCamila.recomendar(7)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    println(gamerCamila.jogosAlugados)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
 println(gamerCamila.jogosRecomendados)*/
    val gamerCamila = listaGamers.get(5)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)
    val jogoSpider = listaJogoJson.get(13)
    val jogoTheLastOfUs = listaJogoJson.get(2)
    val jogoDandara = listaJogoJson.get(5)
    val jogoAssassins = listaJogoJson.get(4)
    val jogoCyber = listaJogoJson.get(6)
    val jogoGod = listaJogoJson.get(7)
    val jogoSkyrim = listaJogoJson.get(18)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)
    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)


}
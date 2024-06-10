package br.com.alugames.main

import br.com.alugames.model.Gamer
import br.com.alugames.model.Jogo
import br.com.alugames.services.Consumer
import transformAge
import java.util.*

fun main() {

    val read = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(read)
    println("Cadastro concluído com sucesso. Dados: ");
    println(gamer)
    println("Idade do gamer: " + gamer.dataNascimento?.transformAge())
    do {
        println("Digite o código de jogo para busca:")
        val busca = read.nextLine()

        val buscaApi = Consumer()
        val informacaoJogo = buscaApi.buscaJogo(busca)

        var myGame: Jogo? = null;
        val result = runCatching {
            myGame = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }
        result.onFailure {
            println("br.com.alugames.model.Jogo inexistente, tente outro id.");
        }
        result.onSuccess {
            println("Desejas inserir uma descrição personalizada ? S/N")
            val option = read.nextLine();
            if (option.equals("s", ignoreCase = true)) {
                println("Digite a descrição: ")
                val description = read.nextLine();
                myGame!!?.descricao = description;

            } else if (option.equals("n", ignoreCase = true)) {
                myGame!!?.descricao = myGame?.titulo;

            } else {
                println("Caractere inválido");
            }
            gamer.jogosBuscados.add(myGame)

        }
        println("Deseja buscar outro jogo? S/N")
        val response = read.nextLine()
    } while (response.equals("s", ignoreCase = true))

    println("Lista de jogos buscados")
    println(gamer.jogosBuscados)
    println("Jogos ordenados por título\n")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }

    gamer.jogosBuscados.forEach{
        println("Titulo: " + it?.titulo)
    }

    println("\n Jogos filtrados: ")
    println(jogosFiltrados)


    println("Busca finalizada com sucesso.")
}

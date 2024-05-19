package br.com.alugames.main

import br.com.alugames.model.Jogo
import br.com.alugames.services.Consumer
import java.util.*

fun main() {
    val read = Scanner(System.`in`)
    println("Digite o código de jogo para busca:")
    val busca = read.nextLine()

    val findGameApi = Consumer()
    var infoGame = findGameApi.search(busca);

    var myGame: Jogo? = null;
    val result = runCatching {
        myGame = Jogo(
        infoGame.info.title,
        infoGame.info.thumb
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
            println(myGame)
        } else if (option.equals("n", ignoreCase = true)) {
            myGame!!?.descricao = myGame?.titulo;
            println(myGame)
        } else {
            println("Caractere inválido");
        }
    }
    result.onSuccess {
        println("Busca finalizada com sucesso.")
    }
}

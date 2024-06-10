package br.com.alugames.utils

import br.com.alugames.model.InfoJogoJson
import br.com.alugames.model.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}
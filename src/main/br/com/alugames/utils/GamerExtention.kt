package br.com.alugames.utils

import br.com.alugames.model.Gamer
import br.com.alugames.model.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
        return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}
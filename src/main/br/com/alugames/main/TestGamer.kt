package br.com.alugames.main

import br.com.alugames.model.Gamer

fun main(){
    val gamer1 = Gamer("Matheus", "matheus@email.com");
    println(gamer1)
    val gamer2 = Gamer("MOZART", "email@email.com", "05/08/19980", "samuraiBorges")
    println(gamer2)

    //escopo function -> let, run, with and also.

    gamer1.let {
        it.dateOfBirth = "05/08/1998"
        it.user= "skywalker"

    }.also {
        gamer1.internalId
    }

    println(gamer1)
    gamer1.user = "denovo"
    println(gamer1)
}
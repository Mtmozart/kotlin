package br.com.alugames.model

import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
    var dateOfBirth: String = ""
    var user: String? = null
        set(value) {
            field = value
            if (internalId.isNullOrBlank()) {
                createInternalId()
            }
        }
    var internalId: String? = null
        private set
    val findsGame = mutableListOf<Jogo?>()

    constructor(name: String, email: String, dateOfBirth: String, user: String) : this(name, email) {
        this.dateOfBirth = dateOfBirth
        this.user = user
        createInternalId()
    }

    init {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException("Nome em branco.")
        }
        this.email = emailValidator()
    }


    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dateOfBirth='$dateOfBirth', user=$user, internalId=$internalId)"
    }

    fun createInternalId() {
        val number = Random.nextInt(100000);
        val tag = String.format("%04d", number);
        internalId = "$user#$tag"
    }


    fun emailValidator(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email;
        } else {
            throw IllegalArgumentException("Email inválido.")
        }

    }

    companion object {
        fun gamerCreate(read: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val name = read.nextLine()
            println("Digite seu e-mail:")
            val email = read.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = read.nextLine()
            if (option.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val dateOfBirth = read.nextLine()
                println("Digite seu nome de usuário:")
                val user = read.nextLine()

                return Gamer(
                    name,
                    email,
                    dateOfBirth,
                    user
                )
            }
            return Gamer(
                name,
                email
            )
        }
    }
}

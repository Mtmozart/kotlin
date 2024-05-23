package br.com.alugames.model

import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
    var dateOfBirth: String = ""
    var user: String? = null
        set(value){
            field = value
            if (internalId.isNullOrBlank()){
                createInternalId()
            }
        }
    var internalId: String? = null
        private set


    constructor(name: String, email: String, dateOfBirth: String, user: String) : this(name, email) {
        this.dateOfBirth = dateOfBirth
        this.user = user
        createInternalId()
    }
    init {
        if(name.isNullOrBlank()){
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
        if(regex.matches(email)){
            return email;
        } else{
            throw IllegalArgumentException("Email inválido.")
        }

    }
}

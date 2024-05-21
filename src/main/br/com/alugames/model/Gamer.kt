package br.com.alugames.model

import kotlin.random.Random

data class Gamer(var name: String, var email:String){
    var dateOfBirth: String = ""
    var user:String? = null;
    var internalId:String? = null;

    constructor(name: String, email: String, dateOfBirth:String, user:String): this(name, email){
        this.dateOfBirth = dateOfBirth
        this.user = user
        createInternalId()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dateOfBirth='$dateOfBirth', user=$user, internalId=$internalId)"
    }

    fun createInternalId(){
        val number = Random.nextInt(100000);
        val tag = String.format("%04d", number);
        internalId ="$user#$tag"
    }


}

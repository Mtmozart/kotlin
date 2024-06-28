package br.com.alugames.model

import com.google.gson.annotations.Expose

data class Jogo(@Expose val titulo:String,
               @Expose val capa:String): Recomendavel {
    var descricao: String? = null
    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()
    var preco = 0.0
    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }
    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }
    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao" +
                "Preço: $preco"
    }
}
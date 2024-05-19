package br.com.alugames.model

data class Jogo(val titulo: String, val capa: String) {

    var descricao:String? = null
    override fun toString(): String {
        return "Meu br.com.alugames.model.Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }


}
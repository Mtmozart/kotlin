package br.com.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "jogos")
class JogoEntity(
    val titulo: String = "título do jogo",
    val capa: String = "capa do jogo",
    val preco: Double = 0.0,
    val descricao: String? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {

}
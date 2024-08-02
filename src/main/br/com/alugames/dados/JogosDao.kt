package br.com.alugames.dados

import br.com.alugames.model.Jogo
import javax.persistence.EntityManager

class JogosDao( manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {
    override fun toEntity(objeto: Jogo): JogoEntity {
        return JogoEntity(objeto.titulo, objeto.capa, objeto.preco, objeto.descricao, objeto.id)
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return  Jogo(
            entity.titulo,
            entity.capa,
            entity.preco,
            entity.descricao,
            entity.id
        )
    }

}


package br.com.alugames.dados

import br.com.alugames.model.Plano
import br.com.alugames.model.PlanoAssinatura
import br.com.alugames.model.PlanoAvulso
import javax.persistence.EntityManager

class PlanosDao(manager: EntityManager): DAO<Plano, PlanoEntity>(
    manager, PlanoEntity::class.java
) {
    override fun toModel(entity: PlanoEntity): Plano {
        return if(entity is PlanoAssinaturaEntity){
            PlanoAssinatura(entity.tipo, entity.mensalidade,entity.jogosIncluidos, entity.percentualDescontoReputacao, entity.id)
        } else {
            PlanoAvulso(entity.tipo )
        }
    }

    override fun toEntity(plano: Plano): PlanoEntity {
        return if (plano is PlanoAssinatura) {
            PlanoAssinaturaEntity(
                plano.tipo,
                plano.mensalidade,
                plano.jogosIncluidos,
                plano.percentualDescontoReputacao
            )
        } else {
            PlanoAvulsoEntity(plano.tipo, plano.id)
        }
    }
}
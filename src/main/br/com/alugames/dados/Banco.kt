package br.com.alugames.dados

import br.com.alugames.model.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "M.atheus2")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }


}
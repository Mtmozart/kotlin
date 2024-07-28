package br.com.alugames.dados

import br.com.alugames.model.Jogo

class JogosDao {
    fun getJogos(): List<Jogo> {
        val listaJogo = mutableListOf<Jogo>()
        val conexao = Banco.obterConexao();
        if (conexao != null){
            try {
                val statement = conexao.createStatement()
                val resultado = statement.executeQuery(
                    "SELECT * FROM jogos"
                );
                while (resultado.next()) {
                    val id = resultado.getInt("id")
                    val titulo = resultado.getString("titulo")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val preco = resultado.getDouble("preco")
                    val jogo = Jogo(titulo, capa, preco, descricao)
                    listaJogo.add(jogo)
                }

                statement.close()

            } finally {
                conexao.close()

            }
        }
        return listaJogo
    }

    fun adicionarJogo(jogo: Jogo) {
        val conexao = Banco.obterConexao();
        val insert = "INSERT INTO jogos (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?, ?, ?, ?)"
        if(conexao != null){
            try {
                val statement = conexao.prepareStatement(insert)
                statement.setString(1, jogo.titulo)
                statement.setString(2, jogo.descricao)
                statement.setDouble(3, jogo.preco)
                statement.setString(4, jogo.descricao)
                statement.close()
            }
            finally {
                conexao.close()
            }
        }
    }
}
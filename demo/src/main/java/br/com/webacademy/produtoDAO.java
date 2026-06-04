package br.com.webacademy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class produtoDAO {
    public void salvar(produto produto) throws Exception {
            var sql = "insert into produto" + "(nome, quantidade, valor) Values (?, ? ,? )";
        try (var conn = conexao.obterConexao(); var stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, produto.nome());
                stmt.setInt(2,produto.quantidade());
                stmt.setDouble(3,produto.valor());
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new Exception(e);
            }
        }    
    
    public List<produto> buscarTodos() throws Exception {
        var sql = "select * from produto";
        List<produto> produtos = new ArrayList<>();

        try (var conn = conexao.obterConexao();
             var stmt = conn.prepareStatement(sql);
             var rs = stmt.executeQuery()) {

            while (rs.next()) {
                produto produto = new produto(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getInt("quantidade"),
                    rs.getDouble("valor")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return produtos;
    } 


    public produto buscarPorId(Long id) throws Exception {
        var sql = "select * from produto where id = ?";
       produto produto = null;
        try (var conn = conexao.obterConexao();
                var stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()){
              while (rs.next()) {
               produto = new produto(
                    rs.getLong("id"),rs.getString("nome"),
                    rs.getInt("quantidade"), rs.getDouble("valor"));
                }
            }
        } catch (SQLException e) {
            throw new Exception(e);
            }
    return produto;
    } 

    public void atualizar(produto produto) throws Exception{
        var sql = "update produto set nome = ?" + "quantidade = ? , valor = ? , where id = ?";
        try (var conn  = conexao.obterConexao();
            var stmt = conn.prepareStatement(sql)        
        ){
            stmt.setString(1, produto.nome());
            stmt.setInt(2,produto.quantidade());
            stmt.setDouble(3,produto.valor());
            stmt.setLong(4, produto.id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void excluir (long id) throws Exception {
        var sql = "delete from produto where id = ?";
        try (var conn = conexao.obterConexao();
            var stmt = conn.prepareStatement(sql)) {
                stmt.setLong(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                throw new Exception(e);
            }
    }

}

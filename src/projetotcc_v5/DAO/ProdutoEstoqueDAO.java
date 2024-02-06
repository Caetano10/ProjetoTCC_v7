/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotcc_v5.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projetotcc_v5.ConnectionFactory;
import projetotcc_v5.modelo.Fornecedor;
import projetotcc_v5.modelo.ProdutoEstoque;

/**
 *
 * @author lab
 */
public class ProdutoEstoqueDAO {

    public Connection connection;

    public ProdutoEstoqueDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionar(ProdutoEstoque produto, Fornecedor f) {
        String sql = "insert into LRProduto_Estoque(nome, codBarras, "
                + " quantidade,dataEntrada,idFornecedorFK) values(?,?,?,?,(select idFornecedor from LRfornecedor where nomeFantasia=?));";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProd());
            stmt.setString(2, produto.getCodBarras());
            stmt.setInt(3, produto.getQtde());
            stmt.setString(4, produto.getDataEntrada());
            stmt.setString(5, f.getNomeFantasia());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void alterar(ProdutoEstoque produto, Fornecedor f) {
        String sql = "update LRProdutoEstoque set nome=?, coddBarras=?, "
                + "quantidade=?,dataEntrada=?"
                + " where idProduto=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, produto.getNomeProd());
            stmt.setString(2, produto.getCodBarras());
            stmt.setInt(3, produto.getQtde());
            stmt.setString(4, produto.getDataEntrada());
            stmt.setInt(5, (int) produto.getIdProdEstoque());
            
//            f.setIdFornecedor(rs.getInt("idFornecedor"));
//            f.setNomeFantasia(rs.getString("nomeFantasia"));
//            f.setCnpj(rs.getString("cnpj"));
//            f.setTelefone(rs.getString("telefone"));
//
//            f.setDataCadastro(rs.getString("dataCadastro"));

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProdutoEstoque> listaProduto(ProdutoEstoque p, String campo, String inf) {
        try {
            List<ProdutoEstoque> produtos = new ArrayList<ProdutoEstoque>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from listaProduto where " + campo + " like '%" + inf + "%'");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                p.setIdProdEstoque(rs.getInt("idProduto"));
                p.setNomeProd(rs.getString("nome"));
                p.setQtde(rs.getInt("quantidade"));
                p.setCodBarras(rs.getString("codbarras"));
                p.setDataEntrada(rs.getString("dataentrada"));
                f.setNomeFantasia(rs.getString("nomeFantasia"));
                f.setCnpj(rs.getString("cnpj"));
                f.setDataCadastro(rs.getString("datacadastro"));
                p.setFornecedor(f);
                produtos.add(p);
            }
            rs.close();
            stmt.close();
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

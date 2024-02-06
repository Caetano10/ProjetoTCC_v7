package projetotcc_v5.DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projetotcc_v5.ConnectionFactory;
import projetotcc_v5.modelo.Endereco;
import projetotcc_v5.modelo.Fornecedor;

/**
 *
 * @author lab
 */
public class FornecedorDAO {

    public Connection connection;

    public FornecedorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Fornecedor f, Endereco e) {
        try {
            String sql = "{call inserirFornecedor(?,?,?,?,?,?,?,?,?,?,?)};";
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, f.getNomeFantasia());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3, f.getTelefone());
            stmt.setString(4, e.getUnidadeFederal());
            stmt.setString(5, e.getCep());
            stmt.setString(6, e.getCidade());
            stmt.setString(7, e.getComplemento());
            stmt.setString(8, e.getRua());
            stmt.setInt(9, e.getLogradouroNum());
            stmt.setString(10, e.getBairro());
            stmt.registerOutParameter(11, Types.NVARCHAR);
            stmt.execute();
            JOptionPane.showMessageDialog(null, stmt.getString(11));
            stmt.close();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }

    public void alterar(Fornecedor f, Endereco e) {

        try {
            String sql = "{call alterarFornecedor(?,?,?,?,?,?,?,?,?,?,?,?)};";
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, (int) f.getIdFornecedor());
            stmt.setString(2, f.getNomeFantasia());
            stmt.setString(3, f.getCnpj());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, e.getUnidadeFederal());
            stmt.setString(6, e.getCidade());
            stmt.setString(7, e.getBairro());
            stmt.setString(8, e.getRua());
            stmt.setInt(9, e.getLogradouroNum());
            stmt.setString(10, e.getCep());
            stmt.setString(11, e.getComplemento());
            stmt.registerOutParameter(12, Types.NVARCHAR);
            stmt.execute();

            JOptionPane.showMessageDialog(null, stmt.getString(12));
            stmt.close();

        } catch (SQLException error) {
            throw new RuntimeException(error);
        }

    }

    public void remover(Fornecedor f) {
        String sql = "{call removerFornecedor(?,?)}";
        try {
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, (int) f.getIdFornecedor());
            stmt.registerOutParameter(2, Types.NVARCHAR);
            stmt.execute();

            JOptionPane.showMessageDialog(null, stmt.getString(2));
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void pesquisar(Fornecedor f, Endereco e, String campo, String inf) {
        String sql = "SELECT * FROM selecionarFornecedor where " + campo + " like "
                + "'%" + inf + "%';";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                f.setIdFornecedor(rs.getInt("idFornecedor"));
                f.setNomeFantasia(rs.getString("nomeFantasia"));
                f.setCnpj(rs.getString("cnpj"));
                f.setTelefone(rs.getString("telefone"));
                f.setDataCadastro(rs.getString("dataCadastro"));
                e.setUnidadeFederal(rs.getString("uf"));
                e.setCidade(rs.getString("cidade"));
                e.setBairro(rs.getString("bairro"));
                e.setRua(rs.getString("rua"));
                e.setLogradouroNum(rs.getInt("logradouroNum"));
                e.setCep(rs.getString("CEP"));
                e.setComplemento(rs.getString("complemento"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
    public List<Fornecedor> listar (String campo, String inf){
            try{
                List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
                PreparedStatement stmt = this.connection.prepareStatement("select * from LRFornecedor where " + campo + " like '%" + inf + "%'");
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    Fornecedor f = new Fornecedor();
                    f.setIdFornecedor(rs.getInt("idFornecedor"));
                    f.setNomeFantasia(rs.getString("nomeFantasia"));
                    f.setCnpj(rs.getString("cnpj"));
                    f.setTelefone(rs.getString("telefone"));
                    
                    
                    f.setDataCadastro(rs.getString("dataCadastro"));
                    fornecedores.add(f);
                }
                rs.close();
                stmt.close();
                return fornecedores;
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        } 
         public List<Fornecedor> listar2 (){
            try{
                List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
                PreparedStatement stmt = this.connection.prepareStatement("select * from LRFornecedor");
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    Fornecedor f = new Fornecedor();
                    f.setIdFornecedor(rs.getInt("idFornecedor"));
                    f.setNomeFantasia(rs.getString("nomeFantasia"));
                    f.setCnpj(rs.getString("cnpj"));
                    f.setTelefone(rs.getString("telefone"));
                    
                    
                    f.setDataCadastro(rs.getString("dataCadastro"));
                    fornecedores.add(f);
                }
                rs.close();
                stmt.close();
                return fornecedores;
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        } 
         
}

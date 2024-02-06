package projetotcc_v5.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projetotcc_v5.ConnectionFactory;
import projetotcc_v5.modelo.Endereco;
import projetotcc_v5.modelo.Funcionario;
import projetotcc_v5.modelo.Login;

public class FuncionarioDAO {

    public Connection connection;

    public FuncionarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Funcionario f, Endereco e) {
        try {
            String sql = "{call inserirFuncionario(?,?,?,?,?,?,?,?,?,?,?,?)};";
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setString(3, f.getDataNascimento());
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

    public boolean logar(Login l) {
        String sql = "select login, senha from LRLogin where login=? && senha=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, l.getLogin());
            stmt.setString(2, l.getSenha());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void alterar(Funcionario f, Endereco e) {
             String sql = "{call alterarFuncionario(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            try {
                CallableStatement stmt = connection.prepareCall(sql);
                stmt.setInt(1, (int)f.getIdFuncionario());
                stmt.setString(2, f.getNome());
                stmt.setString(3, f.getCpf());
                stmt.setString(4, f.getDataNascimento());
                stmt.setString(5, f.getTelefone());
                stmt.setString(6, e.getUnidadeFederal());
                stmt.setString(7, e.getCidade());
                stmt.setString(8, e.getBairro());
                stmt.setString(9, e.getRua());
                stmt.setInt(10, e.getLogradouroNum());
                stmt.setString(11, e.getCep());
                stmt.setString(12, e.getComplemento());
                stmt.registerOutParameter(12, Types.NVARCHAR);
                stmt.execute();
                
                JOptionPane.showMessageDialog(null, stmt.getString(12));
                stmt.close();
            } catch (SQLException error) {
                throw new RuntimeException(error);
            }
        }
    
    public void remover(Funcionario f) {
        String sql = "{call removerFuncionario(?,?)}";
        try{
            CallableStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, (int)f.getIdFuncionario());
            stmt.registerOutParameter(2, Types.NVARCHAR);
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, stmt.getString(2));
            stmt.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
      public void pesquisar(Funcionario f, Endereco e, String campo, String inf){
        String sql = "SELECT * FROM selecionarFuncionario where " + campo + " like "
                + "'%" + inf + "%';";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                f.setIdFuncionario(rs.getInt("idFuncionario"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("CPF"));
                f.setDataCadastro(rs.getString("dataCadastro"));
                f.setDataNascimento(rs.getString("dataNascimento"));
                f.setTelefone(rs.getString("telefone"));
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
        } catch(SQLException error){
            throw new RuntimeException(error);
        }
    }
      
      public void alterarSenhaPrimeiraVez (Login l){
          String sql = "{call alterarSenhaPrimVez(?,?,?,?,?)}";
          try {
              CallableStatement stmt = connection.prepareCall(sql);
              stmt.setString(1, l.getLogin());
              stmt.setString(2, l.getSenha());
              stmt.setString(3, l.getPerguntaSecreta());
              stmt.setString(4, l.getRespostaSecreta());
              stmt.registerOutParameter(5, Types.NVARCHAR);
              stmt.execute();
              JOptionPane.showMessageDialog(null, stmt.getString(5));
              stmt.close();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
      public List<Funcionario> listar(String campo, String inf) {
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from LRFuncionario where " + campo + " like '%" + inf + "%'");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idFuncionario"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setTelefone(rs.getString("telefone"));
                f.setDataNascimento(rs.getString("dataNascimento"));
                f.setDataCadastro(rs.getString("dataCadastro"));
                funcionarios.add(f);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
      
}

       


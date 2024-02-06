package projetotcc_v5.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import projetotcc_v5.modelo.Cliente;
import projetotcc_v5.ConnectionFactory;
import projetotcc_v5.modelo.Entrada;

public class ClienteDAO {
    public Connection connection;
        public ClienteDAO() {
            this.connection = new ConnectionFactory().getConnection();
        }

        public void adicionar(Cliente cliente) {
            String sql = "insert into LRCliente(nome, cpf, " +
                    " telefone, celular,dataNascimento) values(?,?,?,?,?);";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getTelefone());
                stmt.setString(4, cliente.getCelular());
                stmt.setString(5, cliente.getDataNascimento());
                stmt.execute();
                stmt.close();
            } catch(SQLException e) {
                throw new RuntimeException(e);
            }

        }
        
        public void pesquisar (String campo, String inf, Cliente cliente){
            try {
                String sql = "select * from LRCliente where " + campo + " like '%"
                        + inf + "%';";
                PreparedStatement stmt = this.connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    cliente.setIdCliente(rs.getInt("idCliente"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setCelular(rs.getString("celular"));
                    cliente.setDataNascimento(rs.getString("dataNascimento"));
                    cliente.setDtcadastro(rs.getDate("datacadastro"));
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        public void alterar(Cliente cliente) {
            String sql = "update LRCliente set nome=?, cpf=?, "
                    + "telefone=?,celular=?, dataNascimento=?"
                    + " where idCliente=?;";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCpf());
                stmt.setString(3, cliente.getTelefone());
                stmt.setString(4, cliente.getCelular());
                stmt.setString(5, cliente.getDataNascimento());
                stmt.setInt(6, (int)cliente.getIdCliente());
                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        public void remover(Cliente cliente) {
            String sql = "call removerCliente(?,?)";
            try {
                CallableStatement stmt = connection.prepareCall(sql);
                stmt.setInt(1, (int)cliente.getIdCliente());
                stmt.registerOutParameter(2, Types.NVARCHAR);
                stmt.execute();
                JOptionPane.showMessageDialog(null, stmt.getString(2));
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        public List<Cliente> listar (String campo, String inf){
            try{
                List<Cliente> clientes = new ArrayList<Cliente>();
                PreparedStatement stmt = this.connection.prepareStatement("select * from lrcliente where " + campo + " like '%" + inf + "%'");
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    Cliente c = new Cliente();
                    c.setIdCliente(rs.getInt("idCliente"));
                    c.setNome(rs.getString("nome"));
                    c.setCpf(rs.getString("cpf"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setCelular(rs.getString("celular"));
                    c.setDataNascimento(rs.getString("dataNascimento"));
                    c.setDtcadastro(rs.getString("dataCadastro"));
                    clientes.add(c);
                }
                rs.close();
                stmt.close();
                return clientes;
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
        
        public void sistFidlPorDtNasc(Cliente cliente, String mes, String dia){
            String sql = "SELECT * FROM LRCLIENTE WHERE dataNascimento LIKE'%-"+mes+"-"+dia+"%';";
            try{
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    cliente.setIdCliente(rs.getInt("idCliente"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setCelular(rs.getString("celular"));
                    cliente.setDataNascimento(rs.getString("dataNascimento"));
                    cliente.setDtcadastro(rs.getDate("datacadastro"));
                }
                rs.close();
                stmt.close();
            } catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
        
        public void sistFidlPorDtCad(Cliente cliente, String dtcad){
            String sql = "SELECT * FROM LRCLIENTE WHERE (TIMESTAMPDIFF(DAY, dataCadastro, NOW())) > " + dtcad +";" ;
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    cliente.setIdCliente(rs.getInt("idCliente"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setCelular(rs.getString("celular"));
                    cliente.setDataNascimento(rs.getString("dataNascimento"));
                    cliente.setDtcadastro(rs.getDate("datacadastro"));
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
            }
        }
        
        public void entradaPorCliente(Cliente c, Entrada e){
            String sql = "";
        }
        
        public void gerarRelCli(String cpf){
            try{
                Map parametros = new HashMap();
                parametros.put("cpf", cpf);
                JasperPrint print = JasperFillManager.fillReport(
                    "src/projetotcc_v5/relatorio/CarroCliente.jasper",
                        parametros,
                        connection);
                JasperViewer jv = new JasperViewer(print, false);
                jv.setTitle("Carros de Clientes");
                jv.setVisible(true);
            } catch(JRException erro){
                throw new RuntimeException(erro);
            }
        } 
        public void gerarRelNasc(String dataini, String dataFim){
            try{
                Map parametros = new HashMap();
                parametros.put("dataini", dataini);
                parametros.put("dataFim", dataFim);
                JasperPrint print = JasperFillManager.fillReport(
                    "src/projetotcc_v5/relatorio/SistemaFidelidadeDataNasc.jasper",
                        parametros,
                        connection);
                JasperViewer jv = new JasperViewer(print, false);
                jv.setTitle("Carros de Clientes");
                jv.setVisible(true);
            } catch(JRException erro){
                throw new RuntimeException(erro);
            }
        } 
}

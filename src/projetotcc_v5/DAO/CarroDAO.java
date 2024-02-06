/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetotcc_v5.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projetotcc_v5.ConnectionFactory;
import projetotcc_v5.modelo.Carro;
import projetotcc_v5.modelo.Cliente;

/**
 *
 * @author lab
 */
public class CarroDAO {
    public Connection connection;
        public CarroDAO() {
            this.connection = new ConnectionFactory().getConnection();
        }

        public void adicionar(Carro c) {
            String sql = "insert into LRCarro(placaVeiculo, nomeVeiculo, " +
                    " corVeiculo, observacoes , detalhesLavagem, idClienteFK) values(?,?,?,?,?,?);";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, c.getPlacaVeiculo());
                stmt.setString(2, c.getNomeVeiculo());
                stmt.setString(3, c.getCorVeiculo());
                stmt.setString(4, c.getObservacoes());
                stmt.setString(5, c.getDetalhesLavagem());
                stmt.setInt(6, (int)c.getIdClienteFK());
                stmt.execute();
                stmt.close();
            } catch(SQLException e) {
                throw new RuntimeException(e);
            }

        }
        
        public List<Carro> listar (String campo, String inf){
            try{
                List<Carro> carros = new ArrayList<Carro>();
                PreparedStatement stmt = this.connection.prepareStatement("select * from lrcarro where " + campo + " like '%" + inf + "%'");
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) {
                    Carro c = new Carro();
                    c.setIdCarro(rs.getInt("IdCarro"));
                    c.setPlacaVeiculo(rs.getString("PlacaVeiculo"));
                    c.setNomeVeiculo(rs.getString("NomeVeiculo"));
                    c.setCorVeiculo(rs.getString("CorVeiculo"));
                    c.setObservacoes(rs.getString("Observacoes"));
                    c.setDetalhesLavagem(rs.getString("DetalhesLavagem"));
                    c.setIdClienteFK(rs.getString("IdClienteFK"));
                    carros.add(c);
                }
                rs.close();
                stmt.close();
                return carros;
            } catch (SQLException e){
                throw new RuntimeException(e);
            }
        } 
        
        public void pesquisar (String campo, String inf, Carro c){
            try {
                String sql = "select * from LRCarro where " + campo + " like '%"
                        + inf + "%';";
                PreparedStatement stmt = this.connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    c.setIdCarro(rs.getInt("idCarro"));
                    c.setPlacaVeiculo(rs.getString("placaVeiculo"));
                    c.setNomeVeiculo(rs.getString("nomeVeiculo"));
                    c.setCorVeiculo(rs.getString("corVeiculo"));
                    c.setObservacoes(rs.getString("observacoes"));
                    c.setDetalhesLavagem(rs.getString("detalhesLavagem"));
                    c.setIdClienteFK(rs.getInt("idClienteFK"));
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}

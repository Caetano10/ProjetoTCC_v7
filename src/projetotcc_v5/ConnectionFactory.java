package projetotcc_v5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        System.out.println("Connectando com o banco de dados...");
        try {
            return
                    DriverManager.getConnection("jdbc:mysql://127.0.0.1/BancoLavaRapido",
                                                        "btcc", "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[]args) {
        new ConnectionFactory().getConnection();
        System.out.println("Conexão criada com sucesso.");
    }
}

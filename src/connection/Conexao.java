package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/sistema_clientes";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConexao() {
        try {
                Properties properties = carregarConfiguracao();

                String url = properties.getProperty("db.url");
                String user = properties.getProperty("db.user");
                String password = properties.getProperty("db.password");

                return DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Properties carregarConfiguracao() {
        Properties properties = new Properties();

        try {
            FileInputStream arquivo = new FileInputStream("config.properties");
            properties.load(arquivo);
            arquivo.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
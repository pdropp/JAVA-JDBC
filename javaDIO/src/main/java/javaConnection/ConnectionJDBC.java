package javaConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionJDBC {

    private ConnectionJDBC(){
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection() {

        Connection connection = null;

        try (InputStream input = ConnectionJDBC.class.getClassLoader().getResourceAsStream("connection.proprietes")){
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String DataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");


            //String de conexão

            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(DataBaseName).append("?useTimezone=true&serverTimezone=UTC");

            String connectionUrl = sb.toString();

            //Criar conexão usando o DriverManager, passando como parâmetro a String de conexão, usuário e senha
            try  {
                connection = DriverManager.getConnection(connectionUrl, user, password);
                System.out.println("Conexão feita com sucesso");

            } catch (SQLException e) {
                System.out.println("Falha ao se conectar com o banco");
               throw new RuntimeException(e);
            }

        } catch (IOException e) {
            System.out.println("Falha a obter informações");
            e.printStackTrace();
        }



        return connection;
    }
}


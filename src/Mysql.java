import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql {
    public static boolean authenticate(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/biblotecawissen";
        String user = "root";
        String pass = "Jcorito85";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            String query = "SELECT * FROM usuario WHERE nombreUsuario = user AND claveUsuario = pass";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}

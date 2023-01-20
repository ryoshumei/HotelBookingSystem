import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLTutorial {
    public static void main(String[] args){
        System.out.println("Hello Java");
        String url = "jdbc:mysql://localhost:3306/mystore";
        //jdbc:mysql://[ホスト名]:[ポート番号]/[データベース名]
        String username = "root";
        String password = "lll129647";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class phase1ParserMain {
    public static void main(String[] args) {
        phase1Parser parse = new phase1Parser();
        parse.populateData();
        
        //test line 
        parse.getDistance("New York", "Los Angeles");
        
        
        String url = "jdbc:mysql://localhost:3306/javabase";
        String username = "java";
        String password = "javapassword";
        
        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}

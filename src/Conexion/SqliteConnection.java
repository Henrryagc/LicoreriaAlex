
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;

/**
 *
 * @author henrry
 */
public class SqliteConnection {
    
    private Connection connection = null;
    
    private SqliteConnection() {
    }
    
    public static SqliteConnection getInstance() {
        return SqliteConnectionHolder.INSTANCE;
    }
    
    private static class SqliteConnectionHolder {
        private static final SqliteConnection INSTANCE = new SqliteConnection();
    }
    
    public Connection connect() {
        
        try {
            // db parameters
            String url = "jdbc:sqlite:db/licoreriadb.db";
            // create a connection to the database
            connection = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return connection;
    }
    
    public void disconnect() throws SQLException {
        if(connection != null) {
            connection.close();
        } 
    }
    
}

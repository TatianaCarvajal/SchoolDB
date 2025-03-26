package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tatianacarvajal
 */
public class ConnectionImplementor implements PersistenceRepository {

    Connection connect = null;

    String user = "root";
    String password = "Tatianacv123";
    String db = "school_db";
    String ip = "localhost";
    String port = "3306";

    String path = "jdbc:mysql://" + ip + ":" + port + "/" + db;
    
    public ConnectionImplementor() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(path, user, password);
        } catch (Exception e) {
            System.out.println("Error to connect with the database: " + e.toString());
        }
    }

    @Override
    public void createStudent(int id, String name, String surname) {

    }
}

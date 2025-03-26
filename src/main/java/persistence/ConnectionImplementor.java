package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import model.Student;


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
            System.out.println("Connected successfully ");
        } catch (Exception e) {
            System.out.println("Error to connect with the database: " + e.toString());
        }
    }

    @Override
    public boolean createStudent(Student student) {
        try {
            String query = "insert into students (name,surname) values (?,?);";
            CallableStatement statement = connect.prepareCall(query);

            statement.setString(1, student.getStudentName());
            statement.setString(2, student.getStudentSurname());
            statement.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error to insert new variables: " + e.toString());
            return false;
        }
    }
}

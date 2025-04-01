package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

    @Override
    public ArrayList<Student> readStudent() {
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            String query = "SELECT * FROM students;";
            PreparedStatement statement = connect.prepareCall(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");

                Student student = new Student(id, name, surname);
                students.add(student);
            }
        } catch (Exception e) {
            System.out.println("Error to show the table: " + e.toString());
        }
        return students;
    }

    @Override
    public boolean updateStudent(Student student) {
        try {
            String query = "update students set name = ?, surname = ? where id = ?;";
            CallableStatement statement = connect.prepareCall(query);

            statement.setString(1, student.getStudentName());
            statement.setString(2, student.getStudentSurname());
            statement.setInt(3, student.getStudentCode());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error to update the student: " + e.toString());
            return false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        try {
            String query = "delete from students where students.id = ?;";
            CallableStatement statement = connect.prepareCall(query);

            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error to delete the student: " + e.toString());
            return false;
        }
    }
}

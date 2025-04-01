package persistence;

import java.util.ArrayList;
import model.Student;

/**
 *
 * @author tatianacarvajal
 */
public interface PersistenceRepository {
    
    public boolean createStudent(Student student);
    public ArrayList<Student> readStudent();
    public boolean updateStudent(Student student);
}

package persistence;

import model.Student;

/**
 *
 * @author tatianacarvajal
 */
public interface PersistenceRepository {
    
    public boolean createStudent(Student student);
    
}

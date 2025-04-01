package igu;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Student;

/**
 *
 * @author tatianacarvajal
 */
public class StudentTableModel extends AbstractTableModel {

    ArrayList<Student> students;
    private final String[] columns = {"Id", "Name", "Surname"};

    public StudentTableModel(ArrayList<Student> stundents) {
        this.students = stundents;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getStudentCode();
            case 1:
                return student.getStudentName();
            case 2:
                return student.getStudentSurname();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}

package model;

/**
 *
 * @author tatianacarvajal
 */
public class Student {

    int studentCode;
    String studentName;
    String studentSurname;

    public Student(int studentCode, String studentName, String studentSurname) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }
}

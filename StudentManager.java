import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void setStudents(List<Student> list) {
        this.students = list;
    }

    // ✅ ADD THIS: Display all students (console output)
    public void displayAllStudents() {
        for (Student s : students) {
            s.displayStudent();
            System.out.println("----------------------");
        }
    }

    // ✅ ADD THIS: Find and display by ID
    public void searchAndDisplay(String id) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                s.displayStudent();
                return;
            }
        }
        System.out.println("Student not found.");
    }
}

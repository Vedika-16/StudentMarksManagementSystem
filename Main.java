import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n===== Student Marks Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.next();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter number of subjects: ");
                    int n = sc.nextInt();
                    int[] marks = new int[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter mark for subject " + (i + 1) + ": ");
                        marks[i] = sc.nextInt();
                    }
                    Student s = new Student(id, name, marks);
                    manager.addStudent(s);
                    break;

                case 2:
                    manager.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String searchId = sc.next();
                    manager.searchAndDisplay(searchId);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

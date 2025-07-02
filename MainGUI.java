import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MainGUI {
    private static final String CSV_FILE = "students.csv";

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        JFrame frame = new JFrame("Student Marks Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField marksField = new JTextField(20);  // Comma-separated

        JTextArea displayArea = new JTextArea(12, 50);
        displayArea.setEditable(false);

        JButton addButton = new JButton("Add Student");
        JButton showButton = new JButton("Show All");
        JButton saveButton = new JButton("Save to CSV");
        JButton loadButton = new JButton("Load from CSV");

        frame.add(new JLabel("ID:")); frame.add(idField);
        frame.add(new JLabel("Name:")); frame.add(nameField);
        frame.add(new JLabel("Marks (comma separated):")); frame.add(marksField);
        frame.add(addButton); frame.add(showButton);
        frame.add(saveButton); frame.add(loadButton);
        frame.add(new JScrollPane(displayArea));

        addButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String[] markStrs = marksField.getText().split(",");
            int[] marks = new int[markStrs.length];
            try {
                for (int i = 0; i < markStrs.length; i++) {
                    marks[i] = Integer.parseInt(markStrs[i].trim());
                }
                Student s = new Student(id, name, marks);
                manager.addStudent(s);
                displayArea.append("Added: " + name + "\n");
                idField.setText(""); nameField.setText(""); marksField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid marks format.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        showButton.addActionListener(e -> {
            displayArea.setText("");
            for (Student s : manager.getAllStudents()) {
                displayArea.append("ID: " + s.getId() + ", Name: " + s.getName()
                        + ", Total: " + s.getTotalMarks()
                        + ", Avg: " + s.getAverageMarks()
                        + ", Grade: " + s.getGrade() + "\n");
            }
        });

        saveButton.addActionListener(e -> {
            StudentCSVUtil.saveToCSV(manager.getAllStudents(), CSV_FILE);
            JOptionPane.showMessageDialog(frame, "Data saved to " + CSV_FILE);
        });

        loadButton.addActionListener(e -> {
            List<Student> loaded = StudentCSVUtil.loadFromCSV(CSV_FILE);
            manager.setStudents(loaded);
            JOptionPane.showMessageDialog(frame, "Data loaded from " + CSV_FILE);
        });

        frame.setVisible(true);
    }
}

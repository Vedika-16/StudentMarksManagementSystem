import java.io.*;
import java.util.*;

public class StudentCSVUtil {
    public static void saveToCSV(List<Student> students, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Student s : students) {
                pw.println(s.toCSV());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> loadFromCSV(String filename) {
        List<Student> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Student.fromCSV(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

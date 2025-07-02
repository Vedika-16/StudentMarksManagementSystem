public class Student {
    private String id;
    private String name;
    private int[] marks;

    public Student(String id, String name, int[] marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks;
    }

    // Calculate total marks
    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Calculate average
    public double getAverageMarks() {
        return getTotalMarks() / (double) marks.length;
    }

    // Grade based on average
    public String getGrade() {
        double avg = getAverageMarks();
        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else return "F";
    }

    // For console version
    public void displayStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.print("Marks: ");
        for (int m : marks) {
            System.out.print(m + " ");
        }
        System.out.println("\nTotal: " + getTotalMarks());
        System.out.println("Average: " + String.format("%.2f", getAverageMarks()));
        System.out.println("Grade: " + getGrade());
    }

    // Convert student to CSV line
    public String toCSV() {
        StringBuilder sb = new StringBuilder(id + "," + name);
        for (int mark : marks) {
            sb.append(",").append(mark);
        }
        return sb.toString();
    }

    // Parse student from CSV line
    public static Student fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        String id = parts[0];
        String name = parts[1];
        int[] marks = new int[parts.length - 2];
        for (int i = 2; i < parts.length; i++) {
            marks[i - 2] = Integer.parseInt(parts[i]);
        }
        return new Student(id, name, marks);
    }
}

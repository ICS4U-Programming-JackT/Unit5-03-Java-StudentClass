import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

final class Main {
    /** Private constructor to prevent instantiation. */
    private Main() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Create tree and call its methods.
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        try {
            // Create file, scanner and empty array list
            File file = new File("input.txt");
            Scanner fileScanner = new Scanner(file);

            // Go through each line to add to student array
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(" ");
                // Add student instance based on number of name parts
                if (parts.length == 4) {
                    // Set each name part before passing into constructor
                    String firstName = parts[0];
                    String lastName = parts[1];
                    int grade = Integer.parseInt(parts[2]);
                    boolean hasIEP = Boolean.parseBoolean(parts[3]);
                    Student student = new Student(firstName,
                                lastName, grade, hasIEP);
                    students.add(student);
                } else if (parts.length == 5) {
                    // Set each name part before passing into constructor
                    String firstName = parts[0];
                    String middleName = parts[1];
                    String lastName = parts[2];
                    int grade = Integer.parseInt(parts[3]);
                    boolean hasIEP = Boolean.parseBoolean(parts[4]);
                    Student student = new Student(firstName,
                                middleName, lastName, grade, hasIEP);
                    students.add(student);
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Write student info to output file line by line
        try {
            FileWriter writer = new FileWriter("output.txt");
            for (Student stu : students) {
                writer.write(stu.getStudentInfo() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            // File write error
            System.out.println("Error writing to file: output.txt");
        }
    }
}

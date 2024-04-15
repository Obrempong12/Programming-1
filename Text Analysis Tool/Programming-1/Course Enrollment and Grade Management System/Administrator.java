import java.util.Scanner;

public class Administrator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    enrollStudent(scanner);
                    break;
                case 3:
                    assignGrade(scanner);
                    break;
                case 4:
                    calculateOverallGrade(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add a new course");
        System.out.println("2. Enroll a student");
        System.out.println("3. Assign a grade");
        System.out.println("4. Calculate overall course grade for a student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addCourse(Scanner scanner) {
        System.out.print("Enter course code: ");
        String courseCode = scanner.next();
        System.out.print("Enter course name: ");
        String courseName = scanner.next();
        System.out.print("Enter max capacity: ");
        int maxCapacity = scanner.nextInt();

        CourseManagement.addCourse(courseCode, courseName, maxCapacity);
        System.out.println("Course added successfully.");
    }

    private static void enrollStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.next();
        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Enter course code to enroll in: ");
        String courseCode = scanner.next();

        CourseManagement.enrollStudent(studentName, studentId, courseCode);
        System.out.println("Student enrolled successfully.");
    }

    private static void assignGrade(Scanner scanner) {
        // Implement logic to assign a grade
    }

    private static void calculateOverallGrade(Scanner scanner) {
        // Implement logic to calculate overall course grade for a student
    }
}

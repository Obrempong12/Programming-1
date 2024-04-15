import java.util.ArrayList;
import java.util.List;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        Course newCourse = new Course(courseCode, courseName, maxCapacity);
        courses.add(newCourse);
    }

    public static void enrollStudent(String studentName, int studentId, String courseCode) {
        Student student = findOrCreateStudent(studentName, studentId);
        Course course = findCourseByCode(courseCode);

        if (course != null && !isCourseFull(course)) {
            student.enrollInCourse(course);
        } else {
            System.out.println("Course is full or does not exist.");
        }
    }

    public static void assignGrade(String studentName, int studentId, String courseCode, int grade) {
        // Implement logic to assign a grade for a course
    }

    public static void calculateOverallGrade(String studentName, int studentId) {
        // Implement logic to calculate overall course grade for a student
    }

    private static Student findOrCreateStudent(String studentName, int studentId) {
        for (Student student : students) {
            if (student.getName().equals(studentName) && student.getId() == studentId) {
                return student;
            }
        }

        Student newStudent = new Student(studentName, studentId);
        students.add(newStudent);
        return newStudent;
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static boolean isCourseFull(Course course) {
        return Course.getTotalEnrolledStudents() >= course.getMaxCapacity();
    }
}
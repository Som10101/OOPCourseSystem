import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    List<Course> courses;
    EnrollmentManager enrollment;

    // Constructor
    public Admin(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.userType = "Admin";
        this.courses = new ArrayList<>();
        this.enrollment = new EnrollmentManager();
    }

    public void addCourses(String courseName, String description, String code) {
        Course newCourse = new Course(courseName, description, code);
        courses.add(newCourse);
        enrollment.addNewCourse(courseName, description, code);
        System.out.println("Course '" + courseName + "' has been added successfully.");
    }
    public void deleteCourses(String code) {
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course.getCourseCode().equals(code)) {
                courses.remove(i);
                enrollment.deleteCourse(course.getCourseName());
                System.out.println("Course '" + course.getCourseName() + "' has been removed successfully.");
                return;
            }
        }
        System.out.println("Course with code '" + code + "' was not found.");
    }

    @Override
    public void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("Available Courses:");
            for (Course course : courses) {
                System.out.println(" - " + course.getCourseName() + " (Code: " + course.getCourseCode() + ")");
            }
        }
    }

    // Additional getters and setters (if needed)
}

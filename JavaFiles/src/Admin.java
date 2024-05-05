import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    

    // Constructor
    public Admin(String name, String username, String password) {
        super(name, username, password);
        this.userType = "Admin";
    }

    public void addCourse(String courseName, String description, String code, Professor professor) {
        Course newCourse = new Course(courseName, description, code, professor);
        enrollment.addCourse(newCourse);
        System.out.println("Course '" + courseName + "' has been added successfully.");
    }
    public void deleteCourseByCode(String code) {
        Course c = enrollment.getCourseByCode(code);
        if(c == null)
        {
            System.out.println("Course with code '" + code + "' was not found.");
        }
        else
        {
        	enrollment.removeCourse(c);
        }
    }
    
    public void deleteCourseByName(String name) {
        Course c = enrollment.getCourseByName(name);
        if(c == null)
        {
            System.out.println("Course with name '" + name + "' was not found.");
        }
        else
        {
        	enrollment.removeCourse(c);
        }
    }

    @Override
    public void viewCourses() 
    {
        enrollment.printCourseOptions();
    }

    // Additional getters and setters (if needed)
}

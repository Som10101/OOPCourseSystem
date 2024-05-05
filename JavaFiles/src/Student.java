import java.util.ArrayList;

public class Student extends User
{
	ArrayList<Course> coursesEnrolled;
	
    public Student(String name, String username, String password) {
        super(name, username, password);
        coursesEnrolled = new ArrayList<Course>();
        this.userType = "Student";
    }
	
	void viewCourses() 
	{
		for(int i = 0; i < coursesEnrolled.size(); i++)
		{
			Course c = coursesEnrolled.get(i);
			c.printCourse();
			System.out.println("Current Grade: " + c.getGrade(this) +"%");
		}
		System.out.println("-------------------------------------");
	}
	public int unEnroll(Course c)
	{
		c.removeStudent(this); 
		
		for(int i = 0; i < coursesEnrolled.size(); i++)
		{
			if(coursesEnrolled.get(i).equals(c))
			{
				coursesEnrolled.remove(i);
				return 0;
			}
		}
		return -1;
	}
	void enroll(Course c)
	{
		c.addStudent(this);
		coursesEnrolled.add(c);
	}

}

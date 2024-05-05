import java.util.ArrayList;

public class Professor extends User
{
	ArrayList<Course> coursesTaught;
	
	public Professor(String name, String username, String password) {
        super(name, username, password);
        coursesTaught = new ArrayList<Course>();
        this.userType = "Professor";
    }
	
	public int leaveCourse(Course c)
	{
			for(int i = 0; i < coursesTaught.size(); i++)
			{
				if(coursesTaught.get(i).equals(c))
				{
					coursesTaught.remove(i);
					return 0;
				}
			}
			return -1;
	}
	
	void viewCourses() 
	{
		// TODO Auto-generated method stub
		
	}
	
	void viewStudents(Course C)
	{
		
	}
	
	

}

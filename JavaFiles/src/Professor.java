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
	
	public int changeGrade(Course C, String name, int grade)
	{
		Student s = C.getStudent(name);
		if(s != null)
		{
			C.setGrade(s, grade);
			return 0;
		}
		else
			return -1;
			
	}
	public Course getTaughtCourseByName(String name)
	{	
		for(int i = 0; i < coursesTaught.size(); i++)
		{
			if(coursesTaught.get(i).getCourseName().equals(name))
			{
				return coursesTaught.get(i);
			}		
		}
		return null;
	}
	
	public Course getTaughtCourseByCode(String code)
	{
		for(int i = 0; i < coursesTaught.size(); i++)
		{
			if(coursesTaught.get(i).getCourseCode().equals(code))
			{
				return coursesTaught.get(i);
			}		
		}
		return null;
	}
	
	
	void viewCourses() 
	{	

		System.out.println("Courses taught by this professor");
		System.out.println("-------------------------------------");
		for(int i = 0; i < coursesTaught.size(); i++){
			
			System.out.println(coursesTaught.get(i).getCourseName());

		}
	}
	
	void viewStudents(Course C)
	{
		ArrayList <Pair> temp=C.getStudents();
		System.out.println("The students of this course are:");
		System.out.println("----------------------------------");
		for (int i=0;i<temp.size();i++){
			System.out.println(temp.get(i).getStudent().getName());
		}
			
	}
	
	
	

}

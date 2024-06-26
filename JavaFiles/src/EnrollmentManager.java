import java.util.ArrayList;

public class EnrollmentManager 
{
	public static EnrollmentManager eM = null;
	ArrayList<Course> CourseOffering;
	
	EnrollmentManager()
	{
		CourseOffering = new ArrayList<Course>();
	}
	
	public void addCourse(Course c)
	{
		CourseOffering.add(c);
	}

	public int removeCourse(Course c)
	{
		for(int i = 0; i < CourseOffering.size(); i++)
		{
			if(CourseOffering.get(i).equals(c))
			{
				Course cl = CourseOffering.remove(i);
				cl.clearClass();
				return 0;
			}
		}
		return -1;
	}
	
	public static EnrollmentManager getManager()
	{
		if(eM == null)
		{
			eM = new EnrollmentManager();
		}
		return eM;
	}
	
	
	public void printCourseOptions()
	{
		Course c;
		for(int i = 0; i < CourseOffering.size(); i++)
		{
			c = CourseOffering.get(i);
			System.out.println("-------------------------------------");
			System.out.println(c.getCourseName() + "       " + c.getCourseCode());
			System.out.println("Professor: " + c.getProfessor().getName());
			System.out.println("Description: " + c.getCourseDescription());
		}
		System.out.println("-------------------------------------");
	}
	
	public Course getCourseByName(String name)
	{	
		for(int i = 0; i < CourseOffering.size(); i++)
		{
			if(CourseOffering.get(i).getCourseName().equals(name))
			{
				return CourseOffering.get(i);
			}		
		}
		return null;
	}
	
	public Course getCourseByCode(String code)
	{
		for(int i = 0; i < CourseOffering.size(); i++)
		{
			if(CourseOffering.get(i).getCourseCode().equals(code))
			{
				return CourseOffering.get(i);
			}		
		}
		return null;
	}
	
	
}

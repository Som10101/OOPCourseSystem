import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	static ArrayList<User> users;
	static EnrollmentManager E;
	static Scanner s;
	public static void main(String[] args) 
	{
		users = new ArrayList<User>();
		E = EnrollmentManager.getManager();
		s = new Scanner(System.in);
		Student s = new Student("Joe","h","h");
		Professor p = new Professor("Bob","p","w");
		Admin a = new Admin("Barb","pe","wa");
		users.add(a);
		users.add(p);
		users.add(s);
		a.addCourse("Bible study", "Learning", "HX3", p);
		s.enroll(E.getCourseByName("Bible study"));
		System.out.println("Hello");
		menu(p);
		
	}
	
	User createUser(int c)
	{
		User u = null;
		String pW= "";
		String uN= "";
		String name = "";
		switch(c)
		{
		case(1):
			u = new Admin(name,uN,pW);
			break;
		case(2):
			u = new Professor(name,uN,pW);
			break;
		case(3):
			u = new Student(name,uN,pW);
			break;
		}
			
		users.add(u);
		return u;
		
	}

	User login()
	{
		User u = null;
		String userName = "";
		for(int i = 0; i < users.size(); i++)
		{
			if(users.get(i).getUsername().equals(userName))
				u = users.get(i);
		}
		
		if(u == null)
				return null;
		
		String password = "";
		if(u.loginVerification(password))
			return u;
		else
			return null;
	}
	static void selectedCourse(Professor p, Course course)
	{
		System.out.println("----" + course.getCourseName() + "----" );
		System.out.println();
	
		int choice = 0;
		do
		{
			System.out.println("(1) View Students");
			System.out.println("(2) Change Student Grade");
			System.out.println("(3) Exit");
			System.out.println();
			String c = s.nextLine();
			try {
			    choice = 
			    		
			    		Integer.parseInt(c);
			} catch (NumberFormatException e) {
			    choice = -1;
			}
			switch(choice)
			{
			//view Students
			case(1):
				course.printStudentList();
				break;
			//change grade
			case(2):
				System.out.print("Please enter name of student: ");
				String name = s.nextLine();
				System.out.print("Please enter grade: ");
				c = s.nextLine();
				int g;
				try {
				    g = Integer.parseInt(c);
				} catch (NumberFormatException e) {
				    System.out.println("Enter a number please.");
				    break;
				}
				if(p.changeGrade(course, name, g) == 0)
					System.out.println("Grade changed!");
				else
					System.out.println("Error- grade not changed.");
				break;
			case(3):
				System.out.println("exiting...");
				break;
			default:
				System.out.println("Please enter valid option.");
				break;
			}
		}
		while(choice != 3);
	}
	
	static void menu(Professor p)
	{
		
		int choice = 0;
		do
		{
			System.out.println("(1) View Courses");
			System.out.println("(2) Select Course by Code");
			System.out.println("(3) Select Course by Name");
			System.out.println("(4) Log Out");
			String c = s.nextLine();
			try {
			    choice = 
			    		
			    		Integer.parseInt(c);
			} catch (NumberFormatException e) {
			    choice = -1;
			}
			switch(choice)
			{
			//View courses
			case(1):
				p.viewCourses();
				break;
				//select course by code
			case(2):
				System.out.print("Please enter code:");
				String code = "";
				code = s.nextLine();
				Course cc = p.getTaughtCourseByCode(code);
				if(cc != null)
				{
					selectedCourse(p,cc);
				}
				else
				{
					System.out.println("Course not found.");
				}

				break;
			//select course by name
			case(3):
				System.out.print("Please enter name:");
				String name = "";
				name = s.nextLine();
				Course cn = p.getTaughtCourseByName(name);
				if(cn != null)
				{
					selectedCourse(p,cn);
				}
				else
				{
					System.out.println("Course not found.");
				}

				break;
			case(4):
				System.out.println("Logging out... Thank you!");
				break;
			default:
				System.out.println("Please enter valid option.");
				break;
			}
		}
		while(choice != 4);
		
	}
	
	
	static void menu(Admin a)
	{
		System.out.println("(1) Add Course");
		System.out.println("(2) Delete Course by Code");
		System.out.println("(3) Delete Course by Name");
		System.out.println("(4) View All Courses");
		System.out.println("(5) View All Courses");
		System.out.println("(6) Log Out");
		int choice = 0;
		do
		{
			String c = s.nextLine();
			try {
			    choice = 
			    		
			    		Integer.parseInt(c);
			} catch (NumberFormatException e) {
			    choice = -1;
			}
			switch(choice)
			{
			//add Course
			case(1):
				System.out.print("Please enter course name:");
				String cN = s.nextLine();
				System.out.print("Please enter course code:");	
				String cC = s.nextLine();
				System.out.print("Please enter course description:");	
				String cD = s.nextLine();
				System.out.println("-------Professor List-------");
				listProfessors();
				System.out.println("---------------------------");
				System.out.print("Please enter the course's professor, drawing from the list above.");
				String prof = s.nextLine();
				int index = -1;
				for(int i = 0; i < users.size(); i++)
				{
					if(users.get(i).getName().equalsIgnoreCase(prof) && users.get(i).getUserType().equals("Professor"))
						index = i;
				}
				
				if(index == -1)
					System.out.println("Professor not found. Course creation failed.");
				else
				{
					a.addCourse(cN,cD,cC,(Professor)users.get(index));
					System.out.println("Course added successfully!");
				}
				
				break;
			//Delete course by code
			case(2):
				System.out.print("Please enter code for deletion: ");
				String code = s.nextLine();
				a.deleteCourseByCode(code);
				break;
			//delete course by name
			case(3):
				System.out.print("Please enter name for deletion: ");
				String name = s.nextLine();
				a.deleteCourseByName(name);
				break;
			//view all courses
			case(4):
				a.viewCourses();
				break;
			//view all professors
			case(5):
				System.out.println("*******Professors*******");
				for(int i = 0; i < users.size(); i++)
				{
					if(users.get(i).getUserType().equals("Professor"))
						System.out.println("-" + users.get(i).getName());
				}
				break;
			case(6):
				System.out.println("Logging out... Thank you!");
				break;
			default:
				System.out.println("Please enter valid option.");
				break;
			}
		}
		while(choice != 6);
	}
	
	static void listProfessors()
	{
		for(int i = 0; i < users.size(); i++)
		{
			if(users.get(i).getUserType().equals("Professor"))
				System.out.println("-" + users.get(i).getName());
			
		}
	}
	
	
	

}

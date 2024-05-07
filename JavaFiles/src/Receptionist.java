import java.util.ArrayList;
import java.util.Scanner;

public class Receptionist 
{
	static Receptionist R = null;
	 ArrayList<User> users;
	 EnrollmentManager E;
	 Scanner s;
	public Receptionist(Scanner Scan)
	{
		s = Scan;
		users = new ArrayList<User>();
		E = EnrollmentManager.getManager();
		
		createPreexistingData();
	}
	
	public static Receptionist getReceptionist(Scanner scan)
	{
		if(R == null)
		{
			R = new Receptionist(scan);
		}
		R.setScanner(scan);
		return R;
	}
	
	User createUser()
	{
		System.out.println("------Create New User------");
		User u = null;
		System.out.print("Name: ");
		String name = s.nextLine();
		System.out.print("Username: ");
		String uN= s.nextLine();
		System.out.print("Password: ");
		String pW= s.nextLine();

		int choice = 0;
		do
		{
			System.out.println("(1) Admin");
			System.out.println("(2) Professor");
			System.out.println("(3) Student");
			System.out.println();
			String c = s.nextLine();
			try {
			    choice = Integer.parseInt(c);
			} catch (NumberFormatException e) {
			    choice = -1;
			    System.out.println("Please select a number 1-3.");
			}
		}
		while(choice > 3 || choice < 1);
		
		
		switch(choice)
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
		System.out.println("*********LOGIN***********");
		User u = null;
		System.out.print("Please enter Username: ");
		String userName = s.nextLine();
		for(int i = 0; i < users.size(); i++)
		{
			if(users.get(i).getUsername().equals(userName))
				u = users.get(i);
		}
		
		if(u == null)
				return null;
		System.out.print("Please enter Password: ");
		String password = s.nextLine();
		if(u.loginVerification(password))
		{
			System.out.println();
			System.out.println("Welcome " + u.getName());
			System.out.println();
			return u;
			
		}
		else
		{
			System.out.println("Incorrect password.");
			return null;
			
		}
	}
	void selectedCourse(Professor p, Course course)
	{
		System.out.println("----" + course.getCourseName() + "----" );
		System.out.println();
	
		int choice = 0;
		do
		{
			System.out.println();
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
	
	void menu(Student stu)
	{
		
		int choice = 0;
		do
		{
			System.out.println();
			System.out.println("(1) View All Courses");
			System.out.println("(2) Enroll in Course by Code");
			System.out.println("(3) Enroll in Course by Name");
			System.out.println("(4) View Enrolled Courses");
			System.out.println("(5) Un-enroll in Course by Code");
			System.out.println("(6) Un-enroll in Course by Name");
			System.out.println("(7) Log Out");
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
				stu.viewCourses();
				break;
				//select course by code
			case(2):
				System.out.print("Please enter code:");
				String code = "";
				code = s.nextLine();
				Course cc = E.getCourseByCode(code);
				if(cc != null)
				{
					stu.enroll(cc);
					System.out.println("Sucessfully enrolled!");
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
				Course cn = E.getCourseByName(name);
				if(cn != null)
				{
					stu.enroll(cn);
					System.out.println("Sucessfully enrolled!");
				}
				else
				{
					System.out.println("Course not found.");
				}

				break;
			case(4):
				stu.viewEnrolledCourses();
				break;
			case(5):
				System.out.print("Please enter code:");
				String uCode = "";
				uCode = s.nextLine();
				Course uc = E.getCourseByCode(uCode);
				if(uc != null)
				{
					if(stu.unEnroll(uc) == 0)
						System.out.println("Course Unenrolled from.");
					else
						System.out.println("Error- Student not enrolled in course.");
				}
				else
				{
					System.out.println("Course not found.");
				}

				break;
			//select course by name
			case(6):
				System.out.print("Please enter name:");
				String uName = "";
				uName = s.nextLine();
				Course un = E.getCourseByName(uName);
				if(un != null)
				{
					if(stu.unEnroll(un) == 0)
						System.out.println("Course Unenrolled from.");
					else
						System.out.println("Error- Student not enrolled in course.");
				}
				else
				{
					System.out.println("Course not found.");
				}
	
				break;
			case(7):
				System.out.println("Logging out... Thank you!");
				break;
			
			default:
				System.out.println("Please enter valid option.");
				break;
			}
		}
		while(choice != 7);
		
	}
	
	void menu(Professor p)
	{
		
		int choice = 0;
		do
		{
			System.out.println();
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
	
	
	void menu(Admin a)
	{

		int choice = 0;
		do
		{
			System.out.println();
			System.out.println("(1) Add Course");
			System.out.println("(2) Delete Course by Code");
			System.out.println("(3) Delete Course by Name");
			System.out.println("(4) View All Courses");
			System.out.println("(5) View All Professors");
			System.out.println("(6) Log Out");
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
	
	void listProfessors()
	{
		for(int i = 0; i < users.size(); i++)
		{
			if(users.get(i).getUserType().equals("Professor"))
				System.out.println("-" + users.get(i).getName());
			
		}
	}
	
	void createPreexistingData() {

        Professor prof1 = new Professor("Alice", "alice01", "abc123");
        Professor prof2 = new Professor("Bob", "bob02", "def248");
        Professor prof3 = new Professor("Charlie", "charlie03", "qwe456");

        Admin admin = new Admin("Dana", "dana05", "admin123");

        Student student1 = new Student("Eve", "eve1", "asd789");
        Student student2 = new Student("Frank", "frank2", "password");
        Student student3 = new Student("Grace", "grace1", "password2");
        Student student4 = new Student("Heidi", "heidi2", "password3");
        Student student5 = new Student("Ivan", "ivan5", "password4");

		Course c1 = new Course("Algorithms", "Learn about basic algorithms", "MATH101", prof1);
		Course c2 = new Course("Physics", "Intro to Physics", "PHYS101", prof2);
		Course c3 = new Course("Philosophy", "Intro to Philosophy", "PHIL101", prof3);


		E.addCourse(c1);
		E.addCourse(c2);
		E.addCourse(c3);

		student1.enroll(c1);
		student1.enroll(c3);
		student2.enroll(c2);
		student3.enroll(c3);
		student4.enroll(c1);
		student5.enroll(c2);
		

        users.add(prof1);
        users.add(prof2);
        users.add(prof3);
        users.add(admin);
        users.add(student1);
        users.add(student2);
        users.add(student3);
        users.add(student4);
        users.add(student5);
    }
	
	void setScanner(Scanner scan)
	{
		this.s = scan;
	}
	

}


public abstract class User 
{
	String username;
	String password;
	String userType;
	String name;
	
	boolean loginVerification(String pw)
	{
		if(password.equals(pw))	
			return true;
		else
			return false;	
	}
	
	abstract void viewCourses();
	
	
}

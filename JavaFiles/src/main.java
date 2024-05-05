import java.util.ArrayList;

public class main 
{
	static ArrayList<User> users;
	static EnrollmentManager E;
	public static void main(String[] args) 
	{
		users = new ArrayList<User>();
		E = EnrollmentManager.getManager();
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
	
	void menu(Admin a)
	{
		
	}
	
	
	
	
	

}

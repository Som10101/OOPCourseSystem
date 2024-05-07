import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	
	public static void main(String[] args) 
	{
			Scanner s = new Scanner(System.in);
			Receptionist R = new Receptionist(s);
		
			int choice = 0;
			do
			{
				System.out.println("(1) Login");
				System.out.println("(2) Create Account");
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
				//Login
				case(1):
					User u = R.login();
					if(u == null)
					{
						continue;
					}
					else if(u.getUserType().equals("Admin"))
					{
						R.menu((Admin)u);
					}
					else if(u.getUserType().equals("Professor"))
					{
						R.menu((Professor)u);
					}
					else if(u.getUserType().equals("Student"))
					{
						R.menu((Student)u);
					}
					break;
				case(2):
					R.createUser();
					break;
				case(3):
					System.out.println("Good Bye! Thank You.");
					break;
				default:
					System.out.println("Please enter valid option.");
					break;
				}
			}
			while(choice != 3);
			s.close();
		
	}

}

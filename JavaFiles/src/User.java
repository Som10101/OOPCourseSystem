
public abstract class User 
{
	
	EnrollmentManager enrollment;
	
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.enrollment = EnrollmentManager.getManager();
    }
	
	boolean loginVerification(String pw)
	{
		if(password.equals(pw))	
			return true;
		else
			return false;	
	}
	
	abstract void viewCourses();
	
	String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String password;
	String userType;
	String name;
	
}

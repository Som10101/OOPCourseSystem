
public class Pair 
{
	public final Student student;
	public int grade;
	public Pair(Student s,int g)
	{
		this.grade = g;
		this.student = s;
	}
	
	@Override
    public boolean equals(Object o) 
	{
		if(o == this)
			return true;
		
		if(student.equals(o))
				return true;
		
		return false;
					
	}
	
}

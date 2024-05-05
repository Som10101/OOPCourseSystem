import java.util.ArrayList;

public class Course 
{
	private String courseName;
	private String courseDescription;
	private String courseCode;
	private Professor Professor;
	private ArrayList<Pair> studentList;
	
	public int addStudent(Student s)
	{
		if(studentList.contains(s))
			return 0;
		else
		{
			Pair p = new Pair(s,100);
			studentList.add(p);
			
		}
		return 1;
	}
	
	public Student removeStudent(Student s)
	{
		
		for(int i = 0; i < studentList.size(); i++)
		{
			if(studentList.get(i).student.equals(s))
			{
				Pair p;
				p = studentList.remove(i);
				return p.student;
			}
		}
		return null;
	}

	public int setGrade(Student s, int g)
	{
		for(int i = 0; i < studentList.size(); i++)
		{
			if(studentList.get(i).student.equals(s))
			{
				studentList.get(i).grade = g;
				return 0;
			}
		}
		return -1;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public User getProfessor() {
		return Professor;
	}

	public void setProfessor(Professor professor) {
		Professor = professor;
	}
	
}

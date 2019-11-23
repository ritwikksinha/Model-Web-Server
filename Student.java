/*
 * Provide a default constructor, a parameterized constructor, getters and setters.
 * Fill implementation of toString, hashCode and equals.
 */
public class Student {
	
	String name;
	String PID;
	String major;
	String minor;
	Double CGPA;
	String college;
	String email;
	/*Student Constructor (Unparametrized)
 	 *Creates objects of Student class with each object variable set to it's default value.
 	 **/ 	

	public Student()
	{
		name = null;
		PID = null;
		major = null;
		minor = null;
		CGPA = 0.0;
		college = null;
		email = null;
	}
	/*Student Constructor (Parametrized)
 	 *Creates objects of Student class.
 	 **/ 	
	public Student(String name,String PID, String major, String minor, Double CGPA, String college, String email)
	{//Student constructor. All variables contain the respective detail of the student.(eg: name contains name).
		this.name = name;
		this.PID = PID;
		this.major = major;
		this.minor = minor;
		this.CGPA = CGPA;
		this.college = college;
		this.email = email;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public String getPID()
	{
		return PID;
	}
	
	public void setPID(String PID)
	{
		this.PID = PID;
	}
	
	public String getMajor()
	{
		return major;
	}
	
	public void setMajor(String major)
	{
		this.major = major;
	}

	public String getMinor()
	{
		return minor;
	}
	
	public void setMinor(String minor)
	{
		this.minor = minor;
	}
	
	public double getCGPA()
	{
		return CGPA;
	}
	
	public void setCGPA(Double cgpa)
	{
		this.CGPA = cgpa;
	}
	
	public String getCollege()
	{
		return college;
	}
	
	public void setCollege(String college)
	{
		this.college = college;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString() {
		//Converts all the students details into a String.
		String details = "name:" + name + "|PID:" + PID + "|major:" + major;
		details += "|minor:" + minor + "|CGPA:" + String.format("%6f",CGPA);
		details += "|college:" + college + "|email:" + email;
		return details;
	}
	
	@Override
	public int hashCode() {
		//Hashcodes just use PID since this is unique to each student.
		return PID.hashCode();
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		//Checks if given object equals this object.
		boolean check = false;
		Student object = (Student) obj;
		if(PID.equals(object.getPID()))
		{
			check = true;
		}
		return check;
	}
}

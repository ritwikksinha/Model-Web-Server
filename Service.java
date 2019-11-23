/**
 *@author	Ritwik K Sinha
 *@version	3
 *@since	2/20/2019
 * */


import java.lang.*;
import java.util.*;

public class Service implements IService {
	
	private IDatabase database;
	private List<Student> studList;
	@SuppressWarnings("unchecked")
	public void loadDb()
	{//Loads the database.
		studList = (List<Student>)database.loadDb();
	}
	public void updateDb()
	{//Updates database.
		loadDb();
		database.updateDb(studList);
	}
	public Student getStudent(Student student)
	{//Finds a student in the database and returns it.
		loadDb();
		Student output = null;
		for(int i = 0; i<studList.size();i++)
		{
			if(student.equals(studList.get(i)))
			{
				output = studList.get(i);
			}
		}
		return output;
	}
	public boolean addStudent(Student student)
	{//Adds given student to database.
		loadDb();
		boolean check = false;
		if(student.getPID()!=null)//Checking if PID exists.
		{
			try
			{
				int pid = Integer.valueOf(student.getPID());
			}
			catch(Exception e)
			{
				return check;
			}
			if(getStudent(student)==null)
			{//Adding if it doesn't
				check = true;
				studList.add(student);
			}
			else
			{//Updating if it does.
				check = !(updateStudent(student));
			}
		}
		else if((student.getName()!=null)&&(student.getEmail()!=null))
		{
			int largest = Integer.valueOf(studList.get(studList.size()-1).getPID());
			try
			{
				largest+=1;
			}//Adding one to the largest existing PID.
			catch(Exception e)
			{
				System.out.println("No PID available");
			}
			student.setPID(String.valueOf(largest));
			studList.add(student);
			check = true;

		}
		updateDb();
		return check;
	}
	public boolean removeStudent(Student student)
	{
		loadDb();
		boolean check = false;
		if(getStudent(student)==null)
		{
			check = true;
		}
		else
		{
			check = true;
			studList.remove(getStudent(student));
		}
		updateDb();
		return check;
	}
	public boolean updateStudent(Student student)
	{
		loadDb();
		boolean check = false;
		if(getStudent(student)!=null)
		{
			check = true;
			studList.set(studList.indexOf(student),student);
			
		}
		updateDb();
		return check;
	}
	public List<Student> getAllStudent()
	{
		loadDb();
		return studList;
	}
	
	public IDatabase getDatabase()
	{
		loadDb();
		return database;
	}
	public void setDatabase(IDatabase database)
	{
		this.database = database;
		updateDb();
	}



}

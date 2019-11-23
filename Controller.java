/**
 *@author	Ritwik K Sinha
 *@version	3
 *@since	2/20/2019
 * */


import java.util.*;

public class Controller implements IController {

	private IService service;
	private IResponse response;
	public IService getService()
	{
		return service;
	}
	public void setService(IService service)
	{
		this.service = service;
	}
	public IResponse getResponse()
	{
		return response;
	}
	public void setResponse(IResponse response)
	{
		this.response = response;
	}

	public IResponse getStudent(Student student)
	{//Uses service to get student from database.
		if(student.getPID()==null)
		{
			response.setResponseCode(400);
			response.setResponseString("BAD_REQUEST");
		}
		else if(service.getStudent(student)==null)
		{
			response.setResponseCode(404);
			response.setResponseString("NOT_FOUND");
		}
		else if(service.getStudent(student)!=null)
		{
			response.setResponseCode(200);
			response.setResponseString("OK");
			response.setContent(service.getStudent(student));
		}
		else
		{
			response.setResponseCode(400);
			response.setResponseString("BAD_REQUEST");
		}
		return response;
	}
	@SuppressWarnings("unchecked")
	public IResponse addStudent(Student student)
	{//Uses service to add student to database.
		if(student.getPID()!=null)
		{
			boolean check = service.addStudent(student);
			if(check)
			{
				response.setResponseCode(201);
				response.setResponseString("CREATED");
			}
			else if(!check)
			{
				response.setResponseCode(202);
				response.setResponseString("ACCEPTED");
			}
		}
		else if((student.getName()!=null)&&(student.getEmail()!=null))
		{
			boolean check = service.addStudent(student);
			response.setResponseCode(201);
			response.setResponseString("CREATED");
		}
		else
		{
			response.setResponseCode(400);
			response.setResponseString("BAD_REQUEST");
		}
		return response;
	}
	
	public IResponse removeStudent(Student student)
	{//Uses service to remove student from database.
		boolean check = service.removeStudent(student);
		if(check)
		{
			response.setResponseCode(200);
			response.setResponseString("OK");
		}
		else
		{
			response.setResponseCode(400);
			response.setResponseString("BAD_REQUEST");

		}
		return response;
	}
	
	public IResponse updateStudent(Student student)
	{//Uses service to update a student in the database.
		if(student.getPID()!=null)
		{
			boolean check = service.updateStudent(student);
			if(check)
			{
				response.setResponseCode(20);
				response.setResponseString("OK");

			}
			else
			{
				response.setResponseCode(404);
				response.setResponseString("NOT_FOUND");
			}
		}
		else
		{
			response.setResponseCode(400);
			response.setResponseString("BAD_REQUEST");
		}
		return response;
	}
	@SuppressWarnings("unchecked")	
	public IResponse getAllStudent()
	{
		ArrayList<Student>studs = (ArrayList<Student>)service.getAllStudent();
		if(studs.size()>0)
		{
			response.setResponseCode(200);
			response.setResponseString("OK");
			response.setListContent(studs);
		}
		else
		{
			response.setResponseCode(404);
			response.setResponseString("NOT_FOUND");
			response.setListContent(studs);
		}
		return response;
	}


	
}

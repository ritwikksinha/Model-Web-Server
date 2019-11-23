/**
 *@author	Ritwik K Sinha
 *@version	3
 *@since	2/20/2019
 * */


import java.util.*;

public class StudentResponseObj extends BaseResponse implements IResponse {

	private Student content;
	private List<Student> listContent;
	
	public StudentResponseObj()
	{
		content = new Student();
		listContent = new ArrayList<Student>();
	}
	public Object getContent()
	{
		return content;
	}
	public void setContent(Object obj)
	{
		if(obj instanceof Student)
		{
			content = (Student)obj;
		}
	}
	public Object getListContent()
	{
		return listContent;
	}

	@SuppressWarnings("unchecked")
	public void setListContent(Object obj)
	{
		if(obj instanceof List)
		{
			listContent = (List<Student>)obj;
		}
	}
}

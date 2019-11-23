/**
 *@author	Ritwik K Sinha
 *@version	3
 *@since	2/20/2019
 * */


import java.util.*;

public class StudentResponseString extends BaseResponse implements IResponse {

	@SuppressWarnings("unchecked")
	private String content;
	private String listContent;

	public Object getContent()
	{
		return content;
	}
	
	public void setContent(Object obj)
	{
		content = obj.toString();
	}

	public Object getListContent()
	{
		return listContent;
	}
	
	public void setListContent(Object obj)
	{
		listContent = obj.toString();
	}

	public String toString(Student student)
	{
		return student.toString();
	}
	
	public String toString(List<Student>studs)
	{
		String output = "";
		for(int i=0;i<studs.size();i++)
		{
			output += studs.get(i).toString() + "\n";
		}
		return output;
	}
	
}

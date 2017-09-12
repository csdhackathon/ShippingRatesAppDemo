package pb.coe.pbhackathon.model;

/**
 * Created by abhijeetgupta on 11/09/17.
 */

public class InputParameterModel
{
	private String name;
	
	private String value;
	
	public String getName ()
	{
		return name;
	}
	
	public void setName (String name)
	{
		this.name = name;
	}
	
	public String getValue ()
	{
		return value;
	}
	
	public void setValue (String value)
	{
		this.value = value;
	}
	
	@Override
	public String toString()
	{
		return "ClassPojo [name = "+name+", value = "+value+"]";
	}
}

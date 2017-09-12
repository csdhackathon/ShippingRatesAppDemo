package pb.coe.pbhackathon.model;

/**
 * Created by abhijeetgupta on 11/09/17.
 */

public class DimensionModel
{
	private double height;
	
	private String unitOfMeasurement;
	
	private double width;
	
	private double length;
	
	private double irregularParcelGirth;
	
	public double getHeight ()
	{
		return height;
	}
	
	public void setHeight (double height)
	{
		this.height = height;
	}
	
	public String getUnitOfMeasurement ()
	{
		return unitOfMeasurement;
	}
	
	public void setUnitOfMeasurement (String unitOfMeasurement)
	{
		this.unitOfMeasurement = unitOfMeasurement;
	}
	
	public double getWidth ()
	{
		return width;
	}
	
	public void setWidth (double width)
	{
		this.width = width;
	}
	
	public double getLength ()
	{
		return length;
	}
	
	public void setLength (double length)
	{
		this.length = length;
	}
	
	public double getIrregularParcelGirth ()
	{
		return irregularParcelGirth;
	}
	
	public void setIrregularParcelGirth (double irregularParcelGirth)
	{
		this.irregularParcelGirth = irregularParcelGirth;
	}
	
	@Override
	public String toString()
	{
		return "ClassPojo [height = "+height+", unitOfMeasurement = "+unitOfMeasurement+", width = "+width+", length = "+length+", irregularParcelGirth = "+irregularParcelGirth+"]";
	}
}

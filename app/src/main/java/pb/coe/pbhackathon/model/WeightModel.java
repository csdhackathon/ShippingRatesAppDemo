package pb.coe.pbhackathon.model;

/**
 * Created by abhijeetgupta on 11/09/17.
 */

public class WeightModel
{
	private double weight;
	
	private String unitOfMeasurement;
	
	public double getWeight ()
	{
		return weight;
	}
	
	public void setWeight (double weight)
	{
		this.weight = weight;
	}
	
	public String getUnitOfMeasurement ()
	{
		return unitOfMeasurement;
	}
	
	public void setUnitOfMeasurement (String unitOfMeasurement)
	{
		this.unitOfMeasurement = unitOfMeasurement;
	}
	
	@Override
	public String toString()
	{
		return "ClassPojo [weight = "+weight+", unitOfMeasurement = "+unitOfMeasurement+"]";
	}
}

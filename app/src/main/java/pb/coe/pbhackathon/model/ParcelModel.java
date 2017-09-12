package pb.coe.pbhackathon.model;

/**
 * Created by abhijeetgupta on 11/09/17.
 */

public class ParcelModel
{
	private DimensionModel dimension;
	
	private WeightModel weight;
	
	public DimensionModel getDimension()
	{
		return dimension;
	}
	
	public void setDimension(DimensionModel dimension)
	{
		this.dimension = dimension;
	}
	
	public WeightModel getWeight()
	{
		return weight;
	}
	
	public void setWeight(WeightModel weight)
	{
		this.weight = weight;
	}
	
	@Override
	public String toString()
	{
		return "ClassPojo [dimension = "+ dimension +", weight = "+ weight +"]";
	}
}

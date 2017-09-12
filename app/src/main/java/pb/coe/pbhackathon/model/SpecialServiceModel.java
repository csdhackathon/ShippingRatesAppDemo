package pb.coe.pbhackathon.model;

/**
 * Created by abhijeetgupta on 11/09/17.
 */

public class SpecialServiceModel
{
	private InputParameterModel[] inputParameters;
	
	private String specialServiceId;
	
	public InputParameterModel[] getInputParameters ()
	{
		return inputParameters;
	}
	
	public void setInputParameters (InputParameterModel[] inputParameters)
	{
		this.inputParameters = inputParameters;
	}
	
	public String getSpecialServiceId ()
	{
		return specialServiceId;
	}
	
	public void setSpecialServiceId (String specialServiceId)
	{
		this.specialServiceId = specialServiceId;
	}
	
	@Override
	public String toString()
	{
		return "ClassPojo [inputParameters = "+inputParameters+", specialServiceId = "+specialServiceId+"]";
	}
}

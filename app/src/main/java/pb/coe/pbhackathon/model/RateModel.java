package pb.coe.pbhackathon.model;

/**
 * Created by abhijeetgupta on 11/09/17.
 */

public class RateModel
{
	private String parcelType;
	
	private String serviceId;
	
	private String inductionPostalCode;
	
	private SpecialServiceModel[] specialServices;
	
	private String carrier;
	
	public String getParcelType ()
	{
		return parcelType;
	}
	
	public void setParcelType (String parcelType)
	{
		this.parcelType = parcelType;
	}
	
	public String getServiceId ()
	{
		return serviceId;
	}
	
	public void setServiceId (String serviceId)
	{
		this.serviceId = serviceId;
	}
	
	public String getInductionPostalCode ()
	{
		return inductionPostalCode;
	}
	
	public void setInductionPostalCode (String inductionPostalCode)
	{
		this.inductionPostalCode = inductionPostalCode;
	}
	
	public SpecialServiceModel[] getSpecialServices ()
	{
		return specialServices;
	}
	
	public void setSpecialServices (SpecialServiceModel[] specialServices)
	{
		this.specialServices = specialServices;
	}
	
	public String getCarrier ()
	{
		return carrier;
	}
	
	public void setCarrier (String carrier)
	{
		this.carrier = carrier;
	}
	
	@Override
	public String toString()
	{
		return "ClassPojo [parcelType = "+parcelType+", serviceId = "+serviceId+", inductionPostalCode = "+inductionPostalCode+", specialServices = "+specialServices+", carrier = "+carrier+"]";
	}
}

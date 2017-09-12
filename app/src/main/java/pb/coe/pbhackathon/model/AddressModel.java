package pb.coe.pbhackathon.model;

/**
 * Created by abhijeetgupta on 11/09/17.
 */

public class AddressModel
{
	private String phone;
	
	private String postalCode;
	
	private String status;
	
	private String residential;
	
	private String email;
	
	private String name;
	
	private String company;
	
	private String countryCode;
	
	private String[] addressLines;
	
	private String cityTown;

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	private String stateProvince;
	
	public String getPhone ()
	{
		return phone;
	}
	
	public void setPhone (String phone)
	{
		this.phone = phone;
	}
	
	public String getPostalCode ()
	{
		return postalCode;
	}
	
	public void setPostalCode (String postalCode)
	{
		this.postalCode = postalCode;
	}
	
	public String getStatus ()
	{
		return status;
	}
	
	public void setStatus (String status)
	{
		this.status = status;
	}
	
	public String getResidential ()
	{
		return residential;
	}
	
	public void setResidential (String residential)
	{
		this.residential = residential;
	}
	
	public String getEmail ()
	{
		return email;
	}
	
	public void setEmail (String email)
	{
		this.email = email;
	}
	
	public String getName ()
	{
		return name;
	}
	
	public void setName (String name)
	{
		this.name = name;
	}
	
	public String getCompany ()
	{
		return company;
	}
	
	public void setCompany (String company)
	{
		this.company = company;
	}
	
	public String getCountryCode ()
	{
		return countryCode;
	}
	
	public void setCountryCode (String countryCode)
	{
		this.countryCode = countryCode;
	}
	
	public String[] getAddressLines ()
	{
		return addressLines;
	}
	
	public void setAddressLines (String[] addressLines)
	{
		this.addressLines = addressLines;
	}
	
	public String getCityTown ()
	{
		return cityTown;
	}
	
	public void setCityTown (String cityTown)
	{
		this.cityTown = cityTown;
	}
	
	@Override
	public String toString()
	{
		return "ClassPojo [phone = "+phone+", postalCode = "+postalCode+", status = "+status+", residential = "+residential+", email = "+email+", name = "+name+", company = "+company+", countryCode = "+countryCode+", addressLines = "+addressLines+", cityTown = "+cityTown+"]";
	}
}

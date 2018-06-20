public class Location
{
	private final String ID;
	String street;
	String barangay;
	String city;
	String country;
	String code;

	public Location(String i, String s, String b, String ct, String c, String cd) {
		ID = i;
		street = s;
		barangay = b;
		city = cd;
		country = c;
		code = cd;
	}

	public String getId() {
		return(ID);
	}

	public void setStreet(String s) {
		street = s;
	}

	public String getStreet() {
		return(street);
	}

	public void setBarangay(String b) {
		barangay = b;
	}

	public String getBarangay() {
		return(barangay);
	}

	public void setCity(String ct) {
		city = ct;
	}

	public String getCity() {
		return(city);
	}

	public void setCountry(String c) {
		country = c;
	}

	public String getCountry() {
		return(country);
	}

	public void setCode(String cd) {
		code = cd;
	}

	public String getCode() {
		return(code);
	}

	public String getDetails() {
		return(ID + "@" + street + "@" + barangay + "@" + city + "@" + country + "@" + code + "@location");
	}
}

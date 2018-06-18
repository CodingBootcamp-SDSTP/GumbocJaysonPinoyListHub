public class Person
{
	private final String ID;
	String specialty;
	String firstName;
	String lastName;
	String licenseNumber;
	String contactDetails;

	public Person(String i, String s, String fn, String ln, String l, String cd) {
		ID = i;
		specialty = s;
		firstName = fn;
		lastName = ln;
		licenseNumber = l;
		contactDetails = cd;
	}

	public String getId() {
		return(ID);
	}

	public void setSpecialty(String s) {
		specialty = s;
	}

	public String getSpecialty() {
		return(specialty);
	}

	public void setFirstName(String fn) {
		firstName = fn;
	}

	public String getFirstName() {
		return(firstName);
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

	public String getLastName() {
		return(lastName);
	}

	public void setLicenseNumber(String l) {
		licenseNumber = l;
	}

	public String getLicenseNumber() {
		return(licenseNumber);
	}

	public void setContactDetails(String cd) {
		contactDetails = cd;
	}

	public String getContactDetails() {
		return(contactDetails);
	}

	public String getDetails() {
		return("ID" + "@" + specialty + "@" + firstName + "@" + lastName + "@" + licenseNumber + "@" + contactDetails + "@person");
	}
}

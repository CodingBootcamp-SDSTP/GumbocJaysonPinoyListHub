import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.sql.*;

public class ListHubDatabase
{
	private PropertyCollection properties;
	private PersonCollection persons;
	private LocationCollection locations;
	Connection conn;

	public ListHubDatabase() {
		properties = new PropertyCollection();
		persons = new PersonCollection();
		locations = new LocationCollection();
		Connection c = connectdb();
		if(connectdb() == null) {
			System.out.println("Error connecting to your MySQL Database...");
		}
		else {
			System.out.println("Connected.");
			readFromDB(c);
		}
	}

	public PropertyCollection getPropertyCollection() {
		return(properties);
	}

	public PersonCollection getPersonCollection() {
		return(persons);
	}

	public LocationCollection getLocationCollection() {
		return(locations);
	}

	public Connection connectdb() {
		Connection v = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			v = DriverManager.getConnection("jdbc:mysql://localhost/listdb?user=json&" +
			"password=seven&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		}
		catch(Exception e) {
			v = null;
			e.printStackTrace();
		}
		finally {
 			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
 		}
		return(v);
	}

	public void addPerson(Person person) {
		if(insertPersonToDB(person)) {
			persons.addPerson(person);
		}
	}

	boolean insertPersonToDB(Person person) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO tblperson (id, specialty, firstname, lastname, licensenumber, contactdetails) VALUES ( ?, ?, ?, ?, ?, ?);");
			stmt.setString(1, person.getId());
			stmt.setString(2, person.getSpecialty());
			stmt.setString(3, person.getFirstName());
			stmt.setString(4, person.getLastName());
			stmt.setString(5, person.getLicenseNumber());
			stmt.setString(6, person.getContactDetails());
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally{
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public void addProperty(Property property) {
		if(insertPropertyToDB(property)) {
			properties.addProperty(property);
		}
	}

	boolean insertPropertyToDB(Property property) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO tblproperty (price, propertyname, propertytype, floorarea, lotsize, roomnumber, otherdetails) VALUES ( ?, ?, ?, ?, ?, ?, ?);");
			stmt.setInt(1, property.getPrice());
			stmt.setString(2, property.getPropertyName());
			stmt.setString(3, property.getPropertyType());
			stmt.setInt(4, property.getFloorArea());
			stmt.setInt(5, property.getLotSize());
			stmt.setInt(5, property.getRoomNumber());
			stmt.setString(5, property.getOtherDetails());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public void addLocation(Location location) {
		if(insertLocationToDB(location)) {
			locations.addLocation(location);
		}
	}

	boolean insertLocationToDB(Location location) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO tbllocation (id, street, barangay, city, country, code) VALUES ( ?, ?, ?, ?, ?, ? );");
			stmt.setString(1, location.getId());
			stmt.setString(2, location.getStreet());
			stmt.setString(3, location.getBarangay());
			stmt.setString(4, location.getCity());
			stmt.setString(5, location.getCountry());
			stmt.setString(5, location.getCode());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	void readFromDB(Connection conn) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM tblperson;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String[] p = {
					rs.getString("id"), 
					rs.getString("firstname"), 
					rs.getString("specialty"), 
					rs.getString("firstname"), 
					rs.getString("lastname"), 
					rs.getString("licensenumber"), 
					rs.getString("contactdetails"), 
					"person"
				};
				createObject(p);
			}
			stmt = conn.prepareStatement("SELECT * FROM tbllocation;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String[] l = {
					rs.getString("id"), 
					rs.getString("street"), 
					rs.getString("barangay"), 
					rs.getString("city"), 
					rs.getString("country"), 
					rs.getString("code"), 
					"location"};
				createObject(l);
			}
			stmt = conn.prepareStatement("SELECT * FROM tblproperty");
			rs = stmt.executeQuery();
			while(rs.next()) {
				String[] py = {
					Integer.toString(rs.getInt("id")), 
					Integer.toString(rs.getInt("price")), 
					rs.getString("propertyname"), 
					rs.getString("propertytype"), 
					rs.getString("locationid"),
					Integer.toString(rs.getInt("floorarea")), 
					Integer.toString(rs.getInt("lotsize")), 
					Integer.toString(rs.getInt("roomnumber")), 
					rs.getString("otherdetails"), 
					rs.getString("salesrep")
				};
				createObject(py);
			}
		}
		catch(Exception e) {
			System.out.println("Error retrieving data..." + e);
		}
		finally {
 			try { if (rs != null) rs.close(); } catch (Exception e) {};
 			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
 		}
	}

	public void createObject(String... details) {
		int len = details.length-1;
		String d = details[len];
		if("person".equals(d)) {
			Person p = new Person(details[0], details[1], details[2], details[3], details[4], details[5]);
			persons.addPerson(p);
		}
		else if("location".equals(d)) {
			Location l = new Location(details[0], details[1], details[2], details[3], details[4], details[5]);
			locations.addLocation(l);
		}
		else if("property".equals(d)) {
			Property p = new Property(details[0], Integer.parseInt(details[1]), details[2], details[3], Integer.parseInt(details[4]), Integer.parseInt(details[5]),
				Integer.parseInt(details[6]), details[7]);
			properties.addProperty(p);
		}
	}
	
	public String getCollectionContent() {
		ArrayList<Person> p = persons.getAllPersons();
		ArrayList<Location> l = locations.getAllLocations();
		ArrayList<Property> ps = properties.getAllProperties();
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<p.size(); i++) {
			Person person = p.get(i);
			sb.append(person.getDetails() + "\n");
		}
		for(int i=0; i<l.size(); i++) {
			Location location = l.get(i);
			sb.append(location.getDetails() + "\n");
		}
		for(int i=0; i<ps.size(); i++) {
			Property property = ps.get(i);
			sb.append(property.getDetails());
			if(i < ps.size()-1) {
				sb.append("\n");
			}
		}
		return(sb.toString());
	}
}

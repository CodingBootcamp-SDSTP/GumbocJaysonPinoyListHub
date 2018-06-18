import java.util.ArrayList;

public class PropertyCollection
{
	private ArrayList<Property> properties;

	public PropertyCollection() {
		properties = new ArrayList<Property>();
	}

	public void addProperty(Property property) {
		properties.add(property);
	}

	public void removeProperty(Property property) {
		properties.remove(property);
	}

	public ArrayList<Property> getAllProperties() {
		return(properties);
	}

	public Property getPropertyByIndex(int n) {
		return(properties.get(n));
	}

	public int getPropertyCount() {
		return(properties.size());
	}

	public Property getPropertyById(String id) {
		Property property = null;
		for (int i=0; i<getPropertyCount(); i++) {
			if (getPropertyByIndex(i).getId().equalsIgnoreCase(id)) {
				property = getPropertyByIndex(i);
			}
		}
		return(property);
	}
}


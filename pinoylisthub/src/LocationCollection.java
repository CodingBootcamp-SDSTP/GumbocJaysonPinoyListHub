import java.util.ArrayList;

public class LocationCollection
{
	ArrayList<Location> locations;

	public LocationCollection() {
		locations = new ArrayList<Location>();
	}

	public void addLocation(Location location) {
		locations.add(location);
	}

	public void removeLocation(Location location) {
		locations.remove(location);
	}

	public ArrayList<Location> getAllLocations() {
		return(locations);
	}

	public Location getLocationByIndex(int n) {
		return(locations.get(n));
	}

	public int getLocationCount() {
		return(locations.size());
	}

	public Location getLocationById(String id) {
		Location location = null;
		for (int i=0; i<getLocationCount(); i++) {
			if (getLocationByIndex(i).getId().equalsIgnoreCase(id)) {
				location= getLocationByIndex(i);
			}
		}
		return(location);
	}
}

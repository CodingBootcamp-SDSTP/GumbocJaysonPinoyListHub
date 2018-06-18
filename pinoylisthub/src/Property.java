public class Property
{
	private final String ID;
	int price;
	String propertyName;
	String propertyType;
	int floorArea;
	int lotSize;
	int roomNumber;
	String otherDetails;

	public Property(String i, int p, String pn, String pt, int f, int l, int r, String od) {
		ID = i;
		price = p;
		propertyName = pn;
		propertyType = pt;
		floorArea = f;
		lotSize = l;
		roomNumber = r;
		otherDetails = od;
	}

	public String getId() {
		return(ID);
	}

	public void setPrice(int p) {
		price = p;
	}

	public int getPrice() {
		return(price);
	}

	public void setPropertyName(String pn) {
		propertyName = pn;
	}

	public String getPropertyName() {
		return(propertyName);
	}

	public void setPropertyType(String pt) {
		propertyType = pt;
	}

	public String getPropertyType() {
		return(propertyType);
	}

	public void setFloorArea(int f) {
		floorArea = f;
	}

	public int getFloorArea() {
		return(floorArea);
	}

	public void setLotSize(int l) {
		lotSize = l;
	}

	public int getLotSize() {
		return(lotSize);
	}

	public void setRoomNumber(int r) {
		roomNumber = r;
	}

	public int getRoomNumber() {
		return(roomNumber);
	}

	public void setOtherDetails(String od) {
		otherDetails = od;
	}

	public String getOtherDetails() {
		return(otherDetails);
	}

	public String getDetails() {
		return("ID" + "@" + price + "@" + propertyName + "@" + propertyType + "@" + floorArea + "@" + lotSize + "@" + roomNumber+ "@" + otherDetails   + "@property");
	}
}

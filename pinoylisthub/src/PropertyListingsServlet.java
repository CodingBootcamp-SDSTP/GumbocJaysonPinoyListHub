import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.PrintWriter;

public class PropertyListingsServlet extends HttpServlet
{
	PropertyCollection properties;
	ListHubDatabase lhd;

	public void init() throws ServletException {
		lhd = new ListHubDatabase();
		properties = lhd.getPropertyCollection();

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		StringBuilder sb = new StringBuilder("<properties>");
		for(int i=0; i<properties.getPropertyCount(); i++) {
			Property ps = properties.getPropertyByIndex(i);
			sb.append("<property><id>");
			sb.append(ps.getId());
			sb.append("</id><price>");
			sb.append(Integer.toString(ps.getPrice()));
			sb.append("</price><propertyname>");
			sb.append(ps.getPropertyName());
			sb.append("</propertyname><propertytype>");
			sb.append(ps.getPropertyType());
			sb.append("</propertytype><floorarea>");
			sb.append(ps.getFloorArea());
			sb.append("</floorarea><lotsize>");
			sb.append(ps.getLotSize());
			sb.append("</lotsize><roomnumber>");
			sb.append(ps.getRoomNumber());
			sb.append("</roomnumber><otherdetails>");
			sb.append(ps.getOtherDetails());
			sb.append("</otherdetails></property>");
			}
		sb.append("</properties>");
		out.println(sb.toString());
		out.close();
	}

	public void destroy() {
		properties = null;
		lhd = null;
	}
}

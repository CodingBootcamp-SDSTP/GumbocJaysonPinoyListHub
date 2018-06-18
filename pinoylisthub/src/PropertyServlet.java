import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.PrintWriter;

public class PropertyServlet extends HttpServlet
{
	PropertyCollection properties;

	public void init() throws ServletException {
		ListHubDatabase lhd = new ListHubDatabase();
		properties = lhd.getPropertyCollection();

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		PrintWriter out = res.getWriter();
		out.println("<properties>");
		for(int i=0; i<properties.getPropertyCount(); i++) {
			Property ps = properties.getPropertyByIndex(i);
			out.println("<property");
				out.println("<id>" + ps.getId() + "</id>");
				out.println("<price>" + Integer.toString(ps.getPrice()) + "</price>");
				out.println("<propertyname>" + ps.getPropertyName() + "</propertyname>");
				out.println("<propertytype>" + ps.getPropertyType() + "</propertytype>");
				out.println("<floorarea>" + ps.getFloorArea() + "</floorarea>");
				out.println("<lotsize>" + ps.getLotSize() + "</lotsize>");
				out.println("<roomnumber>" + ps.getRoomNumber() + "</roomnumber>");
				out.println("<otherdetails>" + ps.getOtherDetails() + "</otherdetails>");
			out.println("</property>");
			}
		out.println("</properties>");
	}
		
	public void destroy() {
		properties = null;
	}
}

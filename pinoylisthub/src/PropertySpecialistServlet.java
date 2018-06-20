import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.PrintWriter;

public class PropertySpecialistServlet extends HttpServlet
{
	PersonCollection persons;
	ListHubDatabase lhd;

	public void init() throws ServletException {
		lhd = new ListHubDatabase();
		persons = lhd.getPersonCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		StringBuilder sb = new StringBuilder("<persons>");
		for(int i=0; i<persons.getPersonCount(); i++) {
			Person p = persons.getPersonByIndex(i);
			sb.append("<person><id>");
			sb.append(p.getId());
			sb.append("</id><specialty>");
			sb.append(p.getSpecialty());
			sb.append("</specialty><firstname>");
			sb.append(p.getFirstName());
			sb.append("</firstname><lastname>");
			sb.append(p.getLastName());
			sb.append("</lastname><licensenumber>");
			sb.append(p.getLicenseNumber());
			sb.append("</licensenumber><contactdetails>");
			sb.append(p.getContactDetails());
			sb.append("</contactdetails></person>");
			}
		sb.append("</persons>");
		out.println(sb.toString());
		out.close();
	}

	public void destroy() {
		persons = null;
		lhd = null;
	}
}

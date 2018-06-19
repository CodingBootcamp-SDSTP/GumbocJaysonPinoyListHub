import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.PrintWriter;

public class PropertySpecialistServlet extends HttpServlet
{

	public void init() throws ServletException {

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/plain");
		out.println();
		out.close();
	}
		
	public void destroy() {
		
	}
}

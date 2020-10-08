package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.deploy.MultipartDef;

import com.oreilly.servlet.MultipartRequest;



/**
 * Servlet implementation class UploaderServlet
 */
@WebServlet("/UploaderServlet")
public class UploaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		MultipartRequest ref=new MultipartRequest(request, "f:\\abc");
		//String name=request.getParameter("t1");
		//System.out.println("name="+name);
		out.print("<b><i>Successfully Uploaded<b><i>");
	}

}

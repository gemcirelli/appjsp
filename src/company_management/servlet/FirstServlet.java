package company_management.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("GET");
		String idemployee= request.getParameter("idemployee");
		System.out.println("idemployee GET:" + idemployee);
		
		////////////PARA IMPRIMER EN EL EXPLORADOR///////////////
		PrintWriter out=response.getWriter();
		java.util.Date today= new java.util.Date();
		out.println("<html><body>" + today+ "GET parameter"+ idemployee+ "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("SONO IN POST");
		String name= request.getParameter("name");
		System.out.println("name(POST" + name);
		
		
		PrintWriter out= response.getWriter();
		java.util.Date today= new java.util.Date();
		out.println("<html><body>"+ today+ "POST PARAMETER: "+ name +"</body></html>");
		
	}

}

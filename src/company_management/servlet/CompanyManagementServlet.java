package company_management.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import company_management.bean.CompanyBean;

import company_management.bean.EmployeeBean;

/**
 * Servlet implementation class CompanyManagementServlet
 */
@WebServlet("/CompanyManagementServlet")
public class CompanyManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String  whatsend = request.getParameter("whatsend");
		System.out.println("whatsend: " +whatsend);
		
		if (whatsend.equals("employeeInsert")) {
				ServletContext sc= request.getSession().getServletContext();
				RequestDispatcher rd= sc.getRequestDispatcher("/formEmployee.jsp");
				rd.forward(request, response);
		}
		else if(whatsend.equals("homepage")){
			  
			  request.getSession().removeAttribute("COMPANY");
			  request.getSession().removeAttribute("EMPLOYEE");	
			response.sendRedirect("/company_management/formCompany.jsp");
			
			
		}
		else if (whatsend.equals("employee")){
			request.getSession().removeAttribute("EMPLOYEE");
			ServletContext sc= request.getSession().getServletContext();
			RequestDispatcher rd= sc.getRequestDispatcher("/formEmployee.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String whatsend= request.getParameter("whatsend");
		 
		if (whatsend.equals("company")) {
			// TODO Auto-generated method stub
			String idcompany=request.getParameter("idcompany");
			System.out.println("idcompany del post:"+ idcompany);
			String company_name = request.getParameter("company_name");
			System.out.println("company_name del post:"+ company_name);
			String phone = request.getParameter("phone");
			System.out.println("phone del post:"+ phone);
			String email = request.getParameter("company_name");
			System.out.println("email del post:"+ email);
			
			ArrayList<EmployeeBean> companyEmployees= new ArrayList<EmployeeBean>();
			
			CompanyBean company= new CompanyBean();
			company.setIdcompany(idcompany);
			company.setCompany_name(company_name);
			company.setPhone(phone);
			company.setEmail(email);
			company.setCompanyEmployees(companyEmployees);
			System.out.println("COMPANY EMPLOYESS:"+ companyEmployees);
			
			
			
			ServletContext sc= request.getSession().getServletContext();
			
			request.getSession().removeAttribute("COMPANY");
			
			request.getSession().setAttribute("COMPANY",company);
			
			RequestDispatcher rd= sc.getRequestDispatcher("/formCompany.jsp");
			rd.forward(request,response);
		}
		
		if (whatsend.equals("employee")) {
			// TODO Auto-generated method stub
			CompanyBean company;
			  String idemployee= request.getParameter("idemployee");
			  System.out.println("idemployee:  "+ idemployee);
			  String name = request.getParameter("name");
			  System.out.println("name:  "+ name);
			  String surname = request.getParameter("surname");
			  System.out.println("surname :  "+ surname);
			  String badge= request.getParameter("badge");
			  
			  String fk_company= request.getParameter("FK_company");
			  System.out.println("fk company: "+ fk_company);
			  
			  
			  EmployeeBean employee= new EmployeeBean();
			  employee.setIdemployee(idemployee);
			  employee.setName(name);
			  employee.setSurname(surname);
			  employee.setBadge(badge);
			  employee.setFk_company(fk_company);
			  
			  ServletContext sc = request.getSession().getServletContext();
			  
			  request.getSession().removeAttribute("EMPLOYEE");
			  request.getSession().setAttribute("EMPLOYEE", employee);
			  RequestDispatcher rd= sc.getRequestDispatcher("/formEmployee.jsp");
			  rd.forward(request, response);
			  
			  //ADD EMPLOYEE TO COMPANY
			  if (request.getSession()!=null && request.getSession().getAttribute("COMPANY")!=null) {
				 
				  company= (CompanyBean) request.getSession().getAttribute("COMPANY");
				  ArrayList<EmployeeBean> companyEmployees = company.getCompanyEmployees();
				  
				  companyEmployees.add(employee);
				  company.setCompanyEmployees(companyEmployees);
				  request.getSession().removeAttribute("COMPANY");
				  request.getSession().setAttribute("COMPANY", company);
				  
				
			}
		
			  company= (CompanyBean) request.getSession().getAttribute("COMPANY");
			  ArrayList<EmployeeBean> companyEmployeesList = company.getCompanyEmployees();
			  
			  for(EmployeeBean cl: companyEmployeesList){
				  System.out.println("Employee"+ cl.getSurname());
			  }
		}
		
	}

}

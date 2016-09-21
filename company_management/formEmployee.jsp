<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="company_management.bean.EmployeeBean" %>
        <%@page import="company_management.bean.CompanyBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
String idemployee="";
String name="";
String surname="";
String badge="";
String fk_company="";


EmployeeBean employee = new EmployeeBean();
boolean employeeFilled=false;

if(request.getSession()!=null && request.getSession().getAttribute("EMPLOYEE")!=null){
	employee = (EmployeeBean) request.getSession().getAttribute("EMPLOYEE");
	idemployee = employee.getIdemployee()+"";
	name=employee.getName()+"";
	surname= employee.getSurname()+"";
	badge=employee.getBadge()+"";
	fk_company=employee.getFk_company()+"";
	
	
	employeeFilled=true;

	
}

CompanyBean company = new CompanyBean();

if(request.getSession()!=null && request.getSession().getAttribute("COMPANY")!=null){
	
	company = (CompanyBean) request.getSession().getAttribute("COMPANY");
	fk_company= company.getIdcompany()+"";
}

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table>
	
	<tr>
	<td>
		<a href="/company_management/CompanyManagementServlet?whatsend=homepage" target="_top"> Home Page</a>
			&nbsp;
			<a href="/company_management/CompanyManagementServlet?whatsend=company" target="_top"> Company</a>
			&nbsp;
			
		<% if(employeeFilled){ %>
			  <a href="/company_management/CompanyManagementServlet?whatsend=employee" target="_top"> Insert another Employee</a>  
		<% } %>
		

	
	</td>
  </tr>
	

	
	<tr>
		<td>		
				<form name="employeeForm" action="/company_management/CompanyManagementServlet" method="post">
					<table>
						<tr>
							<td> Employee ID (*):</td>
							<td>
								<% if(employeeFilled){ %>
								<%=idemployee %>
								<%}else{ %>
								<input name="idemployee" value="<%=idemployee %>" type="text" maxlength="16">
								<%} %>
							</td>
						</tr>

						<tr>
							<td> Name (*):</td>
							<td>
								<input name="name" value="<%=name %>" type="text" maxlength="45">
							</td>
						</tr>
						<tr>
							<td> Surname (*):</td>
							<td>
								<input name="surname" value="<%=surname %>" type="text" maxlength="45">
							</td>
						</tr>
						<tr>
							<td> Company Badge(*):</td>
							<td>
								<input name="badge" value="<%=badge %>" type="text" maxlength="45">
							</td>
						</tr>
						<tr>
							<td colspan="2">(*) Mandatory field</td>
						</tr>


					</table>
					<input name="FK_company" value="<%=fk_company %>" >
					<input name="whatsend" value="employee" type="hidden">
					<input value="Insert Employee" type="submit">
					
				</form>
		</td>		
	</tr>


</table>
</body>
</html>
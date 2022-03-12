package Q1.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Q1.DBManager.DBManager;
import Q1.UserPojo.UserPojo;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBManager manager = new DBManager(); //Create the object of the Database Manager
		String firstName = request.getParameter("firstName"); //get the firstName from the JSP
		String lastName = request.getParameter("lastName"); //get the lastName from the JSP
		int age = Integer.parseInt(request.getParameter("age")); //get the age from the JSP
		if(age<=18) { //check of age is less than or equal to 18 if yes then this condition becomes true
			UserPojo user = new UserPojo(firstName, lastName, age); //add the user information into the UserPojo via parametrized Constructor
			if(manager.addChild(user)) { //add the child user
				ServletContext context = super.getServletContext();
				String message = "Error Occured While Storing the Child data";
				request.setAttribute("message", message);
				RequestDispatcher dispatcher = context.getRequestDispatcher("/AddChildData.jsp"); //redirect the user on successfully adding the Child data into the table;
				dispatcher.forward(request, response); 
			} //end of if
			else {
				ServletContext context = super.getServletContext();
				RequestDispatcher dispatcher = context.getRequestDispatcher("/Error");
				dispatcher.forward(request, response);
			} //end of if
		}
		else { //this else part will add the User if age is greater than 18 years;
			UserPojo user = new UserPojo(firstName, lastName, age); //create the UserPojo and object and pass the user information into thr parameterized Constructor
			if(manager.addAdult(user)) {
			ServletContext context = super.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/AddAdultData.jsp");
			dispatcher.forward(request, response);
		} //end of if
		else {
			ServletContext context = super.getServletContext();
			String message = "Error Occured While Storing the Adult data";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = context.getRequestDispatcher("/Error");
			dispatcher.forward(request, response);
		} //end of if
		}
	} //end of doPost method
} //end of AddUserServlet Class

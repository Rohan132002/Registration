package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;

//@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/register")
public class ResgistrationServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		
		String fst_name = req.getParameter("fst_name"); 
		String lst_name = req.getParameter("lst_name");
		String email = req.getParameter("email");
		String address = req.getParameter("address"); 
		String contact = req.getParameter("contact"); 
		String stream = req.getParameter("stream");
		String clubs = req.getParameter("clubs");
		
		PrintWriter out = resp.getWriter();
		
		Student ob = new Student();
		
		ob.setFst_name(fst_name);
		ob.setLst_name(lst_name);
		ob.setEmail(email);
		ob.setAddress(address);
		ob.setContact(contact);
		ob.setStream(stream);
		ob.setClubs(clubs);
		
		try {
			int response = ob.addstudent();
			if(response == 1)
			{
				out.println("Registration Successfull");
			}
			else
			{
				out.println("Registration Failed");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

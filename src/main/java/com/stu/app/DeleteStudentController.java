package com.stu.app;

import java.io.IOException;
import java.io.PrintWriter;

import com.stu.app.dto.Student;
import com.stu.dao.StudentDAO;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DeleteStudentController extends GenericServlet 
{
	private StudentDAO dao=new StudentDAO();
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		int sid=Integer.parseInt(req.getParameter("sid"));
		PrintWriter pw=resp.getWriter();
		String msg="";
		if(dao.deleteStudent(sid))
		{
			msg="<h1>Student Deleted Successfully</h1>...<a href='index.html'>Home</a>";
		}
		else
		{
			msg="<h1>OOPS Something Went Wrong</h1>...<a href='index.html'>Home</a>";
		}
		pw.println(msg);
	}

}

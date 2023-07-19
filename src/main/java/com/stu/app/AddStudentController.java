package com.stu.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import com.stu.app.dto.Student;
import com.stu.dao.StudentDAO;

public class AddStudentController extends GenericServlet
{
	private StudentDAO dao=new StudentDAO();
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		int sid=Integer.parseInt(req.getParameter("sid"));
		String sname=req.getParameter("sname");
		double sperc=Double.parseDouble(req.getParameter("sperc"));
		PrintWriter pw=resp.getWriter();
		String msg="";
		Student dto=new Student(sid,sname,sperc);
		if(dao.addStudent(dto))
		{
			msg="<h1>Student Added Successfully</h1>...<a href='index.html'>Home</a>";
		}
		else
		{
			msg="<h1>OOPS Something Went Wrong</h1>...<a href='index.html'>Home</a>";
		}
		pw.println(msg);
	}

}

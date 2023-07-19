package com.stu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stu.app.dto.Student;

public class StudentDAO 
{
	public boolean addStudent(Student dto)
	{
		boolean res=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Gokul2001@");
			pstmt=con.prepareStatement("insert into student values(?,?,?)");
			pstmt.setInt(1, dto.getSid());
			pstmt.setString(2, dto.getSname());
			pstmt.setDouble(3, dto.getSperc());
			int nori=pstmt.executeUpdate();
			if(nori==1)
			{
				res=true;
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return res;
	}
	public boolean deleteStudent(int sid)
	{
		boolean res=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Gokul2001@");
			pstmt=con.prepareStatement("delete from student where sid=?");
			pstmt.setInt(1, sid);
			int nord=pstmt.executeUpdate();
			if(nord==1)
			{
				res=true;
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return res;
	}
}

package com.masai.user;

import java.sql.PreparedStatement;
import com.masai.bean.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.View;

import com.masai.Execeptions.AdminException;
import com.masai.Execeptions.AuthenticationFailException;
import com.masai.Execeptions.CreateDetailsException;
import com.masai.Execeptions.UpdateDetailsException;
import com.masai.Execeptions.ViewDetailsException;
import com.masai.admin.AdminWorks;
import com.masai.methods.GetDataFromSql;

public class Administrator implements AdminWorks {
	
	private String username;
	private String password;
	
	
	public Administrator(String username,String password) throws AuthenticationFailException {
		
		PreparedStatement pres = GetDataFromSql.GetData("select * from admin where username = ? AND password = ?");
		
		try {
			pres.setString(1, username);
			
			pres.setString(2, password);
			
			ResultSet rset = pres.executeQuery();
			
			if(rset.next()) {
				System.out.println("You are the admin now");
			}
			else {
				throw new AuthenticationFailException("wrong username or password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Administrator [username=" + username + ", password=" + password + "]";
	}




	@Override
	public void createCourse(Course course) throws CreateDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("insert into course(coursename,fee,courseDescription) values(?,?,?)");
		
		try {
			pres.setString(1, course.getCourseName());
			pres.setInt(2, course.getFee());
			pres.setString(3, course.getCourseDescription());
			
			int x = pres.executeUpdate();
			
			if(x > 0) {
				System.out.println("Course added successfully");
			}
			else {
				throw new CreateDetailsException("Please enter valid course details");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
	}




	@Override
	public void updateCourse(Course course) throws UpdateDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("update course set coursename = ?, fee = ?, courseDescription = ? where courseid = "+course.getCourseId()+";");
		
		
		try {
			pres.setString(1, course.getCourseName());
			pres.setInt(2, course.getFee());
			pres.setString(3, course.getCourseDescription());
			
			
			int x = pres.executeUpdate();
			
			if(x > 0) {
				System.out.println("Course update succssesfully");
			}
			else {
				throw new UpdateDetailsException("Please enter valid CourseId");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void viewCourse(String courseName) throws ViewDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("select * from course where coursename = ?");
		
		try {
			pres.setString(1, courseName);
			
			ResultSet rset = pres.executeQuery();
			boolean flag = true;
			
			while(rset.next()) {
				flag = false;
				System.out.println("Course ID : " + rset.getInt(1));
				System.out.println("Course Name : " + rset.getString(2));
				System.out.println("Course fee : " + rset.getInt(3));
				System.out.println("Course Description : " + rset.getString(4));
				
				System.out.println("=============================================");
			}
			
			
			if(flag) {
				throw new ViewDetailsException("Please enter valid course name");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	@Override
	public void createBatch(Batch batch) throws CreateDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("insert into batch(courseid,facultyid,numberofstudent,batchstartdate,duration) values(?,?,?,?,?)");
		
		try {
			pres.setInt(1, batch.getCourseId());
			
			pres.setInt(2, batch.getFacultyId());
			pres.setInt(3, batch.getNumberOfStudent());
			pres.setString(4, batch.getBatchStartDate());
			pres.setString(5, batch.getDuration());

			
			int x =pres.executeUpdate();
			
			if(x > 0) {
				System.out.println("Batch added successfully");
			}
			else {
				throw new CreateDetailsException("Batch is not added");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		
	}




	@Override
	public void viewBatch(int batchid) throws ViewDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("select * from batch where batchid= ?");
		
		try {
			pres.setInt(1, batchid);
			
			ResultSet rset = pres.executeQuery();
			
			if(rset.next()) {
				System.out.println("Batch ID "+rset.getInt(1));
				System.out.println("Course ID "+rset.getInt(2));
				System.out.println("Faculty ID "+rset.getInt(3));
				System.out.println("Number OF Student "+rset.getInt(4));
				System.out.println("Date of start "+rset.getString(5));
				System.out.println("Course Duration "+rset.getString(6));
			}
			else {
				throw new ViewDetailsException("Please enter valid Batch ID");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	@Override
	public void updateBatch(Batch batch) throws UpdateDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("update batch set courseid = ?, facultyid = ?, numberofstudent = ?, batchstartdate = ?, duration = ? where batchid = "+batch.getBatchId()+";");

		
		try {
			pres.setInt(1, batch.getCourseId());
			
			pres.setInt(2, batch.getFacultyId());
			pres.setInt(3, batch.getNumberOfStudent());
			pres.setString(4, batch.getBatchStartDate());
			pres.setString(5, batch.getDuration());

			
			int x =pres.executeUpdate();
			
			if(x > 0) {
				System.out.println("Batch update successfully");
			}
			else {
				throw new UpdateDetailsException("Please enter valid batch ID for updation");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}




	@Override
	public void createFaculty(Faculty faculty) throws CreateDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("insert into faculty(facultyname,facultyaddress,facultymobile,email,username,password) values(?,?,?,?,?,?)");
		
		try {
			
			pres.setString(1, faculty.getFacultyName());
			pres.setString(2, faculty.getFacultyAddress());
			pres.setString(3, faculty.getMobile());
			pres.setString(4, faculty.getEmail());
			pres.setString(5, faculty.getUsername());
			pres.setString(6, faculty.getPassword());
			
			
			int x = pres.executeUpdate();
			
			if(x > 0) {
				System.out.println("Faculty added successfully");
			}
			else {
				throw new CreateDetailsException("Faculty not added");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void updateFaculty(Faculty faculty) throws UpdateDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("update faculty set facultyname = ?, facultyaddress = ?, facultymobile = ?, email = ?, username = ?, password = ? where facultyid = "+faculty.getFacultyId()+";");
		
		try {
			
			pres.setString(1, faculty.getFacultyName());
			pres.setString(2, faculty.getFacultyAddress());
			pres.setString(3, faculty.getMobile());
			pres.setString(4, faculty.getEmail());
			pres.setString(5, faculty.getUsername());
			pres.setString(6, faculty.getPassword());
			
			
			int x = pres.executeUpdate();
			
			if(x > 0) {
				System.out.println("Faculty update successfully");
			}
			else {
				throw new UpdateDetailsException("Faculty not update");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void viewFaculty(int facultyid) throws ViewDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("select * from faculty where facultyid = ?");
		
		try {
			pres.setInt(1, facultyid);
			
			ResultSet rset = pres.executeQuery();
			
			boolean flag = true;
			
			while(rset.next()) {
				flag = false;
				System.out.println("Faculty id : " + rset.getInt(1));
				System.out.println("Faculty name : " + rset.getString(2));
				System.out.println("Faculty address : " + rset.getString(3));
				System.out.println("Faculty mobile number : " + rset.getString(4));
				System.out.println("Faculty email address : " + rset.getString(5));
				System.out.println("Faculty username : " + rset.getString(6));
				System.out.println("Faculty password : " + rset.getString(7));
				
				System.out.println("==============================================");
			}
			
			
			if(flag) {
				throw new ViewDetailsException("faculty not found");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	@Override
	public void createCoursePlan(CoursePlan coursePlan) throws CreateDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("insert into courseplan(batchid,daynumber,topic,status) values(?,?,?,?)");
		
		try {
			pres.setInt(1, coursePlan.getBatchId());
			pres.setInt(2, coursePlan.getDayNumber());
			pres.setString(3, coursePlan.getTopic());
			pres.setString(4, coursePlan.getStatus());
			
			int x = pres.executeUpdate();
			
			if(x > 0) {
				System.out.println("Course plan is added");
			}
			else {
				throw new CreateDetailsException("Course plan is not added");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	@Override
	public void updateCoursePlan(CoursePlan coursePlan) throws UpdateDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("update courseplan set batchid = ?, daynumber = ?, status = ?,topic = ? where planid = "+coursePlan.getPlanId()+";");
		
		try {
			pres.setInt(1, coursePlan.getBatchId());
			pres.setInt(2, coursePlan.getDayNumber());
			pres.setString(3, coursePlan.getStatus());
			pres.setString(4, coursePlan.getTopic());
			
			int x = pres.executeUpdate();
			
			if(x > 0) {
				System.out.println("Course plan updated");
			}
			else {
				throw new UpdateDetailsException("Course plan not updated");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	@Override
	public void viewCoursePlan(int coursePlanID) throws ViewDetailsException {
		// TODO Auto-generated method stub
		
		
		try {
			
			PreparedStatement pres = GetDataFromSql.GetData("select * from courseplan where planid = "+coursePlanID+";");
			
			ResultSet rset = pres.executeQuery();
			
			if(rset.next()) {
				
				System.out.println("Course plan id : " + rset.getInt(1));
				System.out.println("Course plan batch : " + rset.getInt(2));
				System.out.println("Course Day : " + rset.getInt(3));
				System.out.println("Course Topic : " + rset.getString(4));
				System.out.println("Course status : " + rset.getString(5));
			}
			else {
				throw new ViewDetailsException("Course plan not found");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public void dayWiseUpdata(int day) throws AdminException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("select * from courseplan where daynumber = ?");
		
		try {
			pres.setInt(1, day);
			
			ResultSet rset = pres.executeQuery();
			
			boolean flag = true;
			
			while(rset.next()) {
				flag = false;
				System.out.println("Planid : " + rset.getInt(1));
				System.out.println("batchid : " + rset.getInt(2));
				System.out.println("Topic : " + rset.getString(4));
				System.out.println("Status : " + rset.getString(5));
				
				System.out.println("=============================================");
			}
			
			if(flag) {
				throw new AdminException("No data found");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	@Override
	public void generateReport(int batchid) throws AdminException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData(" select b.batchid,c.courseid,c.coursename,f.facultyname,f.facultymobile,f.email,b.numberofstudent,b.batchstartdate,b.duration,c.fee from course c, faculty f, batch b where b.facultyid = f.facultyid AND c.courseid = b.courseid AND b.batchid = ?;");
		
		try {
			pres.setInt(1, batchid);
			
			ResultSet rset = pres.executeQuery();
			
			if(rset.next()) {
				System.out.println("Batch id : " + rset.getInt(1));
				System.out.println("Course id : " + rset.getInt(2));
				System.out.println("Course Name : " + rset.getString(3));
				System.out.println("Facutly Name : " + rset.getString(4));
				System.out.println("Faculty Mobile : " + rset.getString(5));
				System.out.println("Faculty Email : " + rset.getString(6));
				System.out.println("Number Of Student : " + rset.getString(7));
				System.out.println("Batch Start Date : " + rset.getString(8));
				System.out.println("Batch Duration : " + rset.getString(9));
				System.out.println("Course Fee : " + rset.getString(10));
			}
			else {
				throw new AdminException("Please Enter valid Batch ID");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	
	
}

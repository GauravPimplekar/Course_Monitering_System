package com.masai.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Execeptions.AdminException;
import com.masai.Execeptions.AuthenticationFailException;
import com.masai.Execeptions.UpdateDetailsException;
import com.masai.Execeptions.ViewDetailsException;
import com.masai.admin.FacultyWorks;
import com.masai.bean.CoursePlan;
import com.masai.methods.GetDataFromSql;

public class FacultyLogin implements FacultyWorks {
	
	String username;
	
	public FacultyLogin(String username, String password) throws AuthenticationFailException {
		// TODO Auto-generated constructor stub
		
		PreparedStatement pres = GetDataFromSql.GetData("select * from faculty where username = ? AND password = ?");
		
		try {
			this.username = username;
			pres.setString(1, username);
			pres.setString(2, password);
			
			
			ResultSet rset = pres.executeQuery();
			
			if(rset.next()) {
				
			}
			else {
				throw new AuthenticationFailException("Wrong username or password");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void viewCoursePlan(String facultyName) throws ViewDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData(" select * from courseplan where batchid = (select batchid from batch where facultyid = (select facultyid from faculty where facultyname = ?))");
		
		try {
			
			pres.setString(1, facultyName);
			
			ResultSet rset = pres.executeQuery();
			boolean flag = true;
			
			while(rset.next()) {
				flag = false;
				
				System.out.println("plan id : " + rset.getInt(1));
				System.out.println("batch id : " + rset.getInt(2));
				System.out.println("Day Number : " + rset.getInt(3));
				System.out.println("Topic : " + rset.getString(4));
				System.out.println("Status : " + rset.getString(5));
				
				System.out.println("===============================================");
			}
			
			if(flag) {
				throw new ViewDetailsException("Course plan not found");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void fillCoursePlan(CoursePlan coursePlan) throws UpdateDetailsException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("select batchid from batch where facultyid = (select facultyid from faculty where username = ?);");
		
		try {
			pres.setString(1, username);
			
			ResultSet rset = pres.executeQuery();
			int x = 0;
			if(rset.next()) {
				x = rset.getInt(1);
				
				pres = GetDataFromSql.GetData("insert into courseplan(batchid,daynumber,topic,status) values(?,?,?,?)");
				
				pres.setInt(1, x);
				pres.setInt(2, coursePlan.getDayNumber());
				pres.setString(3, coursePlan.getTopic());
				pres.setString(4, coursePlan.getStatus());
				
				int y = pres.executeUpdate();
				
				if(y > 0) {
					System.out.println("CoursePlan update successfully");
				}
				else {
					throw new UpdateDetailsException();
				}
				
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePassword(String username, String password, String new_password) throws AuthenticationFailException {
		// TODO Auto-generated method stub
		
		PreparedStatement pres = GetDataFromSql.GetData("update faculty set password = ? where username = ? And password = ?;");
		
		try {
			
			pres.setString(1, new_password);
			pres.setString(2, username);
			pres.setString(3, username);
			
			int x =  pres.executeUpdate();
			
			if(x > 0) {
				System.out.println("Password updated successfully");
			}
			else {
				throw new AuthenticationFailException("Wrong username or password");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateStatus(int day) throws UpdateDetailsException {
		
		PreparedStatement pres = GetDataFromSql.GetData(" update courseplan set status = 'complete' where daynumber = ? AND batchid = (select batchid from batch where facultyid = (select facultyid from faculty where username = ?));");
	
		try {
			pres.setInt(1, day);
			pres.setString(2, username);
			
			int x = pres.executeUpdate();
			
			if(x > 0) {
				System.out.println("Day "+day+" task complete");
			}
			else {
				throw new UpdateDetailsException("Please enter valid day number");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}

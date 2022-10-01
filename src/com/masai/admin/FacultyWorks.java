package com.masai.admin;

import com.masai.Execeptions.AdminException;
import com.masai.Execeptions.AuthenticationFailException;
import com.masai.Execeptions.UpdateDetailsException;
import com.masai.Execeptions.ViewDetailsException;
import com.masai.bean.CoursePlan;

public interface FacultyWorks {

	public void viewCoursePlan(String facultyName) throws ViewDetailsException;
	
	public void fillCoursePlan(CoursePlan coursePlan) throws UpdateDetailsException;
	
	public void updatePassword(String username,String password,String new_username) throws AuthenticationFailException;
	
	public void updateStatus(int day) throws UpdateDetailsException;
}

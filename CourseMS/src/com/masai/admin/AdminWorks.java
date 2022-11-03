package com.masai.admin;

import com.masai.Execeptions.AdminException;
import com.masai.Execeptions.CreateDetailsException;
import com.masai.Execeptions.UpdateDetailsException;
import com.masai.Execeptions.ViewDetailsException;
import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;

public interface AdminWorks {
	
	
	
	public void createCourse(Course course) throws CreateDetailsException;
	
	public void updateCourse(Course course) throws UpdateDetailsException;
	
	public void viewCourse(String courseName) throws ViewDetailsException;
	
	public void createBatch(Batch batch) throws CreateDetailsException;
	
	public void viewBatch(int batchid) throws ViewDetailsException;
	
	public void updateBatch(Batch batch) throws UpdateDetailsException;
	
	public void createFaculty(Faculty faculty) throws CreateDetailsException;
	
	public void updateFaculty(Faculty faculty) throws UpdateDetailsException;
	
	public void viewFaculty(int facultyid) throws ViewDetailsException;
	
	public void createCoursePlan(CoursePlan coursePlan) throws CreateDetailsException;
	
	public void updateCoursePlan(CoursePlan coursePlan) throws UpdateDetailsException;
	
	public void viewCoursePlan(int coursePlanID) throws ViewDetailsException;
	
	public void dayWiseUpdata(int day) throws AdminException;
	
	public void generateReport(int batchid) throws AdminException;

}

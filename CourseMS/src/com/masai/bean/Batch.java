package com.masai.bean;

public class Batch {
	
	private int batchId;
	private int courseId;
	private int facultyId;
	private int numberOfStudent;
	private String batchStartDate;
	private String duration;
	
	
	
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public int getNumberOfStudent() {
		return numberOfStudent;
	}
	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}
	public String getBatchStartDate() {
		return batchStartDate;
	}
	public void setBatchStartDate(String batchStartDate) {
		this.batchStartDate = batchStartDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	public Batch(int batchId, int courseId, int facultyId, int numberOfStudent, String batchStartDate,
			String duration) {
		
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.numberOfStudent = numberOfStudent;
		this.batchStartDate = batchStartDate;
		this.duration = duration;
	}
	
	
	public Batch() {
		
	}
	
	
	
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", courseId=" + courseId + ", facultyId=" + facultyId
				+ ", numberOfStudent=" + numberOfStudent + ", batchStartDate=" + batchStartDate + ", duration="
				+ duration + "]";
	}
	
	
}

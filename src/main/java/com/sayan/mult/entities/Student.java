package com.sayan.mult.entities;

public class Student implements IEntitiesMaster{
	
	private int studentId;
	private String studentName;
	private String studentAddress;
	
	public Student(int studentId, String studentName, String studentAddress) {		
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}
	
	
	
	public Student() {}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + getStudentId() 
					+ ", studentName=" + getStudentName() 
					+ ", studentAddress=" + getStudentAddress()
				+"]";
	}
	
	
	
}

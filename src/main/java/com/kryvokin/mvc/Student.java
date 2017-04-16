package com.kryvokin.mvc;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "students")
@NamedQueries({ @NamedQuery(name = Student.getAllStudents, query = "SELECT student FROM Student student"),
		@NamedQuery(name = Student.getStudentByPib, query = "SELECT student FROM Student student WHERE student.pib = :pib"),
		@NamedQuery(name = Student.getStudentsByCourse, query = "SELECT student FROM Student student WHERE student.course = :course") })
public class Student implements Serializable {
	public static final String getAllStudents = "Student.getAllStudents";
	public static final String getStudentByPib = "Student.getStudentByPib";
	public static final String getStudentsByCourse = "Student.getStudentsByCourse";
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int studentId;

	private String pib;
	private int course;

	public Student() {
	}

	public Student(int studentId, String pib, int course) {
		super();
		this.studentId = studentId;
		this.pib = pib;
		this.course = course;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public static String getGetallstudents() {
		return getAllStudents;
	}

	public static String getGetstudentbypib() {
		return getStudentByPib;
	}

	public static String getGetstudentsbycourse() {
		return getStudentsByCourse;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", pib=" + pib + ", course=" + course + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + course;
		result = prime * result + ((pib == null) ? 0 : pib.hashCode());
		result = prime * result + studentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (course != other.course)
			return false;
		if (pib == null) {
			if (other.pib != null)
				return false;
		} else if (!pib.equals(other.pib))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

}
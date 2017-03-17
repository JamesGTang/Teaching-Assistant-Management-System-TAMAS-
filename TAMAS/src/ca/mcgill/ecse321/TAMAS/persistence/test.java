package ca.mcgill.ecse321.TAMAS.persistence;


import ca.mcgill.ecse321.TAMAS.model.Course;
import ca.mcgill.ecse321.TAMAS.model.EceAdmin;
import ca.mcgill.ecse321.TAMAS.model.Job;
import ca.mcgill.ecse321.TAMAS.model.JobApplication;
import ca.mcgill.ecse321.TAMAS.model.Student;
import ca.mcgill.ecse321.TAMAS.model.Tamas;

public class test {
	// create a student
	String aName; 
	String aUsername;
	String aPassword;
	Tamas aTamas;
	String  aStudentId;
	boolean aIsGrad; 
	private JobApplication ja1;
	private JobApplication ja2; 
	JobApplicationPersistenceController jobApplicationPersistenceController=new JobApplicationPersistenceController();
	
	public void setUp(){
	aTamas=new Tamas(); 
	EceAdmin ecseadmin1=new EceAdmin("James","jt","231",aTamas);
	Course course1=new Course("ECSE223",4, aTamas, ecseadmin1);
	aTamas.addCourse(course1);
	
	// create student
	aName="Janet Mraz";
	aUsername="jmraz@ece.mcgill.com";
	aPassword="jmarz1234";
	aStudentId="1312231";
	aIsGrad=true;
	Student student1=new Student(aName, aUsername, aPassword, aTamas, aStudentId, aIsGrad);
	
	aName="Katherine Watkins";
	aUsername="kwatkins@ece.mcgill.com";
	aPassword="kwatkins1234";
	aStudentId="930182rt";
	aIsGrad=false;
	Student student2=new Student(aName, aUsername, aPassword, aTamas, aStudentId, aIsGrad);
	
	// add student
	ja1.setApplicant(student1);
	ja2.setApplicant(student2);
	
	// create experience
	String experience1="Experience of the student1";
	String experience2="Experience of the student2";
	
	// add experience
	ja1.setExperience("Hello");
	ja2.setExperience("Hello2");
	
	// create job post
	int aNumberOfHours=18;
	int aSalary=13;
	boolean aIsTaJob=true;
	boolean aIsAssignedToStudent=false;
	boolean aIsAllocatedToStudent=false;
	String aDescription="A test description!"; 
	String aDeadline="2019/May/15th";
	// ToDo:  why is ECEAdmin required for a Job Constructor? 
	EceAdmin aEceAdmin=new EceAdmin("Dylon Johns", "dj@ece.mcgill.ca", "dj231", aTamas); 
	Course aCourse=new Course("ECSE211",3, aTamas,aEceAdmin);
	Job job1=new Job(aNumberOfHours, aSalary, aIsTaJob, aIsAssignedToStudent, aIsAllocatedToStudent, aDescription, aDeadline, aCourse, aTamas);
	
	aNumberOfHours=10;
	aSalary=15;
	aIsTaJob=true;
	aIsAssignedToStudent=false;
	aIsAllocatedToStudent=false;
	aDescription="A test description!"; 
	aDeadline="2019/April/12th";
	// ToDo:  why is ECEAdmin required for a Job Constructor? 
	aEceAdmin=new EceAdmin("John Kimmel", "jk@ece.mcgill.ca", "jk123", aTamas); 
	aCourse=new Course("ECSE411",3, aTamas,aEceAdmin);
	//ToDo: add Job_Post_Id and schedule to umple
	Job job2=new Job(aNumberOfHours, aSalary, aIsTaJob, aIsAssignedToStudent, aIsAllocatedToStudent, aDescription, aDeadline, aCourse, aTamas);
	// add job 
	ja1.setAppliedJob(job1);
	ja2.setAppliedJob(job2);
	}
	
	public static void main(String[] args){
		test test=new test();
		test.setUp();
	}
}

package ca.mcgill.ecse321.TAMAS.controller;

import ca.mcgill.ecse321.TAMAS.model.Course;
import ca.mcgill.ecse321.TAMAS.model.Job;
import ca.mcgill.ecse321.TAMAS.model.JobApplication;
import ca.mcgill.ecse321.TAMAS.model.Student;
import ca.mcgill.ecse321.TAMAS.model.Tamas;
import ca.mcgill.ecse321.TAMAS.persistence.JobApplicationPersistenceController;

public class JobApplicationController {
	private JobApplication jApplication;
	private JobApplicationPersistenceController jaPersistenceController=new JobApplicationPersistenceController();
	public JobApplicationController(JobApplication ja){
		this.jApplication=ja;
	}
	public void addStudent(Student student) throws InvalidInputException{
		String error="";
		
		String aStudentId;
		String aName;
		String aPassword;
		Boolean aIsGrad;
		Tamas aTamas;
		String aUsername;
		
	    aStudentId=student.getStudentId();
		aName=student.getName();
		aPassword=student.getPassword();
		aTamas=new Tamas();
		aUsername=student.getUsername();
		aIsGrad=student.getIsGrad();
		
		if(aStudentId==null||aStudentId.trim().length()==0){
			error=error+"Student Id cannot be empty! ";
		}
		if(aName==null||aName.trim().length()==0){
			error=error+"Student name cannot be empty! ";
		}
		if(aPassword==null||aPassword.trim().length()==0){
			error=error+"Student password cannot be empty! ";
		}
		if(aUsername==null||aUsername.trim().length()==0){
			error=error+"Student email cannot be empty! ";
		}
		if(aIsGrad!=true||aIsGrad!=false){
			error=error+"Student status cannot be empty! ";
		}
	
		jApplication.setApplicant(student);
	}
	public void addExperience(String experience) throws InvalidInputException {
		String error="";
		if(experience==null||experience.length()==0){
			error=error+"Experience cannot be empty! ";
		}
		if(experience.length()<=20){
			error=error+"Experience cannot be less than 20 characters! ";
		}
		if(experience.length()>=2000){
			error=error+"Experience cannot be more than 2000 characters!";
		}
		error=error.trim();
		if(error.length()>0){
			throw new InvalidInputException(error);
		}
		jApplication.setExperience(experience);
	}
	// ToDo: add schedule to model
	public void addJob(Job aJob) throws InvalidInputException {
		String error="";
		int aNumberOfHours; 
		int aSalary;
		String aDescription;
		String aDeadline;
		Course aCourse;

		aNumberOfHours=aJob.getNumberOfHours();
		aSalary=aJob.getSalary();
		aDescription=aJob.getDescription();
		aDeadline=aJob.getDeadline();
		aCourse=aJob.getCourse();
		
		//ToDo: check the requirement for min hour
		if(aNumberOfHours<=45){
			error=error+"Number of hours cannot be lower or equal to 0! ";
		}
		if(aSalary<=0){
			error=error+"Salary cannot be lower or equal to 0! ";
		}
		// ToDo: check the requirement for max hour
		if(aNumberOfHours>=180){
			error=error+"Number of hours cannot be greaer than 180! ";
		}

		if(aDescription.length()<=10){
			error=error+"Job descritpion must have more than 10 characters! ";
		}
		if(aDescription.length()>=2000){
			error=error+"Job descritpion must have less than 2000 characters! ";
		}
		if(aDeadline==null){
			error=error+"Deadline not specified! ";
		}
		if(aCourse==null){
			error=error+"Course not specified! "; 
		}
		if(error.length()>0) throw new InvalidInputException(error);
		jApplication.setAppliedJob(aJob);
	}
	public void submitJobApplication(JobApplication jApplication) throws InvalidInputException{
		String errorstring="";
		
		if(jApplication.getApplicant()==null){
			errorstring=errorstring+"Applicant must specifed before submission! ";
		}else if(jApplication.getExperience()==null){
			errorstring=errorstring+"Experience must be specifed before submission! ";
		}else if(jApplication.getAppliedJob()==null){
			errorstring=errorstring+"Job must be specifed before submission! "; 
		}
		if(errorstring.length()>0) throw new InvalidInputException(errorstring);
		else{
			jaPersistenceController.submitJobApplication(jApplication);
		}
		
	}
}

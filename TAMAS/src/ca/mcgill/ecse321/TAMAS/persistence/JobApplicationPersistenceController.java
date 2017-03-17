package ca.mcgill.ecse321.TAMAS.persistence;
import ca.mcgill.ecse321.TAMAS.persistence.JobApplicationPersistence;

import java.util.StringTokenizer;

import org.omg.CORBA.PRIVATE_MEMBER;

import ca.mcgill.ecse321.TAMAS.model.JobApplication;

public class JobApplicationPersistenceController {
	
	static String applicant_cv;
    static String applicant_first_name;
    static String applicant_last_name;
    static String applicant_status;
    static String applicant_email;
    static int job_id;
    static int applicant_id;
    
	public String submitJobApplication(JobApplication jApplication){
		applicant_cv=jApplication.getExperience();
		String feedback="";
		if(jApplication.getApplicant().getIsGrad()==true){
			applicant_status="GRAD";
		}else{
			applicant_status="UGRAD";
		}
		applicant_email=jApplication.getApplicant().getUsername();
		job_id=jApplication.getAppliedJob().getJobId();
		applicant_id=Integer.valueOf(jApplication.getApplicant().getStudentId());
		
		String fullname=jApplication.getApplicant().getName();
		StringTokenizer stringTokenizer=new StringTokenizer(fullname, " ");
		applicant_first_name=stringTokenizer.nextToken();
		applicant_last_name=stringTokenizer.nextToken();
		// submit information to database
		feedback=JobApplicationPersistence.submitToDB(applicant_id, job_id, applicant_first_name, applicant_last_name, applicant_email, applicant_status, applicant_cv);
		return feedback;
	}
}
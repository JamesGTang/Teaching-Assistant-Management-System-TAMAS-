package ca.mcgill.ecse321.TAMAS.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.mcgill.ecse321.TAMAS.application.TamasApplication;
import ca.mcgill.ecse321.TAMAS.model.Course;
import ca.mcgill.ecse321.TAMAS.model.Instructor;
import ca.mcgill.ecse321.TAMAS.model.Job;
import ca.mcgill.ecse321.TAMAS.model.JobApplication;
import ca.mcgill.ecse321.TAMAS.model.Applicant;
import ca.mcgill.ecse321.TAMAS.persistence.JobApplicationPersistence;
import ca.mcgill.ecse321.TAMAS.persistence.JobPostingPersistence;


public class ApplicantController {

	public ApplicantController(){
	}
	
	
	public List<Course> getListOfCoursesWithOpenPositions(){
		ArrayList<Course> listOfCourses = new ArrayList<Course>();
		for (Course course : TamasApplication.getTamas().getCourses()) {
			// A Course hasOpenPositions when it has at least one Job IsPosted or AppliedTo
			int openPositions = 0;
			// Get the Jobs for each course
			for(Job job : course.getJobs()){
				String jobState = job.getJobStateFullName();
				if(jobState.equalsIgnoreCase("IsPosted") || jobState.equalsIgnoreCase("AppliedTo")){
					openPositions++;
				}
			}
			if (openPositions > 0) {
				listOfCourses.add(course);				
			}
		}
		return listOfCourses;
	}
	
	public List<Job> getAvailableJobs(Course course) {
		ArrayList<Job> listOfJobs = new ArrayList<Job>();
		for(Job job : course.getJobs()){
			String jobState = job.getJobStateFullName();
			if(jobState.equalsIgnoreCase("IsPosted") || jobState.equalsIgnoreCase("AppliedTo")){
			// job is open for applications
				listOfJobs.add(job);
			}
		}
		return listOfJobs;
	}
	
	public String displayJob(Job job){
		String jobTitle = job.getCourse().getCourseCode();
		String jobType = job.getJobTypeFullName(); // Get jobType as a String
		if(jobType.equalsIgnoreCase("TaJob")){
			return jobTitle + " TA "; 
		}
		else{
			return jobTitle + " Marker ";
		}
	}
	
	public String getDetailsOfJob(Job job){
		String Instructors = "";
		int nIns = job.getCourse().numberOfInstructors();
		if(nIns == 1){
			String name = job.getCourse().getInstructor(0).getName();
			Instructors = "Instructor: " + name + " ";
		}
		else{
			Instructors = "Instructors: ";
			for(int i=0; i<nIns; i++){
				String name = job.getCourse().getInstructor(i).getName();
				if (i<nIns-1){
					Instructors = Instructors + name + ", ";
				}
				else{
					Instructors = Instructors + name + " ";
				}
			}
		}
		
		// Add hours
		String details = "\n" + Instructors + "\n\nDescription: " + job.getDescription() + "\n";
		return details;
	}
	
	public JobApplication initialApplyForJob(String experience, Applicant applicant, Job job){
		// This method takes the Applicant info+CV and the job, then creates a JobApplication 
		// Applicant info+CV is the Applicant's attributes and their experience
		JobApplication jobApplication = new JobApplication(experience, applicant, job);

		return jobApplication;
	}
	
	public void applyForJob( int applicant_id,int job_id,String fname,String lname,
			String email,String status, String cv){

		JobApplicationPersistence jap = new JobApplicationPersistence();
		jap.submitToDB( applicant_id, job_id, fname, lname, email, status, cv);
	}

	public JobApplication applyForJob(String experience, Applicant applicant, Job job){
		// This method takes the Applicant info+CV and the job, then creates a JobApplication 
		// Applicant info+CV is the Applicant's attributes and their experience
		JobApplication jobApplication = new JobApplication(experience, applicant, job);

		return jobApplication;
	}
	
}

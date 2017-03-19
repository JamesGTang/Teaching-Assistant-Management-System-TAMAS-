package ca.mcgill.ecse321.TAMAS.persistence;

import ca.mcgill.ecse321.TAMAS.persistence.StudentRecordPersistence;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.StringTokenizer;

import ca.mcgill.ecse321.TAMAS.application.TamasApplication;
import ca.mcgill.ecse321.TAMAS.model.Student;
import ca.mcgill.ecse321.TAMAS.model.Tamas;

public class StudentRecordPersistenceController{
	private String passwordString;
	private String lnameString;
	private String fnameString;
	private int id;
	private String statusString; 
	private String emailString;
	
	public StudentRecordPersistenceController(String passwordString,String 
			lnameString,String fnameString,String id, String statusString,String emailsString){
		this.passwordString=passwordString;
		this.emailString=emailsString;
		this.fnameString=fnameString;
		this.lnameString=lnameString;
		if(id.isEmpty()){
			
		}else{
			try {
				this.id=Integer.parseInt(id);
			} catch (Exception e) {
				System.out.println("Student id not formated correctly!");
			}
		}
		
		this.statusString=statusString; 
	}
	
	/* ToDo: implement method
	public Student createStudent(){
		Tamas aTamas=TamasApplication.getTamas();
		Student aStudent=new Student(fnameString+" "+lnameString, emailString, passwordString, aTamas, id,)
		
	}*/
	public void registerStudent(){
		
		StudentRecordPersistence.registerStudentToDB(id, fnameString, lnameString, statusString, emailString, passwordString);
	}
	
	public int verifyAllInput(){
		// 0 is the default status code : success
		
		if(fnameString.length()==0 || fnameString.length()>=18){
			return 1;
		}
		if(lnameString.length()==0 || lnameString.length()>=18){
			return 2;
		}
		
		int lengthofid=String.valueOf(id).length();
		if(lengthofid!=9){
			return 3;
		}
		if(!statusString.equals("UGRAD") && !statusString.equals("GRAD")||statusString==null){
			return 4;
		}
		if(!isValidSchoolEmailAddress(emailString)){
			return 5;
		}
		
		if(passwordString.length()==0 || passwordString.length()>=18){
			return 6;
		}
		return 0; 
	}
	
	public static boolean isNumeric(String str)
	{
	  NumberFormat formatter = NumberFormat.getInstance();
	  ParsePosition pos = new ParsePosition(0);
	  formatter.parse(str, pos);
	  return str.length() == pos.getIndex();
	}
	public static boolean isValidSchoolEmailAddress(String email) {
		System.out.println("Verifying email address!");
		   StringTokenizer stringTokenizer=new StringTokenizer(email,"@");
		   try {
			   stringTokenizer.nextElement();
			   String domainNameString=stringTokenizer.nextElement().toString();
			   System.out.println("Domain name is: "+domainNameString);
			   if(domainNameString.equals("ece@mcgill.ca")) {
				   System.out.println("The email address is a valid ECE email!");
				   return false;
			   }
			    else return true;
		} catch (Exception e) {
			return false;
		}
		   
	}
	
}

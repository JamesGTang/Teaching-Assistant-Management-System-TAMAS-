package ca.mcgill.ecse321.TAMAS.persistence;

import ca.mcgill.ecse321.TAMAS.persistence.StudentRecordPersistence;

import java.text.NumberFormat;
import java.text.ParsePosition;

import ca.mcgill.ecse321.TAMAS.model.Student;

public class StudentRecordPersistenceController{
	private String passwordString;
	private String lnameString;
	private String fnameString;
	private int id;
	private String statusString; 
	private String emailString;
	
	public StudentRecordPersistenceController(String passwordString,String 
			lnameString,String fnameString,int id, String statusString,String emailsString){
		this.passwordString=passwordString;
		this.emailString=emailsString;
		this.fnameString=fnameString;
		this.lnameString=lnameString;
		this.id=id;
		this.statusString=statusString; 
	}
	public void registerStudent(Student aStudent){
		StudentRecordPersistence.registerStudentToDB(id, fnameString, lnameString, statusString, emailString, passwordString);
	}
	public int verifyAllInput(){
		// 0 is the default status code : success
		if(passwordString.length()==0 || passwordString.length()>=18){
			return 6;
		}
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
		if(!statusString.equals("UGRAD")|| !statusString.equals("GRAD")||statusString==null){
			return 4;
		}
		char emailArray()
		
		return 0; 
	}
	
	public static boolean isNumeric(String str)
	{
	  NumberFormat formatter = NumberFormat.getInstance();
	  ParsePosition pos = new ParsePosition(0);
	  formatter.parse(str, pos);
	  return str.length() == pos.getIndex();
	}
	
}

package ca.mcgill.ecse321.TAMAS.application;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import ca.mcgill.ecse321.TAMAS.model.Person;
import ca.mcgill.ecse321.TAMAS.model.Tamas;
import ca.mcgill.ecse321.TAMAS.model.Course;
import ca.mcgill.ecse321.TAMAS.model.Job;
import ca.mcgill.ecse321.TAMAS.view.*;
import java.io.*;

public class TamasApplication {
	
	private static Tamas tamas;
	private static String filename = "data.tamas";
	
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		//PostJobPage page = new PostJobPage();
		
		/* ToDo: Remove graphics and set size to 300 600*/
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
		int width = gd.getDisplayMode().getWidth();
		
		System.out.println("The width is "+width);
		int height=gd.getDisplayMode().getHeight();
		System.out.println("The height is "+height);
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	LoginPage page = new LoginPage();
               	page.setVisible(true);
               	((JFrame) page).setSize(height*9/16,height-200);
            }
        });

	}
	public static Tamas getTamas() {
		if (tamas == null) {
			// load model
			tamas = load();
		}
		return tamas;
	}

	public static void save() {
		
	}

	public static Tamas load() {
		
		// model cannot be loaded - create empty Tamas
		if (tamas == null) {
			tamas = new Tamas();
		} else {
			//do something
		}
		return tamas;
	}

	public static void setFilename(String newFilename) {
		filename = newFilename;
	}

}
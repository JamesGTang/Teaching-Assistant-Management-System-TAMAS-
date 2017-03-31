package ca.mcgill.ecse321.TAMAS.view;



import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GoToLoginPage extends JFrame {
private JButton InstructorLog;
private JButton StudentLog;
private JButton EceLog;
private JLabel Instructor;
private JLabel Student;
private JLabel ECE;


public GoToLoginPage() {
	initComponents();	
}

private void initComponents(){
	
	getContentPane().setBackground(Color.decode("#C63D0F"));
	InstructorLog = new JButton("Instructor Login");
	StudentLog = new JButton("Applicant Login");
	EceLog = new JButton("ECE Admin Login");
	Instructor = new JLabel("If you are an instructor :");
	Student = new JLabel("If you are an applicant :");
	ECE = new JLabel("If you are a member of the administration :");
	
	Instructor.setFont(new Font("Gotham",Font.BOLD,12));
	Instructor.setForeground(Color.white);
	Student.setFont(new Font("Gotham",Font.BOLD,12));
	Student.setForeground(Color.white);
	ECE.setFont(new Font("Gotham",Font.BOLD,12));
	ECE.setForeground(Color.white);
	
	InstructorLog.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			InstructorLogActionPerformed(evt);
		}
		});
	
	StudentLog.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			StudentLogActionPerformed(evt);
		}
		});
	
	EceLog.addActionListener(new java.awt.event.ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			EceLogActionPerformed(evt);
		}
		});
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Choose your login page");
	
	JPanel panel = new JPanel();
	panel.add(InstructorLog);
	panel.add(StudentLog);
	panel.add(EceLog);
	panel.add(Instructor);
	panel.add(Student);
	panel.add(ECE);
	
	getContentPane().add(panel);
	
	GroupLayout layout = new GroupLayout(getContentPane());
	getContentPane().setLayout(layout);
	layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
    
    layout.setHorizontalGroup(layout.createSequentialGroup()
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    				.addComponent(Instructor)
    				.addComponent(Student)
    				.addComponent(ECE)	)	
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    				.addComponent(InstructorLog)
    				.addComponent(StudentLog)
    				.addComponent(EceLog))
    		);
    
    layout.setVerticalGroup(layout.createSequentialGroup()
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				.addComponent(Instructor)
    				.addComponent(InstructorLog))
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				.addComponent(Student)
    				.addComponent(StudentLog))
    		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
    				.addComponent(ECE)
    		.addComponent(EceLog))
    		);
    
    pack();	
}



private void InstructorLogActionPerformed(java.awt.event.ActionEvent evt){}

private void StudentLogActionPerformed(java.awt.event.ActionEvent evt){}

private void EceLogActionPerformed(java.awt.event.ActionEvent evt){}



}

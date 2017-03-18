package ca.mcgill.ecse321.TAMAS.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import ca.mcgill.ecse321.TAMAS.persistence.StudentRecordPersistence;

public class LoginPage extends JFrame{
		
	private JLabel feedbackMessage;
		private String error = null;
		private JPanel loginPanel; 
		private JLabel usernameLabel;
		private JLabel passwordLabel;
		private JTextField username;
		private JPasswordField password;
		private JButton login;
		private JButton registerButton;
		
		public LoginPage() {
			initComponents();
			refreshData();	
		}
		
		private void initComponents(){
			
			GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
			int screenHeight=gd.getDisplayMode().getHeight();
			
			getContentPane().setBackground(Color.decode("#C63D0F"));
						
			// label for username and password
			usernameLabel = new JLabel("Username (Email or ID):");
			passwordLabel = new JLabel("Password:");
			
			usernameLabel.setForeground(Color.white);
			passwordLabel.setForeground(Color.white);
			
			// textfield for username
			username = new JTextField();
			
			// password field for password
			password = new JPasswordField();
			
			// register b
			// login button
			login = new JButton("Login");
			registerButton=new JButton("Register");
			login.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					loginActionPerformed(evt);
				}});

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Login Page");
			
			GroupLayout layout = new GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			
			layout.setAutoCreateGaps(true);
			layout.setAutoCreateContainerGaps(true);
			
			 layout.setHorizontalGroup(layout.createSequentialGroup()
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(usernameLabel)
			            	.addComponent(passwordLabel))
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(username)
				            	.addComponent(password)
				            	.addComponent(login)
				            	
							 )	
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				            	.addComponent(registerButton)
							 )	
			 );
			 
			 layout.setVerticalGroup(layout.createSequentialGroup()
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(usernameLabel)
			            		.addComponent(username))
					 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            		.addComponent(passwordLabel)
			            		.addComponent(password))
			         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			        		 .addComponent(login)
			        		 .addComponent(registerButton)
			        		 )
			 );
			
			pack();
			
			registerButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					registerButtonActionPerformed(e);
				}
			});
			
		}

		private void refreshData(){
		
			// error
			//errorMessage.setText(error);
			
			//description.setText("");
		}
		
		private void loginActionPerformed(java.awt.event.ActionEvent evt){
			String user_name = username.getText();
			String pass_word = password.getText();
			
			StudentRecordPersistence srp = new StudentRecordPersistence();
			
			//if numeric getStudentPasswordByID 
					//if pass matches let them in
					//else print error message
			//if not
			refreshData();
		}
		private void registerButtonActionPerformed(java.awt.event.ActionEvent evt){
			System.out.println("Switching to register view");
			RegisterPage page = new RegisterPage();
           	page.setVisible(true);
           	
           	// get height and width of display
           	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
    		int height=gd.getDisplayMode().getHeight();

    		// set the size of the JFrame
           	((JFrame) page).setSize(height*9/16,height);
		}
}

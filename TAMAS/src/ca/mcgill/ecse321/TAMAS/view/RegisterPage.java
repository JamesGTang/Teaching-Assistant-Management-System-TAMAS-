package ca.mcgill.ecse321.TAMAS.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.omg.CORBA.PRIVATE_MEMBER;

import javafx.scene.control.RadioButton;
import jdk.nashorn.internal.runtime.UserAccessorProperty;

public class RegisterPage extends JFrame{
	JLabel tamasLabel;
	JLabel welcomeLabel;
	JLabel feedbackLabel;
	JLabel fnameLabel;
	JLabel lnameLabel;
	JLabel gradLabel;
	JLabel ugradJLabel;
	JLabel emaiLabel;
	JLabel passwordLabel;
	JLabel idLabel;
	
	JTextField fnameField;
	JTextField lnameField;
	JTextField idField;
	JRadioButton ugradRadioButton;
	JRadioButton gradRadioButton;
	JTextField emailField;
	JTextField passwordField;
	JButton registerButton;
	JButton backtosigninButton;
	
	public void initComponents() {
		tamasLabel=new JLabel("TAMAS");
		getContentPane().setBackground(Color.decode("#C63D0F"));
		
		tamasLabel.setFont(new Font("Gotham",Font.BOLD,50));
		welcomeLabel=new JLabel("Please register below");
		feedbackLabel=new JLabel();
		fnameLabel=new JLabel("First name: ");
		lnameLabel=new JLabel("Last name: ");
		emaiLabel=new JLabel("Email: ");
		passwordLabel=new JLabel("Password: ");
		idLabel=new JLabel("Id: ");
		
		fnameField=new JTextField();
		lnameField=new JTextField();
		idField=new JTextField();
		ugradRadioButton=new JRadioButton("Undergraduate");
		gradRadioButton=new JRadioButton("Graduate");
		emailField=new JTextField();
		passwordField=new JPasswordField();
		registerButton=new JButton("Register");
		
		backtosigninButton=new JButton("Back to signin");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login Page");
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(tamasLabel)
						.addComponent(fnameLabel)
						.addComponent(lnameLabel)
						.addComponent(idLabel)
						.addComponent(ugradRadioButton)
						.addComponent(emaiLabel)
						.addComponent(passwordLabel)
						.addComponent(registerButton)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(fnameField)
						.addComponent(lnameField)
						.addComponent(idField)
						.addComponent(gradRadioButton)
						.addComponent(emailField)
						.addComponent(passwordField)
						.addComponent(backtosigninButton)
						)
				);
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tamasLabel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(fnameLabel)
						.addComponent(fnameField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lnameLabel)
						.addComponent(lnameField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(idLabel)
						.addComponent(idField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(ugradRadioButton)
						.addComponent(gradRadioButton)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(emaiLabel)
						.addComponent(emailField)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(passwordLabel)
						.addComponent(passwordField)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(registerButton)
						.addComponent(backtosigninButton)
						));
		// Add action listen 
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registerStudent();
				refreshData();
			}
		});
		backtosigninButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Switching to signin view");
				LoginPage page = new LoginPage();
	           	page.setVisible(true);
	           	
	           	// get height and width of display
	           	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
	    		int height=gd.getDisplayMode().getHeight();

	    		// set the size of the JFrame
	           	((JFrame) page).setSize(height*9/16,height);
				
			}
		});
		
	}
	
	public RegisterPage(){
		System.out.println("Initializting view for register page");
		initComponents();
	}
	
	private void refreshData(){
		
		// error
		//errorMessage.setText(error);
		
		//description.setText("");
	}
	
	private void registerStudent(){
		String paswordString;
		String lnameString;
		String fnameString;
		int id;
		String statusString; 
		String emailString;
		
	}
}

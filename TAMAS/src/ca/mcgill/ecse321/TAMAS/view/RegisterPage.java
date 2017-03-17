package ca.mcgill.ecse321.TAMAS.view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegisterPage extends JFrame{
	JLabel feedbackLabel;
	JTextField fnameField;
	JTextField lnameField;
	JTextField idField;
	JRadioButton ugradRadioButton;
	JRadioButton gradRadioButton;
	JTextField emailField;
	JTextField passwordField;
	JButton registerButton;
	JButton backtosigninButton;
	
	public RegisterPage() {
		initComponents();
		refreshData();
	}
	
	private void initComponents(){
		//set pane properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Register Page");
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		// add action listener
		
		// add feedback
		feedbackLabel=new JLabel();
		feedbackLabel.setText("Please register!");

		

		
		pack();
	}
	
	private void refreshData(){
		
		// error
		//errorMessage.setText(error);
		
		//description.setText("");
	}
}

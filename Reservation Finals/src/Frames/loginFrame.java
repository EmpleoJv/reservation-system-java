package Frames;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class loginFrame {
	
	JFrame login = new JFrame();
	
	JLabel labelUsername = new JLabel("Username");
	JTextField textFieldUsername = new JTextField(60);
	JLabel labelPassword = new JLabel("Password");
	JPasswordField textFieldPassword = new JPasswordField();

	JButton buttonToLogin = new JButton("Login");
	JButton buttonClear = new JButton("Clear");

	
	Font fontLabel = new Font(Font.SANS_SERIF, Font.BOLD, 23);
	Font fontTextField = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
	Font fontButton = new Font(Font.SANS_SERIF, Font.BOLD, 20);

	public loginFrame() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\emple\\Desktop\\JAVAJARS\\ImageCodes\\LOGO.png");    

		labelUsername.setFont(fontLabel);
		labelPassword.setFont(fontLabel);
		
		textFieldUsername.setFont(fontTextField);
		textFieldPassword.setFont(fontTextField);
		
		buttonToLogin.setFont(fontButton);
		buttonClear.setFont(fontButton);

		labelUsername.setBounds(70,30,155,35);
		textFieldUsername.setBounds(50,70,155,35);
		labelPassword.setBounds(305,30,155,35);
		textFieldPassword.setBounds(280,70,155,35);

		buttonToLogin.setBounds(80,150,155,35);
		buttonClear.setBounds(250,150,155,35);

//		textFieldPassword.setEchoChar('*');
		
		login.add(labelUsername);
		login.add(textFieldUsername);
		login.add(labelPassword);
		login.add(textFieldPassword);
		
		login.add(buttonToLogin);
		login.add(buttonClear);

		login.setSize(500, 300);
		login.setTitle("Login");
		login.setLayout(null);
		login.setIconImage(icon);    

		login.setLocationRelativeTo(null);
		login.setVisible(true);
		login.setResizable(false);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buttonToLogin.addActionListener(new actionLoginButton ());
		buttonClear.addActionListener(new actionClearButton ());

//	    b.addActionListener(new ActionListener(){  
//	    	public void actionPerformed(ActionEvent e){  
//	    	            tf.setText("Welcome to Javatpoint.");  
//	    	        }  
//	    	    });  
	}
	
	class actionLoginButton implements ActionListener {
		@Override
		public void	actionPerformed(ActionEvent a) {
			
			if(textFieldUsername.getText().isBlank() || textFieldPassword.getText().isBlank()) {
			    JOptionPane.showMessageDialog(login, "Don't leave empty box", "Warning", JOptionPane.WARNING_MESSAGE);			
			}else {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation_system","root", "");
		            java.sql.Statement stmt = conn.createStatement();
		            String sql = "Select * from user where Username='"+textFieldUsername.getText()+"' and Password='"+textFieldPassword.getText()+"'";		         
		            ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
		            if(rs.next()) {
		            	login.dispose();
		        		MainPage toAnotherPage = new MainPage();
		            }else {
					    JOptionPane.showMessageDialog(login, "Username or Password are incorrect", "Warning", JOptionPane.WARNING_MESSAGE);			
		            }
//		            conn.close();
		        }
		        catch(Exception e) {
				    JOptionPane.showMessageDialog(login, "Error: Something went wrong" + e, "Warning", JOptionPane.WARNING_MESSAGE);			
		        }
			}
		}
	}
	
	class actionClearButton implements ActionListener {
		@Override
		public void	actionPerformed(ActionEvent a) {
			textFieldUsername.setText("");
			textFieldPassword.setText("");
		}
	}
	public static void main(String []args) {
		loginFrame frame = new loginFrame();
	}
}

package Frames;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter; 
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

class MainPage {
	
	JFrame mainFrame = new JFrame();

	Font fontLabel = new Font(Font.SANS_SERIF, Font.BOLD, 23);
	Font fontLabelTwo = new Font(Font.SANS_SERIF, Font.PLAIN, 23);
	Font fontLableInput = new Font(Font.SANS_SERIF, Font.BOLD, 23);

	Font fontTextField = new Font(Font.DIALOG_INPUT, Font.PLAIN, 20);
	Font fontTextField2 = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
	Font fontButton = new Font(Font.SANS_SERIF, Font.BOLD, 20);

	ImageIcon imageIcon = new ImageIcon
			(new ImageIcon("C:\\Users\\emple\\Desktop\\JAVAJARS\\ImageCodes\\LOGO.png")
					.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	JLabel ImageLogo = new JLabel(imageIcon); 
	
	ImageIcon QRDefualt = new ImageIcon
			(new ImageIcon("C:\\Users\\emple\\Desktop\\JAVAJARS\\ImageCodes\\LOGO.png")
					.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
	JLabel QRCodeLogo = new JLabel(QRDefualt); 



	JLabel labelBarangay = new JLabel("Barangay 289, Zone 24, Distict III.");
	JLabel labelBarangayTwo = new JLabel("Binondo, Manila 1006 Metro Manila");
	
	JLabel lableFirstName = new JLabel("First Name");
	JLabel lableLastName = new JLabel("Last Name");
	JLabel lableMiddleInitial = new JLabel("Middle Initial");
	JLabel lableAge = new JLabel("Age");
	JLabel lableMobileNumber = new JLabel("Mobile Number");
	JLabel lableAddress = new JLabel("Address");
	JLabel lableBarangayZoneDistrict = new JLabel("Barangay, Zone, District");
	JLabel lableEmail = new JLabel("Email");
	JLabel lableValidId = new JLabel("Any Valid ID");
	JLabel lableIdNumber = new JLabel("ID Number");
	JLabel lableGovtAgen = new JLabel("Govt. Agen");
	JLabel lableReason = new JLabel("Reason of Visit");


	JTextField fieldFirstName = new JTextField();
	JTextField fieldLastName = new JTextField();
	JTextField fieldMiddleInitial = new JTextField();
	JTextField fieldAge = new JTextField();
	JTextField fieldMobileNumber = new JTextField();
	JTextField fieldAddress = new JTextField();
	JTextField fieldBarangayZoneDistrict = new JTextField();
	JTextField fieldEmail = new JTextField();
	JTextField fieldValidId = new JTextField();
	JTextField fieldIdNumber = new JTextField();
	JTextField fieldReason = new JTextField();

	
    String ListYear[] = {"Overseas Workers Welfare Administration (OWWA)",
    		"Philippine Health Insurance Corporation (PHILHEALTH)",
    		"Philippine Overseas Employment Administration (POEA)",
    		"Department of Labor and Employment (DOLE)",
    		"Department of Trade and Industry (DTI)",
    		"Bureau of Immigration (BI)",
    		"Commission on Filipinos Overseas (CFO)",
    		"Bangko Sentral ng Pilipinas (BSP)",
    		"Commission of Elections (COMELEC)",
    		"Department of Tourism (DOT)",
    		"Office of the President (OP)",
    		"Office of the Press Secretary (OPS)",
    		"Overseas Absentee Voting Secretariat (OAVS)",
    		"National Economic and Development Authority (NEDA)",
    		"PAGIBIG Home Development Mutual Fund",
    		"Social Security System (SSS)",
    		"Philippine Institute for Development Studies (PIDS)",
    		"Bureau of Customs"};   
	JComboBox<Object> fieldGovtAgen = new JComboBox<Object>(ListYear);   

	JButton buttonHEXGenerator = new JButton("Code Generator");
	JLabel lableCodeGenerated = new JLabel("Reservation Code: ");
	JLabel lableCodeGeneratedTwo = new JLabel("123456789");

	JButton lableSave = new JButton("Save");
	JButton Data = new JButton("Database");
	
	static String qrCodeData;
	static String database;


	public MainPage() {
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\emple\\Desktop\\JAVAJARS\\ImageCodes\\LOGO.png");    
		
		fieldFirstName.setFont(fontTextField);
		fieldLastName.setFont(fontTextField);
		fieldMiddleInitial.setFont(fontTextField);
		fieldAge.setFont(fontTextField);
		fieldMobileNumber.setFont(fontTextField);
		fieldAddress.setFont(fontTextField);
		fieldBarangayZoneDistrict.setFont(fontTextField);
		fieldEmail.setFont(fontTextField);
		fieldValidId.setFont(fontTextField);
		fieldIdNumber.setFont(fontTextField);
		fieldGovtAgen.setFont(fontTextField);
		fieldReason.setFont(fontTextField);

		labelBarangay.setFont(fontLabel);
		labelBarangayTwo.setFont(fontLabelTwo);

		lableFirstName.setFont(fontLableInput);
		lableLastName.setFont(fontLableInput);
		lableMiddleInitial.setFont(fontLableInput);
		lableAge.setFont(fontLableInput);
		lableMobileNumber.setFont(fontLableInput);
		lableAddress.setFont(fontLableInput);
		
		lableBarangayZoneDistrict.setFont(fontLableInput);
		lableEmail.setFont(fontLableInput);
		lableValidId.setFont(fontLableInput);
		lableIdNumber.setFont(fontLableInput);

		buttonHEXGenerator.setFont(fontButton);
		lableCodeGenerated.setFont(fontTextField2);
		lableCodeGeneratedTwo.setFont(fontTextField2);
		lableGovtAgen.setFont(fontLableInput);
		lableReason.setFont(fontLableInput);

		
		
		lableSave.setFont(fontButton);
		Data.setFont(fontButton);

		
		labelBarangay.setBounds(65,3,600,35);
		labelBarangayTwo.setBounds(80,25,600,35);
		ImageLogo.setBounds(10, 10, 50, 50);
		// Input Location
		//Right
		lableFirstName.setBounds(90,100,150,35);
		fieldFirstName.setBounds(80,132,250,35);
		lableLastName.setBounds(90,160,250,35);
		fieldLastName.setBounds(80,192,250,35);
		lableMiddleInitial.setBounds(90,220,250,35);
		fieldMiddleInitial.setBounds(80,252,250,35);
		lableAge.setBounds(90,280,250,35);
		fieldAge.setBounds(80,312,250,35);
		lableMobileNumber.setBounds(90,340,250,35);
		fieldMobileNumber.setBounds(80,372,250,35);
		lableAddress.setBounds(90,400,250,35);
		fieldAddress.setBounds(80,432,250,35);
		lableGovtAgen.setBounds(90,460,250,35);
		fieldGovtAgen.setBounds(80,492,650,35);
		lableReason.setBounds(90,520,650,35);
		fieldReason.setBounds(80,552,250,35);

		
		lableSave.setBounds(525,592,250,35);
		Data.setBounds(1150,10,150,35);

		
		//left 
		lableBarangayZoneDistrict.setBounds(410,100,300,35);
		fieldBarangayZoneDistrict.setBounds(400,132,350,35);
		lableEmail.setBounds(410,160,250,35);
		fieldEmail.setBounds(400,192,350,35);
		lableValidId.setBounds(410,220,250,35);
		fieldValidId.setBounds(400,252,350,35);
		lableIdNumber.setBounds(410,280,250,35);
		fieldIdNumber.setBounds(400,312,350,35);
		// Input Location
		buttonHEXGenerator.setBounds(400,370,270,35);
		lableCodeGenerated.setBounds(400,410,350,35);
		lableCodeGeneratedTwo.setBounds(400,430,350,35);

		QRCodeLogo.setBounds(40, 50, 2000, 500);

		mainFrame.add(ImageLogo);
		mainFrame.add(labelBarangay);
		mainFrame.add(labelBarangayTwo);
		// Input Location
		// Right
		mainFrame.add(lableFirstName);
		mainFrame.add(fieldFirstName);
		mainFrame.add(lableLastName);
		mainFrame.add(fieldLastName);
		mainFrame.add(lableMiddleInitial);
		mainFrame.add(fieldMiddleInitial);
		mainFrame.add(lableAge);
		mainFrame.add(fieldAge);
		mainFrame.add(lableMobileNumber);
		mainFrame.add(fieldMobileNumber);
		mainFrame.add(lableAddress);
		mainFrame.add(fieldAddress);
		mainFrame.add(lableGovtAgen);
		mainFrame.add(fieldGovtAgen);
		mainFrame.add(lableReason);
		mainFrame.add(fieldReason);

		mainFrame.add(lableSave);
		mainFrame.add(Data);

		//Left
		mainFrame.add(lableBarangayZoneDistrict);
		mainFrame.add(fieldBarangayZoneDistrict);
		mainFrame.add(lableEmail);
		mainFrame.add(fieldEmail);
		mainFrame.add(lableValidId);
		mainFrame.add(fieldValidId);
		mainFrame.add(lableIdNumber);
		mainFrame.add(fieldIdNumber);
		// Input Location
		
		mainFrame.add(buttonHEXGenerator);
		mainFrame.add(lableCodeGenerated);
		mainFrame.add(lableCodeGeneratedTwo);

		mainFrame.add(QRCodeLogo);

		mainFrame.setSize(1350, 700);
		mainFrame.setTitle("Reservation/Appointment System");
		mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setIconImage(icon);    
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		buttonHEXGenerator.addActionListener(new QRCodeGenerator());
		lableSave.addActionListener(new SaveCredentialsToDatabse());

		Data.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
	    	mainFrame.dispose();
	    	new DatabasePage();
	    }
	    
	    }); 
		
	}
	
	class SaveCredentialsToDatabse implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			if(fieldFirstName.getText().isBlank()||
					fieldLastName.getText().isBlank()||
					fieldMiddleInitial.getText().isBlank()||
					fieldAge.getText().isBlank()||
					fieldMobileNumber.getText().isBlank()||
					fieldAddress.getText().isBlank()||
					fieldBarangayZoneDistrict.getText().isBlank()||
					fieldEmail.getText().isBlank()||
					fieldValidId.getText().isBlank()||
					fieldIdNumber.getText().isBlank()||
					fieldReason.getText().isBlank()){
	            
				JOptionPane.showMessageDialog(null, "Don't left any textfield empty!!");
	            
			}else {
				
				if(fieldGovtAgen.getSelectedItem().equals("Overseas Workers Welfare Administration (OWWA)")) {
					database = "owwa";
				}else if(fieldGovtAgen.getSelectedItem().equals("Philippine Health Insurance Corporation (PHILHEALTH)")) {
					database = "philhealth";
				}else if(fieldGovtAgen.getSelectedItem().equals("Philippine Overseas Employment Administration (POEA)")) {
					database = "poea";
				}else if(fieldGovtAgen.getSelectedItem().equals("Department of Labor and Employment (DOLE)")) {
					database = "dole";
				}else if(fieldGovtAgen.getSelectedItem().equals("Department of Trade and Industry (DTI)")) {
					database = "dti";
				}else if(fieldGovtAgen.getSelectedItem().equals("Bureau of Immigration (BI)")) {
					database = "bi";			
				}else if(fieldGovtAgen.getSelectedItem().equals("Commission on Filipinos Overseas (CFO)")) {
					database = "cfo";			
				}else if(fieldGovtAgen.getSelectedItem().equals("Bangko Sentral ng Pilipinas (BSP)")) {
					database = "bsp";				
				}else if(fieldGovtAgen.getSelectedItem().equals("Commission of Elections (COMELEC)")) {
					database = "comelec";				
				}else if(fieldGovtAgen.getSelectedItem().equals("Department of Tourism (DOT)")) {
					database = "dot";				
				}else if(fieldGovtAgen.getSelectedItem().equals("Office of the President (OP)")) {
					database = "op";					
				}else if(fieldGovtAgen.getSelectedItem().equals("Office of the Press Secretary (OPS)")) {
					database = "ops";					
				}else if(fieldGovtAgen.getSelectedItem().equals("Overseas Absentee Voting Secretariat (OAVS)")) {
					database = "oavs";					 
				}else if(fieldGovtAgen.getSelectedItem().equals("National Economic and Development Authority (NEDA)")) {
					database = "neda";				
				}else if(fieldGovtAgen.getSelectedItem().equals("PAGIBIG Home Development Mutual Fund")) {
					database = "pagibigfund";				
				}else if(fieldGovtAgen.getSelectedItem().equals("Social Security System (SSS)")) {
					database = "sss";					
				}else if(fieldGovtAgen.getSelectedItem().equals("Philippine Institute for Development Studies (PIDS)")) {
					database = "pids";					
				}else if(fieldGovtAgen.getSelectedItem().equals("Bureau of Customs")) {
					database = "boc";
				}
				try {

		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation_system","root", "");
		            Statement statement = conn.createStatement();	            		       
		            int update = statement.executeUpdate("insert into "+database+" "
		            		+ "values (NULL,'"+qrCodeData+"', '"+fieldFirstName.getText()+"', '"+fieldLastName.getText()+"','"+fieldMiddleInitial.getText()+"','"+fieldAge.getText()+"','"+fieldMobileNumber.getText()+"','"+fieldAddress.getText()+"','"+fieldBarangayZoneDistrict.getText()+"','"+fieldEmail.getText()+"','"+fieldValidId.getText()+"','"+fieldIdNumber.getText()+"','"+fieldReason.getText()+"'); ");
				    JOptionPane.showMessageDialog(null, "Saved", "Warning", JOptionPane.WARNING_MESSAGE);			
		        }
		        catch(Exception e) {
				    JOptionPane.showMessageDialog(null, "Error: Something went wrong" + e, "Warning", JOptionPane.WARNING_MESSAGE);			
		        }
				
			}
			
			
	        	
		}
	}
	
	class QRCodeGenerator implements ActionListener{
		//declare the actionperformed method
		public void actionPerformed(ActionEvent event) {

			int GeneratedRandomNumber = (int) Math.floor(Math.random() * 900000000 ) + 100000000;
			String Hex = Integer.toHexString(GeneratedRandomNumber);
			String FinalCode = fieldFirstName.getText()+"-"+Hex;
			
			
			lableCodeGeneratedTwo.setText(FinalCode);
			
	        try {
	            qrCodeData = FinalCode;
	            String filePath = "C:\\Users\\emple\\Desktop\\JAVAJARS\\ImageCodes\\"+FinalCode+".png"; 
	            String charset = "UTF-8"; // or "ISO-8859-1"
	            
	            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
	            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	            BitMatrix matrix = new MultiFormatWriter().encode(
	                new String(qrCodeData.getBytes(charset), charset),
	                BarcodeFormat.QR_CODE, 300, 300, hintMap);
	            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
	            JOptionPane.showMessageDialog(null, "QR Code image created successfully!");

	        } catch (Exception e) {
	            System.err.println(e);
	        }

	        BufferedImage bufImg;
			try {
				bufImg = ImageIO.read(new File("C:\\Users\\emple\\Desktop\\JAVAJARS\\ImageCodes\\"+FinalCode+".png"));
				QRCodeLogo.setIcon(new ImageIcon(bufImg));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
//	public static void main(String []args ) {
//		new MainPage();
//	}
}
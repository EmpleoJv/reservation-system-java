package Frames;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

class DatabasePage {

	JFrame DataFrame = new JFrame();
    JTable table = new JTable();
	JScrollPane scroll = new JScrollPane(table);
	
	
	JButton Backbutton = new JButton("< BACK");
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
	JButton Fetchbutton = new JButton("FETCH");
	JButton Deletebutton = new JButton("DELETE");
//	JButton
	
	Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\emple\\Desktop\\JAVAJARS\\ImageCodes\\LOGO.png");    

	Font FontHeaderColumn = new Font(Font.SANS_SERIF, Font.BOLD, 16);
	Font FontRow = new Font(Font.SANS_SERIF, Font.BOLD, 15);

	Font fontButton = new Font(Font.SANS_SERIF, Font.BOLD, 15);
	
	static String pickDatabase;
	
	static DefaultTableModel model = new DefaultTableModel();
	
	static Connection con;
    static Statement st;
    static ResultSet res;
    static PreparedStatement pst;
	DatabasePage(){
		
		Backbutton.setFont(fontButton);
		fieldGovtAgen.setFont(fontButton);
		Fetchbutton.setFont(fontButton);
		Deletebutton.setFont(fontButton);


		
		
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		scroll.setBounds(12,12,1700,500);
		Backbutton.setBounds(50,550,100,50);
		fieldGovtAgen.setBounds(250,550,500,50);
		Fetchbutton.setBounds(850,550,100,50);
		Deletebutton.setBounds(1050,550,100,50);

		
		DataFrame.add(Backbutton);
		DataFrame.add(fieldGovtAgen);
		DataFrame.add(Fetchbutton);
		DataFrame.add(Deletebutton);

		DataFrame.add(scroll);
		DataFrame.setSize(1750, 700);
		DataFrame.setTitle("Reservation/Appointment System Database");
		DataFrame.setLayout(null);
		DataFrame.setLocationRelativeTo(null);
		DataFrame.setIconImage(icon);    
		DataFrame.setVisible(true);
		DataFrame.setResizable(false);
		DataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Backbutton.addActionListener(new BackMainPage());
		Fetchbutton.addActionListener(new FethcingData());
		
		Deletebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
			if(table.getSelectedRow() != -1) {
				int row = table.getSelectedRow(); 
//			Delete Connection to database Start
			   try {
			       String cell = table.getModel().getValueAt(row, 0). toString();
				   String sql = "DELETE FROM "+pickDatabase+" where id = "+ cell;
			       pst = con.prepareStatement(sql);
			       row = pst.executeUpdate();

			       
			          if(row > 0) {
			           		JOptionPane.showMessageDialog(null, "Deleted successfully");
				             model.removeRow(table.getSelectedRow());
			           	}else {
			           		JOptionPane.showMessageDialog(null, "ERROR");
			           	} 	   
			        }		          
			   catch(Exception e){
				    JOptionPane.showMessageDialog(null, "Error: Something went wrong" + e, "Warning", JOptionPane.WARNING_MESSAGE);			
			   }
			   finally {
			     try {
//			           pst.close();
//			           rs.close();
			           		  
			         }
			     catch (Exception e) {
					    JOptionPane.showMessageDialog(null, "Error: Something went wrong" + e, "Warning", JOptionPane.WARNING_MESSAGE);			 
			         }     	   
			    }
//			     Delete Connection to database End to "Finally"
			}else {
				JOptionPane.showMessageDialog(null, "ERROR");
			}	           	
			}
			});
	}
	
	
	class BackMainPage implements ActionListener{
		public void actionPerformed(ActionEvent event) {

			DataFrame.dispose();
    		new MainPage();
		}
	}
	class FethcingData implements ActionListener{
		public void actionPerformed(ActionEvent event) {
//			Fetchbutton.setEnabled(false);

				model.setRowCount(0);

				if(fieldGovtAgen.getSelectedItem().equals("Overseas Workers Welfare Administration (OWWA)")) {
					pickDatabase = "owwa";
				}else if(fieldGovtAgen.getSelectedItem().equals("Philippine Health Insurance Corporation (PHILHEALTH)")) {
					pickDatabase = "philhealth";
				}else if(fieldGovtAgen.getSelectedItem().equals("Philippine Overseas Employment Administration (POEA)")) {
					pickDatabase = "poea";
				}else if(fieldGovtAgen.getSelectedItem().equals("Department of Labor and Employment (DOLE)")) {
					pickDatabase = "dole";
				}else if(fieldGovtAgen.getSelectedItem().equals("Department of Trade and Industry (DTI)")) {
					pickDatabase = "dti";
				}else if(fieldGovtAgen.getSelectedItem().equals("Bureau of Immigration (BI)")) {
					pickDatabase = "bi";			
				}else if(fieldGovtAgen.getSelectedItem().equals("Commission on Filipinos Overseas (CFO)")) {
					pickDatabase = "cfo";			
				}else if(fieldGovtAgen.getSelectedItem().equals("Bangko Sentral ng Pilipinas (BSP)")) {
					pickDatabase = "bsp";				
				}else if(fieldGovtAgen.getSelectedItem().equals("Commission of Elections (COMELEC)")) {
					pickDatabase = "comelec";				
				}else if(fieldGovtAgen.getSelectedItem().equals("Department of Tourism (DOT)")) {
					pickDatabase = "dot";				
				}else if(fieldGovtAgen.getSelectedItem().equals("Office of the President (OP)")) {
					pickDatabase = "op";					
				}else if(fieldGovtAgen.getSelectedItem().equals("Office of the Press Secretary (OPS)")) {
					pickDatabase = "ops";					
				}else if(fieldGovtAgen.getSelectedItem().equals("Overseas Absentee Voting Secretariat (OAVS)")) {
					pickDatabase = "oavs";					 
				}else if(fieldGovtAgen.getSelectedItem().equals("National Economic and Development Authority (NEDA)")) {
					pickDatabase = "neda";				
				}else if(fieldGovtAgen.getSelectedItem().equals("PAGIBIG Home Development Mutual Fund")) {
					pickDatabase = "pagibigfund";				
				}else if(fieldGovtAgen.getSelectedItem().equals("Social Security System (SSS)")) {
					pickDatabase = "sss";					
				}else if(fieldGovtAgen.getSelectedItem().equals("Philippine Institute for Development Studies (PIDS)")) {
					pickDatabase = "pids";					
				}else if(fieldGovtAgen.getSelectedItem().equals("Bureau of Customs")) {
					pickDatabase = "boc";
				}

				String[] columnNames = {"Primary ID",
			    		"QR Code ID",  
			    		"Given Name",
			    		"Surname",
			    		"Middle Name",
			    		"Age",
			    		"Mobile No.",
			    		"Address",
			    		"Brgy,Zone,District",
			    		"Email",
			    		"Valid Id",
			    		"ID Number",
			    		"Reason of Visit"};
			    

			    
			    JTableHeader header = table.getTableHeader();
			    
			    header.setFont(FontHeaderColumn);		
				table.setFont(FontRow);
				
				model.setColumnIdentifiers(columnNames);

				String id ;
				String qrcodeid ;
				String firstname ;
				String lastname ;
				String middle ;
				String age ;
				String mobile ;
				String address ;
				String barangayzonedistrict ;
				String email ;
				String anyvalidid ;
				String idnumber ;
				String reasonofvisit ;
				
				try 
				{
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation_system","root", "");
					st = con.createStatement();
					res = st.executeQuery("Select * from "+pickDatabase+"");
					DefaultTableModel model1 = (DefaultTableModel)table.getModel();
					int i = 0;
			     
					while (res.next()) {
				   
						id = res.getString("id");
						qrcodeid = res.getString("qrcodeid");
						firstname = res.getString("firstname");
						lastname = res.getString("lastname");
						middle = res.getString("middle");
						age = res.getString("age");
						mobile = res.getString("mobile");
						address = res.getString("address");
						barangayzonedistrict = res.getString("barangayzonedistrict");
						email = res.getString("email");
						anyvalidid = res.getString("anyvalidid");
						idnumber = res.getString("idnumber");
						reasonofvisit = res.getString("reasonofvisit");

		       	
			       model.addRow(new Object[]{
			    		   id,
			    		   qrcodeid, 
			    		   firstname,
			    		   lastname,
			    		   middle,
			    		   age,
			    		   mobile,
			    		   address,
			    		   barangayzonedistrict,
			    		   email,
			    		   anyvalidid,
			    		   idnumber,
			    		   reasonofvisit
			    		   
			    		   });
				    i++;
				 }	 


			} 
			catch(SQLException e) {
			    JOptionPane.showMessageDialog(null, "Error: Something went wrong" + e, "Warning", JOptionPane.WARNING_MESSAGE);			 
			}	

		}
	}
	
//	public static void main(String []arg) {
//		new DatabasePage();
//	}
	
}
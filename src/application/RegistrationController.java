package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {
	 private TextField usernamer;
	    
	    @FXML
	    private TextField emailr;
	    
	    @FXML
	    private PasswordField passwordr;
	    
	    @FXML
	    private PasswordField cpasswordr;
	    
	    @FXML
	    private Button registerbtn;
	    
	    @FXML
	    private Button registerBackbtn;
	    
	    public void register(ActionEvent event) throws ClassNotFoundException, SQLException {
			String rusername = usernamer.getText();
			String remail = emailr.getText();
			String rpassword = passwordr.getText();
			String rconfirmpassword = cpasswordr.getText();
			System.out.println( rusername + " " +remail +  " " + rpassword +  " " + rconfirmpassword);		
			if( rusername == "" || remail == "" || rpassword == "" || rconfirmpassword == "" ) {
				JOptionPane.showMessageDialog(null, "One or more fileds are empty");	
			}
			
			else if( !(rpassword.equals(rconfirmpassword))) {
				JOptionPane.showMessageDialog(null, "Password missmatch");
			}
			else {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select *from account");
				//
				int count = 0;
				int countr = 0;
				while(rs.next()) {
					if(  rusername.equals(rs.getString("id"))) {
						 count++;
						 break;
					}
				}
				if(count == 0) {
					
					JOptionPane.showMessageDialog(null, "You are not the members of the Student\nPlease contact the Administrator");
				}
				else {

					ResultSet rss = stmt.executeQuery("select *from registration");
					
						while(rss.next()) {
						if(rusername.equals(rss.getString("username"))) {
							JOptionPane.showMessageDialog(null, "A student with that username already exists.");
							countr++;	
						}
					}
					
						if(countr == 0) {
							
							stmt.executeUpdate("INSERT INTO `registration` (`username`, `email`, `password`) VALUES ('''+rusername+''', '''+remail+''', '''+rpassword+''')");
							JOptionPane.showMessageDialog(null, "UPDATED");
						}
						
					
				}
					
				}	
				
			}
			public void backToLogin(ActionEvent e) {
				
			}

}

package application;
 import java.io.IOException;

import java.sql.*;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller {
	
	    @FXML
	    private Button backbtn;

	    @FXML
	    private Button loginbtn;

	    @FXML
	    private PasswordField passtxt;

	    @FXML
	    private TextField usertxt;
	    
	    @FXML
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
	    
	    @FXML
	    private Hyperlink gtregister;
	    
	    
	    
	
	
	public void login(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
		
		String username = usertxt.getText();
		String password = passtxt.getText();
		String truepass;
		String truename;
		
		if(username == "" || password == "") {
			JOptionPane.showMessageDialog(null, "One or more fieds are empty");
		}
		else {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from registration");
			int count = 0;
			
			while(rs.next()) {
				 truename = rs.getString("username");
				truepass = rs.getString("password");
				 if( username.equals(truename) && password.equals(truepass)) {
					 JOptionPane.showMessageDialog(null, "Successfull login"); 
					 count++;
					 break;
					 
				 }

			}
			if(count == 0) {
				JOptionPane.showMessageDialog(null, "Incorrect password or username"); 
			}
			
		}

	}
	public void cancel(ActionEvent event) throws IOException {
		Stage stage = (Stage) backbtn.getScene().getWindow();
		stage.close();
		
	}
	public void gotoregister(ActionEvent event) throws IOException {
		//loginpage.getScene().getWindow().hide();
				Stage stage = (Stage) gtregister.getScene().getWindow();
				stage.close();
				Stage registerpage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("RegistrationScene.fxml"));
				registerpage.setScene(new Scene(root, 680, 500));
				
				registerpage.show();
		
	}
	Use your id as a a username
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
	



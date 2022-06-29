package application;
 import java.io.IOException;
import java.sql.*;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

public class Controller {
	
	  @FXML
	    private Button backbtn;

	    @FXML
	    private Button loginbtn;

	    @FXML
	    private PasswordField passtxt;

	    @FXML
	    private TextField usertxt;
	
	
	public void login(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
		String username = usertxt.getText();
		String password = passtxt.getText();
		
		if(username == "" && password == "") {
			JOptionPane.showMessageDialog(null, "One or more fieds are empty");
		}
		else {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/3307/student", "root", "");
			Statement stmt = con.prepareStatement(password);
			stmt.executeQuery("select *from registration");
			

		}
	}
	public void cancel(ActionEvent event) throws IOException {
	}
	

}

package lab_fx;
	

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.sql.*;
import static java.lang.Class.forName;
public class Main extends Application {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		launch(args);
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student", "root", "");
		//Statement stmt = con.createStatement();
		//stmt.executeUpdate("insert into account values ('BDU1201873', 'Habtamu', 'Fentahun', 'Male', 'Software Engineering', 2012)");
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Stage loginpage = new Stage();
			loginpage.show();
			loginpage.setTitle("Student Managment System");
			loginpage.getIcons().add(new Image("images/BDU.jpg"));
			loginpage.setResizable(false);
			Group root = new Group();
			Scene scene = new Scene(root, 490, 350, Color.ORANGE);
			loginpage.setScene(scene);
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}

/*
//Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
Group root = new Group();
Stage stage = new Stage();
stage.setTitle("Login Form");
stage.setResizable(false);

Scene scene = new Scene(root, 300, 120, Color.ORANGE);



GridPane form = new GridPane();
form.setPadding(new Insets(11, 12, 13, 14));
form.setHgap(0.5);
//form.setVgap(0.5);

Line line = new Line();
line.setEndX(55);
line.setEndY(1);

Line line2 = new Line();
line2.setEndX(55);
line2.setEndY(1);

form.add(new Label("Username: "), 0,0);
form.add(new TextField(), 10, 0);
form.add(line, 0, 30);
form.add(new Label("Password: "), 0, 40);
form.add(new PasswordField(), 10, 40);
form.add(line2, 0, 90);
form.add(new Button("Login"), 10, 100);

root.getChildren().add(form);
stage.setScene(scene);
stage.show();
*/
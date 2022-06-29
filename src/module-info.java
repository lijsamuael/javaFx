module JavaFx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}

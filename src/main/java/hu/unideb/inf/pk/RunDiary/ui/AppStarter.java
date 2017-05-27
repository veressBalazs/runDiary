package hu.unideb.inf.pk.RunDiary.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStarter extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/run.fxml"));
		   Scene scene = new Scene(root);
	        
	        stage.setScene(scene);
	        stage.show();
		
	}

}
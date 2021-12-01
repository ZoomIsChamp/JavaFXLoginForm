package cs3318.assignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Assignment3Application extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Registration Form");
        FXMLLoader registerFXML = new FXMLLoader(User.class.getResource("Assignment3.fxml"));
        Scene scene = new Scene(registerFXML.load(), 300, 275);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

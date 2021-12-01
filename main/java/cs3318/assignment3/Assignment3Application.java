package cs3318.assignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Assignment3Application extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Registration Form");
        FXMLLoader registerFXML = new FXMLLoader(Assignment3.class.getResource("Assignment3.fxml"));
        Scene scene = new Scene(registerFXML.load(), 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public boolean checkEmail(String testEmail) {
        final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_REGEX.matcher(testEmail);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid Email Address");
        }
        return true;
    }

    public boolean checkPasswordLength(String testPassword) {
        return testPassword.length() >= 7;
    }

    public boolean passwordContainsSpecial(String testPassword) {
        final Pattern PASSWORD_CONTAINS = Pattern.compile("[*^&@!]+");
        Matcher matcher = PASSWORD_CONTAINS.matcher(testPassword);
        return matcher.find();
    }
}

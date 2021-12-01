package cs3318.assignment3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Assignment3Controller {
    @FXML public TextField emailField;
    @FXML public PasswordField passwordField;
    @FXML public Button registerButton;
    @FXML public Label responseLabel;


    public void register(ActionEvent actionEvent) {
        String password = passwordField.getText();
        String email = emailField.getText();
        User tester = new User(email, password);
        if (tester.checkEmail(email) && tester.isValidPassword(password)) {
            responseLabel.setText("Valid user created");
        } else if (tester.checkEmail(email) && !tester.isValidPassword(password)) {
            responseLabel.setText("Invalid password");
        } else if (!tester.checkEmail(email) && tester.isValidPassword(password)) {
            responseLabel.setText("Invalid email");
        } else {
            responseLabel.setText("Invalid email and password");
        }
    }
}

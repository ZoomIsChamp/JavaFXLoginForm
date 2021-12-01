package cs3318.assignment3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Assignment3Controller {
    public TextField emailField;
    public PasswordField passwordField;
    public Button registerButton;
    public Label responseLabel;


    public void register(ActionEvent actionEvent) {
        Assignment3 form = new Assignment3();
    }
}
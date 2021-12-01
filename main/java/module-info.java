module cs3318.assignment3.assignment3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens cs3318.assignment3 to javafx.fxml;
    exports cs3318.assignment3;
}
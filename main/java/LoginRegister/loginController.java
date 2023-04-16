package LoginRegister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        Crypto crypto = Crypto.getInstance();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String hashedPassword = crypto.md5Sum(password);
        System.out.println(hashedPassword);
        // check if the username and password are correct
        User user = Login.loginFromGUI(username, hashedPassword);
        Alert alertlogin = new Alert(Alert.AlertType.INFORMATION);

        alertlogin.setTitle(user.getUsername());
        alertlogin.setContentText(user.toString());
        alertlogin.show();
//        if (username.equals("myusername") && password.equals("mypassword")) {
//            // successful login, show a message
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Login Successful");
//            alert.setContentText("Welcome " + username);
//            alert.showAndWait();
//        } else {
//            // invalid username or password, show an error message
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Login Error");
//            alert.setContentText("Invalid username or password");
//            alert.showAndWait();
//        }
    }
}
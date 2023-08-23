package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passWordInput;

    @FXML
    private Button singUpButton;

    @FXML
    private TextField userNameInput;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginButton.setOnAction(event -> {
            System.out.println("cliked");
        });
    }

}

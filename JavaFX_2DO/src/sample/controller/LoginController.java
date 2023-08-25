package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;

public class LoginController implements Initializable{


    @FXML
    private AnchorPane anchorpane2;

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
        
        String loginText = userNameInput.getText().trim();
        String loginPwd = passWordInput.getText().trim();        
        
        anchorpane2.setOnMouseClicked(event -> {
            userNameInput.getParent().requestFocus();
            passWordInput.getParent().requestFocus();
        });
        
        loginButton.setOnAction(event -> {
            if(!loginText.equals("") || !loginPwd.equals("")){
                loginUser(loginText,loginPwd);
            }else{
                System.out.println("Erro de login");
            }
        });

        singUpButton.setOnAction(event ->{
            //leva os usuarios a tela Signup;
            singUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/Signup.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.showAndWait();
        });

        userNameInput.setOnMouseClicked(event ->{
        });
        passWordInput.setOnMouseClicked(event ->{
        });
    }


    private void loginUser(String userName, String password) {
        //checar no banco de dados se o usuario existe
    }

}

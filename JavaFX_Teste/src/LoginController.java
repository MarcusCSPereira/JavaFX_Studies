import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField campoUsuário;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Button buttonEntrar;

    @FXML
    void entrada(ActionEvent event) {
        String usuario = campoUsuário.getText();
        String senha = campoSenha.getText();

        if(usuario.equals("Cesinha") && senha.equals("admin")){
            JOptionPane.showMessageDialog(null, "Seja bem vindo " + usuario, "Login Sucess", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Usuário ou Senha Incorretos", "Login Fail", JOptionPane.WARNING_MESSAGE);
        }
    }

}

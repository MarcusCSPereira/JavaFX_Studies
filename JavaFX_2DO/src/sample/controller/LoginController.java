package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Database.DatabaseHandler;
import sample.model.User;
import javafx.scene.Parent;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane anchorpanePrin;

    @FXML
    private Button buttonFechar;

    @FXML
    private Label erroLogin;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passWordInput;

    @FXML
    private Button singUpButton;

    @FXML
    private TextField userNameInput;

    private DatabaseHandler databaseHandler = new DatabaseHandler();

    private Boolean permissao = false;
    private String PassNomeUsuario;
    private String PassNomeCompleto;
    private String PassSenha;
    private String PassLocal;
    private String PassGenero;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        databaseHandler = new DatabaseHandler();

        anchorpanePrin.setOnMouseClicked(event -> {
            userNameInput.getParent().requestFocus();
            passWordInput.getParent().requestFocus();
        });

        buttonFechar.setOnAction(event -> {
            System.exit(0);
        });

        loginButton.setOnAction(event -> {

            if (userNameInput.getText().isEmpty() && passWordInput.getText().isEmpty()) {
                permissao = false;
                erroLogin.setText("Os campos de Usuário e Senha devem ser preenchidos!");
            } else if (userNameInput.getText().isEmpty() && !passWordInput.getText().equals("")) {
                permissao = false;
                erroLogin.setText("O campo de Usuário deve ser preenchido!");
            } else if (!userNameInput.getText().equals("") && passWordInput.getText().isEmpty()) {
                permissao = false;
                erroLogin.setText("O campo de Senha deve ser preenchido!");
            } else {
                permissao = true;
            }

            if (permissao) {

                String loginText = userNameInput.getText().trim();
                String loginPwd = passWordInput.getText().trim();

                User usuario = new User();
                usuario.setNomeDeUsuario(loginText);
                usuario.setSenha(loginPwd);

                ResultSet userRow = databaseHandler.checarSeUsuarioExiste(usuario);

                int contador = 0;

                try {
                    while (userRow.next()) {
                        contador++;
                        // usando os metodos setPass, para setar e futuramente passar esses dados para a classe AddTasks
                        setPassNomeCompleto(userRow.getString("firstname") + " " + userRow.getString("lastname"));// tem que ser o mesmo nome da coluna no BD
                        setPassNomeUsuario(userRow.getString("username"));
                        setPassSenha(userRow.getString("password"));
                        setPassLocal(userRow.getString("location"));
                        setPassGenero(userRow.getString("gender"));
                    }

                    // quando o contador retorna 0, ele n encontra o usuario, se retorna 1, encontra o usuario;

                    if (contador == 1) {
                        // entrar na nova cena
                        loginButton.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/view/TaskList.fxml"));

                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Parent root = loader.getRoot();

                        // necessário para passar os dados ao outro controlador essa linha é referente a linha 83 do TaskList;
                        TaskListController addTasksController = loader.getController();
                        addTasksController.setLoginController(this);

                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.showAndWait();
                    } else {
                        erroLogin.setText("As credenciais não estão corretas ou o Usuário não está cadastrado!");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        singUpButton.setOnAction(event -> {
            // leva os usuarios a tela Signup;
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

        userNameInput.setOnMouseClicked(event -> {
        });
        passWordInput.setOnMouseClicked(event -> {
        });
    }

    // metodos get e set para passar os dados:
    public String getPassNomeUsuario() {
        return this.PassNomeUsuario;
    }

    public String getPassNomeCompleto() {
        return this.PassNomeCompleto;
    }

    public String getPassSenha() {
        return this.PassSenha;
    }

    public String getPassLocal() {
        return this.PassLocal;
    }

    public String getPassGenero() {
        return this.PassGenero;
    }

    public void setPassNomeUsuario(String PassNomeUsuario) {
        this.PassNomeUsuario = PassNomeUsuario;
    }

    public void setPassNomeCompleto(String PassNomeCompleto) {
        this.PassNomeCompleto = PassNomeCompleto;
    }

    public void setPassSenha(String PassSenha) {
        this.PassSenha = PassSenha;
    }

    public void setPassLocal(String PassLocal) {
        this.PassLocal = PassLocal;
    }

    public void setPassGenero(String PassGenero) {
        this.PassGenero = PassGenero;
    }
}

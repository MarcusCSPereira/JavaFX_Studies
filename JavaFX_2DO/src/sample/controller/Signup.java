package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Database.DatabaseHandler;

public class Signup implements Initializable{

    @FXML
    private AnchorPane anchorPrinS;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField CadastroConfirmSenha;

    @FXML
    private CheckBox MulherCheckBox;

    @FXML
    private Button buttonCriarConta;

    @FXML
    private TextField cadastroNomeUsuario;

    @FXML
    private PasswordField cadastroSenha;

    @FXML
    private CheckBox homemCheckBox;

    @FXML
    private Hyperlink hyperlinkVoltarLogin;

    @FXML
    private Label confirmLabel;

    @FXML
    private TextField inLocal;

    @FXML
    private TextField inPrimeiroNome;

    @FXML
    private TextField inSobrenome;

    @FXML
    private Label errorLabel;

    @FXML
    private ProgressBar progressBar;

    //variaveis
    private double porcentagem = 0.0;//porcentagem da progressbar
    private String generoSelecionado ="";//genero selecionado
    private Boolean permissaoCadastro=false;

    //metodos
    public void checarCampos() {
        porcentagem = 0.0; 
        int camposPreenchidos = 0;
    
        if (!cadastroSenha.getText().trim().isEmpty()) camposPreenchidos++;
        if (!CadastroConfirmSenha.getText().trim().isEmpty()) camposPreenchidos++;
        if (!cadastroNomeUsuario.getText().trim().isEmpty()) camposPreenchidos++;
        if (!inLocal.getText().trim().isEmpty()) camposPreenchidos++;
        if (!inPrimeiroNome.getText().trim().isEmpty()) camposPreenchidos++;
        if (!inSobrenome.getText().trim().isEmpty()) camposPreenchidos++;
    
        // Verificar o estado dos checkboxes
        if (MulherCheckBox.isSelected() || homemCheckBox.isSelected()) {
            camposPreenchidos++;
        }
    
        porcentagem = (double) camposPreenchidos / 7.0; //7 campos
        progressBar.setProgress(porcentagem);
    }
    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        //Controle da ProgressBar
        anchorPrinS.setOnMouseClicked(event -> {
            anchorPrinS.requestFocus();
            checarCampos();
        });

        cadastroNomeUsuario.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                checarCampos();
            }
        });
        cadastroSenha.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { 
                checarCampos();
            }
        });
        inLocal.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                checarCampos();
            }
        });
        inPrimeiroNome.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                checarCampos();
            }
        });
        inSobrenome.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { 
                checarCampos();
            }
        });

        //ações do checkbox:
        homemCheckBox.setOnAction(event -> {
            if (homemCheckBox.isSelected()) {
                MulherCheckBox.setSelected(false);
                generoSelecionado = "Homem";
            } else {
                generoSelecionado = "";
            }
            checarCampos();
        });
        
        MulherCheckBox.setOnAction(event -> {
            if (MulherCheckBox.isSelected()) {
                homemCheckBox.setSelected(false);
                generoSelecionado = "Mulher";
            } else {
                generoSelecionado = "";
            }
            checarCampos();
        });
        
        //ação do botão
        buttonCriarConta.setOnAction(event->{
            
            DatabaseHandler databaseHandler = new DatabaseHandler();

            errorLabel.setText("");

            if (inSobrenome.getText().trim().isEmpty() || inPrimeiroNome.getText().trim().isEmpty() ||
                inLocal.getText().trim().isEmpty() || cadastroSenha.getText().trim().isEmpty() ||
                cadastroNomeUsuario.getText().trim().isEmpty() || CadastroConfirmSenha.getText().trim().isEmpty()) {
                errorLabel.setText("Preencha todos os campos");
                this.permissaoCadastro = false;

            } else if (generoSelecionado.isEmpty()) {
                errorLabel.setText("Escolha um gênero!");
                this.permissaoCadastro = false;
            } else if (!cadastroSenha.getText().equals(CadastroConfirmSenha.getText())) {
                errorLabel.setText("As senhas não são iguais!");
                this.permissaoCadastro = false;
            }else{
                this.permissaoCadastro=true;
            }

            if(this.permissaoCadastro){
                databaseHandler.signUpUser(inPrimeiroNome.getText(),inSobrenome.getText(), cadastroNomeUsuario.getText(), cadastroSenha.getText(), inLocal.getText(), generoSelecionado);
                confirmLabel.setText("Cadastro realizado com Sucesso!");
            }

        });

        hyperlinkVoltarLogin.setOnAction(event ->{
            //volta pra tela de login;
            hyperlinkVoltarLogin.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/login.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();//para voltar eu uso o show e não o show and wait;
        });
        
    }

}

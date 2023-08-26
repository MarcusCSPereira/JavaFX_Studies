package sample.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TaskListController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addTaskItem;

    @FXML
    private Label fieldTarefas;

    @FXML
    private Label labelTarefas;

    @FXML
    private AnchorPane anchorpanePrincipal;

    @FXML
    private ImageView avatarImage1;

    @FXML
    private Button bttInfo;

    @FXML
    private Button bttTarefas;

    @FXML
    private Button buttonSair;

    @FXML
    private Label fieldGenero;

    @FXML
    private Label fieldLocal;

    @FXML
    private Label fieldNomeCompleto;

    @FXML
    private Label fieldNomeUsuario;

    @FXML
    private Label fieldSenha;

    @FXML
    private Label labelGenero;

    @FXML
    private Label labelLocal;

    @FXML
    private Label labelNomeCompleto;

    @FXML
    private ImageView imageNoViewSenha;

    @FXML
    private ImageView imageViewSenha;

    @FXML
    private Label labelNomeUsuario;

    @FXML
    private ImageView deleteTaskItem;

    @FXML
    private Label labelSenha;

    //instanciando o objeto que está vindo da classe login com os dados do usuário que fez o login, necessário ser static e fazer dessa forma,para que quando eu vá para uma outra aba e volte pra essa, a função de receber os valores ainda funcione;
    static private LoginController loginController;
    public void setLoginController(LoginController loginController) {
        TaskListController.loginController = loginController;
    }


    @FXML
    void initialize() {

        avatarImage1.setOnMouseClicked(event -> {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        Stage stage = (Stage) avatarImage1.getScene().getWindow();
        // Abre a janela de diálogo e obtém o arquivo selecionado
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            // Carrega a imagem selecionada e define na ImageView
            Image selectedImage = new Image(selectedFile.toURI().toString());
            avatarImage1.setImage(selectedImage);
        }
    });

        bttInfo.setOnAction(event ->{
            trocaTelaInfo();
        });

        bttTarefas.setOnAction(event ->{
            trocaTelaTask();
        });

        //botão que leva a cena de adicionar tasks:
        addTaskItem.setOnMouseClicked(event ->{
            addTaskItem.getScene().getWindow().hide();;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/view/AddTask.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

        });;

        buttonSair.setOnAction(event ->{
            buttonSair.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/view/Login.fxml"));
            
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();//pois estou voltando para tela de login

        });

        imageViewSenha.setOnMouseClicked(event ->{
            imageViewSenha.setDisable(true);
            imageViewSenha.setVisible(false);
            imageNoViewSenha.setDisable(false);
            imageNoViewSenha.setVisible(true);
            fieldSenha.setText(loginController.getPassSenha());
        });

        imageNoViewSenha.setOnMouseClicked(event ->{
            imageNoViewSenha.setDisable(true);
            imageNoViewSenha.setVisible(false);
            imageViewSenha.setDisable(false);
            imageViewSenha.setVisible(true);
            fieldSenha.setText("\u2731\u2731\u2731\u2731\u2731\u2731\u2731");
        });

    }

    public void trocaTelaTask(){
        bttTarefas.setStyle("-fx-background-color: #F9F8F1; -fx-background-radius: 30px 0 0 30px; -fx-text-fill: #000; -fx-font-weight: bolder;");
        bttInfo.setStyle("-fx-background-color: #a96da3; -fx-background-radius: 30px 0 0 30px; -fx-text-fill: #000; -fx-font-weight: bolder;");
        addTaskItem.setVisible(true);
        addTaskItem.setDisable(false);
        deleteTaskItem.setVisible(true);
        deleteTaskItem.setDisable(false);
        labelTarefas.setVisible(false);
        fieldTarefas.setVisible(false);
        labelNomeCompleto.setVisible(false);
        fieldNomeCompleto.setVisible(false);
        labelNomeUsuario.setVisible(false);
        fieldNomeUsuario.setVisible(false);
        labelSenha.setVisible(false);
        fieldSenha.setVisible(false);
        labelLocal.setVisible(false);
        fieldLocal.setVisible(false);
        labelGenero.setVisible(false);
        fieldGenero.setVisible(false);
        imageViewSenha.setDisable(true);
        imageViewSenha.setVisible(false);        
        imageNoViewSenha.setDisable(true);
        imageNoViewSenha.setVisible(false);

    }

    public void trocaTelaInfo(){

            preencherCamposComDados();
            bttInfo.setStyle("-fx-background-color: #F9F8F1; -fx-background-radius: 30px 0 0 30px; -fx-text-fill: #000; -fx-font-weight: bolder;");
            bttTarefas.setStyle("-fx-background-color: #a96da3; -fx-background-radius: 30px 0 0 30px; -fx-text-fill: #000; -fx-font-weight: bolder;");
            addTaskItem.setVisible(false);
            addTaskItem.setDisable(true);
            deleteTaskItem.setVisible(false);
            deleteTaskItem.setDisable(true);
            labelTarefas.setVisible(true);
            fieldTarefas.setVisible(true);
            labelNomeCompleto.setVisible(true);
            fieldNomeCompleto.setVisible(true);
            labelNomeUsuario.setVisible(true);
            fieldNomeUsuario.setVisible(true);
            labelSenha.setVisible(true);
            fieldSenha.setVisible(true);
            labelLocal.setVisible(true);
            fieldLocal.setVisible(true);
            labelGenero.setVisible(true);
            fieldGenero.setVisible(true);
            imageViewSenha.setDisable(false);
            imageViewSenha.setVisible(true);
    }

    public void preencherCamposComDados() {
        //usando o objeto com os dados e os métodos obtidos da classe LoginController
        fieldNomeCompleto.setText(loginController.getPassNomeCompleto());
        fieldNomeUsuario.setText(loginController.getPassNomeUsuario());
        fieldSenha.setText("\u2731\u2731\u2731\u2731\u2731\u2731\u2731");
        fieldLocal.setText(loginController.getPassLocal());
        fieldGenero.setText(loginController.getPassGenero());
        fieldTarefas.setText("0" + " Tarefas");
    }

}


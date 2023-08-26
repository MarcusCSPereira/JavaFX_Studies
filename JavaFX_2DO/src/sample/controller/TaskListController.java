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
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TaskListController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addTaskItem;

    @FXML
    private AnchorPane anchorpanePrincipal;

    @FXML
    private AnchorPane apTask0;

    @FXML
    private AnchorPane apTask01;

    @FXML
    private AnchorPane apTask02;

    @FXML
    private AnchorPane apTask03;

    @FXML
    private AnchorPane apTask04;

    @FXML
    private AnchorPane apTask05;

    @FXML
    private AnchorPane apTask06;

    @FXML
    private AnchorPane apTask07;

    @FXML
    private AnchorPane apTask08;

    @FXML
    private AnchorPane apTask09;

    @FXML
    private ImageView avatarImage1;

    @FXML
    private ImageView bttDeleteTarefa0;

    @FXML
    private ImageView bttDeleteTarefa01;

    @FXML
    private ImageView bttDeleteTarefa02;

    @FXML
    private ImageView bttDeleteTarefa03;

    @FXML
    private ImageView bttDeleteTarefa04;

    @FXML
    private ImageView bttDeleteTarefa05;

    @FXML
    private ImageView bttDeleteTarefa06;

    @FXML
    private ImageView bttDeleteTarefa07;

    @FXML
    private ImageView bttDeleteTarefa08;

    @FXML
    private ImageView bttDeleteTarefa09;

    @FXML
    private ImageView bttEditTarefa0;

    @FXML
    private ImageView bttEditTarefa01;

    @FXML
    private ImageView bttEditTarefa02;

    @FXML
    private ImageView bttEditTarefa03;

    @FXML
    private ImageView bttEditTarefa04;

    @FXML
    private ImageView bttEditTarefa05;

    @FXML
    private ImageView bttEditTarefa06;

    @FXML
    private ImageView bttEditTarefa07;

    @FXML
    private ImageView bttEditTarefa08;

    @FXML
    private ImageView bttEditTarefa09;

    @FXML
    private ImageView bttInTarefa0;

    @FXML
    private ImageView bttInTarefa01;

    @FXML
    private ImageView bttInTarefa02;

    @FXML
    private ImageView bttInTarefa03;

    @FXML
    private ImageView bttInTarefa04;

    @FXML
    private ImageView bttInTarefa05;

    @FXML
    private ImageView bttInTarefa06;

    @FXML
    private ImageView bttInTarefa07;

    @FXML
    private ImageView bttInTarefa08;

    @FXML
    private ImageView bttInTarefa09;

    @FXML
    private Button bttInfo;

    @FXML
    private Button bttTarefas;

    @FXML
    private Button buttonSair;

    @FXML
    private Label dataTarefa0;

    @FXML
    private Label dataTarefa01;

    @FXML
    private Label dataTarefa02;

    @FXML
    private Label dataTarefa03;

    @FXML
    private Label dataTarefa04;

    @FXML
    private Label dataTarefa05;

    @FXML
    private Label dataTarefa06;

    @FXML
    private Label dataTarefa07;

    @FXML
    private Label dataTarefa08;

    @FXML
    private Label dataTarefa09;

    @FXML
    private Label fieldGenero;

    @FXML
    private Label fieldLocal;
    
    @FXML
    private ImageView background;

    @FXML
    private ImageView background1;

    @FXML
    private Label labelSemTask;

    @FXML
    private Label fieldNomeCompleto;

    @FXML
    private Label fieldNomeUsuario;

    @FXML
    private Label fieldSenha;

    @FXML
    private Label fieldTarefas;

    @FXML
    private ImageView imageNoViewSenha;

    @FXML
    private ImageView imageViewSenha;

    @FXML
    private Label labelGenero;

    @FXML
    private Label labelLocal;

    @FXML
    private Label labelNomeCompleto;

    @FXML
    private Label labelNomeUsuario;

    @FXML
    private Label labelSenha;

    @FXML
    private Label labelTarefas;

    @FXML
    private Label nomeTarefa0;

    @FXML
    private Label nomeTarefa01;

    @FXML
    private Label nomeTarefa02;

    @FXML
    private Label nomeTarefa03;

    @FXML
    private Label nomeTarefa04;

    @FXML
    private Label nomeTarefa05;

    @FXML
    private Label nomeTarefa06;

    @FXML
    private Label nomeTarefa07;

    @FXML
    private Label nomeTarefa08;

    @FXML
    private Label nomeTarefa09;

    @FXML
    private ScrollPane telaTasks;

    @FXML
    private Label labelNewTask;



    //instanciando o objeto que está vindo da classe login com os dados do usuário que fez o login, necessário ser static e fazer dessa forma,para que quando eu vá para uma outra aba e volte pra essa, a função de receber os valores ainda funcione;
    static private LoginController loginController;
    public void setLoginController(LoginController loginController) {
        TaskListController.loginController = loginController;
    }
    //instanciando o objeto que está vindo da classe AddTask com os dados do usuário que fez o login, necessário ser static e fazer dessa forma,para que quando eu vá para uma outra aba e volte pra essa, a função de receber os valores ainda funcione;
    static private AddTaskController addTaskController;
    public void setAddTaskContrroler(AddTaskController addTaskController){
        TaskListController.addTaskController = addTaskController;
    }


    static int controle=-1;
    static int controle2=0;
    static int controle3=0;

    @FXML
    void initialize() {
        
        if(controle2!=0){
            labelNewTask.setVisible(true);
        }

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
            if(controle2!=0){
                preencherPanesComDados();
                labelNewTask.setVisible(false);
                controle2--;
            }
            if(controle3!=0){
                labelSemTask.setVisible(false);
            }else{
                labelSemTask.setVisible(true);
            }
        });

        //botão que leva a cena de adicionar tasks:
        if(controle<10){
            addTaskItem.setOnMouseClicked(event ->{
                controle++;
                controle2--;
                controle3++;
                addTaskItem.getScene().getWindow().hide();
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
        }

        //sair
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
        //senha
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
        bttInfo.setStyle("-fx-background-color: #a96da3; -fx-background-radius: 30px 0 0 30px; -fx-text-fill: #fff; -fx-font-weight: bolder;");
        labelNewTask.setVisible(false);
        background.setDisable(true);
        background.setVisible(false);
        telaTasks.setDisable(false);
        telaTasks.setVisible(true);
        addTaskItem.setVisible(true);
        addTaskItem.setDisable(false);
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
            bttTarefas.setStyle("-fx-background-color: #a96da3; -fx-background-radius: 30px 0 0 30px; -fx-text-fill: #fff; -fx-font-weight: bolder;");
            labelSemTask.setVisible(false);
            background.setDisable(true);
            background.setVisible(false);
            telaTasks.setDisable(true);
            telaTasks.setVisible(false);
            addTaskItem.setVisible(false);
            addTaskItem.setDisable(true);
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
        fieldTarefas.setText(controle+1 + " Tarefas");
    }

    public void preencherPanesComDados(){
        if(controle>-1){
            if(addTaskController.getNomeTarefa(0)==""){
                controle--;
            }else{
                apTask0.setDisable(false);
                apTask0.setVisible(true);
                nomeTarefa0.setText(addTaskController.getNomeTarefa(0));
                nomeTarefa0.setVisible(true);
                dataTarefa0.setText(addTaskController.getDataTarefa(0));
                dataTarefa0.setVisible(true);
                bttDeleteTarefa0.setDisable(false);
                bttDeleteTarefa0.setVisible(true);
                bttEditTarefa0.setDisable(false);
                bttEditTarefa0.setVisible(true);
                bttInTarefa0.setDisable(false);
                bttInTarefa0.setVisible(true);
            }
        }
        if(controle>0){
            if(addTaskController.getNomeTarefa(1)==null){
                controle--;
            }else{
                apTask01.setDisable(false);
                apTask01.setVisible(true);
                nomeTarefa01.setText(addTaskController.getNomeTarefa(1));
                nomeTarefa01.setVisible(true);
                dataTarefa01.setText(addTaskController.getDataTarefa(1));
                dataTarefa01.setVisible(true);
                bttDeleteTarefa01.setDisable(false);
                bttDeleteTarefa01.setVisible(true);
                bttEditTarefa01.setDisable(false);
                bttEditTarefa01.setVisible(true);
                bttInTarefa01.setDisable(false);
                bttInTarefa01.setVisible(true);
            }
        }
        if(controle>1){
            if(addTaskController.getNomeTarefa(2)==null){
                controle--;
            }else{
                apTask02.setDisable(false);
                apTask02.setVisible(true);
                nomeTarefa02.setText(addTaskController.getNomeTarefa(2));
                nomeTarefa02.setVisible(true);
                dataTarefa02.setText(addTaskController.getDataTarefa(2));
                dataTarefa02.setVisible(true);
                bttDeleteTarefa02.setDisable(false);
                bttDeleteTarefa02.setVisible(true);
                bttEditTarefa02.setDisable(false);
                bttEditTarefa02.setVisible(true);
                bttInTarefa02.setDisable(false);
                bttInTarefa02.setVisible(true);
            }
        }
        if(controle>2){
            if(addTaskController.getNomeTarefa(3)==""){
                controle--;
            }else{
                apTask03.setDisable(false);
                apTask03.setVisible(true);
                nomeTarefa03.setText(addTaskController.getNomeTarefa(3));
                nomeTarefa03.setVisible(true);
                dataTarefa03.setText(addTaskController.getDataTarefa(3));
                dataTarefa03.setVisible(true);
                bttDeleteTarefa03.setDisable(false);
                bttDeleteTarefa03.setVisible(true);
                bttEditTarefa03.setDisable(false);
                bttEditTarefa03.setVisible(true);
                bttInTarefa03.setDisable(false);
                bttInTarefa03.setVisible(true);
            }
        }
        if(controle>3){
            if(addTaskController.getNomeTarefa(4)==""){
                controle--;
            }else{
                apTask04.setDisable(false);
                apTask04.setVisible(true);
                nomeTarefa04.setText(addTaskController.getNomeTarefa(0));
                nomeTarefa04.setVisible(true);
                dataTarefa04.setText(addTaskController.getDataTarefa(0));
                dataTarefa04.setVisible(true);
                bttDeleteTarefa04.setDisable(false);
                bttDeleteTarefa04.setVisible(true);
                bttEditTarefa04.setDisable(false);
                bttEditTarefa04.setVisible(true);
                bttInTarefa04.setDisable(false);
                bttInTarefa04.setVisible(true);
            }
        }
        if(controle>4){
            if(addTaskController.getNomeTarefa(5)==""){
                controle--;
            }else{
                apTask05.setDisable(false);
                apTask05.setVisible(true);
                nomeTarefa05.setText(addTaskController.getNomeTarefa(5));
                nomeTarefa05.setVisible(true);
                dataTarefa05.setText(addTaskController.getDataTarefa(5));
                dataTarefa05.setVisible(true);
                bttDeleteTarefa05.setDisable(false);
                bttDeleteTarefa05.setVisible(true);
                bttEditTarefa05.setDisable(false);
                bttEditTarefa05.setVisible(true);
                bttInTarefa05.setDisable(false);
                bttInTarefa05.setVisible(true);
            }
        }
        if(controle>5){
            if(addTaskController.getNomeTarefa(6)==""){
                controle--;
            }else{
                apTask06.setDisable(false);
                apTask06.setVisible(true);
                nomeTarefa06.setText(addTaskController.getNomeTarefa(6));
                nomeTarefa06.setVisible(true);
                dataTarefa06.setText(addTaskController.getDataTarefa(6));
                dataTarefa06.setVisible(true);
                bttDeleteTarefa06.setDisable(false);
                bttDeleteTarefa06.setVisible(true);
                bttEditTarefa06.setDisable(false);
                bttEditTarefa06.setVisible(true);
                bttInTarefa06.setDisable(false);
                bttInTarefa06.setVisible(true);
            }
        }
        if(controle>6){
            if(addTaskController.getNomeTarefa(7)==""){
                controle--;
            }else{
                apTask07.setDisable(false);
                apTask07.setVisible(true);
                nomeTarefa07.setText(addTaskController.getNomeTarefa(7));
                nomeTarefa07.setVisible(true);
                dataTarefa07.setText(addTaskController.getDataTarefa(7));
                dataTarefa07.setVisible(true);
                bttDeleteTarefa07.setDisable(false);
                bttDeleteTarefa07.setVisible(true);
                bttEditTarefa07.setDisable(false);
                bttEditTarefa07.setVisible(true);
                bttInTarefa07.setDisable(false);
                bttInTarefa07.setVisible(true);
            }
        }
        if(controle>7){
            if(addTaskController.getNomeTarefa(8)==""){
                controle--;
            }else{
                apTask08.setDisable(false);
                apTask08.setVisible(true);
                nomeTarefa08.setText(addTaskController.getNomeTarefa(8));
                nomeTarefa08.setVisible(true);
                dataTarefa08.setText(addTaskController.getDataTarefa(8));
                dataTarefa08.setVisible(true);
                bttDeleteTarefa08.setDisable(false);
                bttDeleteTarefa08.setVisible(true);
                bttEditTarefa08.setDisable(false);
                bttEditTarefa08.setVisible(true);
                bttInTarefa08.setDisable(false);
                bttInTarefa08.setVisible(true);
            }
        }
        if(controle>8){
            if(addTaskController.getNomeTarefa(9)==""){
                controle--;
            }else{
                apTask09.setDisable(false);
                apTask09.setVisible(true);
                nomeTarefa09.setText(addTaskController.getNomeTarefa(9));
                nomeTarefa09.setVisible(true);
                dataTarefa09.setText(addTaskController.getDataTarefa(9));
                dataTarefa09.setVisible(true);
                bttDeleteTarefa09.setDisable(false);
                bttDeleteTarefa09.setVisible(true);
                bttEditTarefa09.setDisable(false);
                bttEditTarefa09.setVisible(true);
                bttInTarefa09.setDisable(false);
                bttInTarefa09.setVisible(true);
            }
        }
        
    }
    
    
}



package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AddTaskController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addTarefaImage;

    @FXML
    private ImageView apagarImageTarefa;

    @FXML
    private DatePicker datePickerDataTarefa;

    @FXML
    private TextArea fieldDescricaoTarefa;

    @FXML
    private TextField fieldNomeTarefa;

    @FXML
    private AnchorPane anchorpanePrincipal;


    static private String[] nomeTarefa = new String[10];
    static private String[] dataTarefa = new String[10];
    static private String[] descricaoTarefa= new String[10];
    static private int contador=0;

    @FXML
    void initialize() {
        
        anchorpanePrincipal.setOnMouseClicked(event -> {
            anchorpanePrincipal.requestFocus();
        });
        

        apagarImageTarefa.setOnMouseClicked(event ->{
            fieldNomeTarefa.setText("");
            fieldDescricaoTarefa.setText("");
            datePickerDataTarefa.setValue(null);;
        });



        addTarefaImage.setOnMouseClicked(event -> {
            
            if(!fieldNomeTarefa.getText().equals("") && contador <10){
                nomeTarefa[contador] = fieldNomeTarefa.getText();
                descricaoTarefa[contador] = fieldDescricaoTarefa.getText();
                dataTarefa[contador] = datePickerDataTarefa.getValue().toString();
                contador++;

                addTarefaImage.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/view/TaskList.fxml"));

                try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                Parent root = loader.getRoot();

                // necessário para passar os dados ao outro controlador essa linha é referente a linha 83 do TaskList;
                TaskListController addTasksController = loader.getController();
                addTasksController.setAddTaskContrroler(this);

                            Stage stage = new Stage();
                            stage.setScene(new Scene(root));
                            stage.initStyle(StageStyle.UNDECORATED);
                            stage.showAndWait();

            }  
        });
    }

        
    public String getNomeTarefa(int num) {
        return nomeTarefa[num];
    }
    
    public String getDataTarefa(int num) {
        return dataTarefa[num];
    }

    public String getDescricaoTarefa(int num){
        return descricaoTarefa[num];
    }

    


}

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
    private ImageView backImageBtt;

    @FXML
    private DatePicker datePickerDataTarefa;

    @FXML
    private TextArea fieldDescricaoTarefa;

    @FXML
    private TextField fieldNomeTarefa;

    @FXML
    private AnchorPane anchorpanePrincipal;


    @FXML
    void initialize() {
        
        
        anchorpanePrincipal.setOnMouseClicked(event -> {
            anchorpanePrincipal.requestFocus();
        });
        
        
        //voltar para a tela de tasks
        backImageBtt.setOnMouseClicked(event ->{
            backImageBtt.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/view/TaskList.fxml"));

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

        });

        apagarImageTarefa.setOnMouseClicked(event ->{
            fieldNomeTarefa.setText("");
            fieldDescricaoTarefa.setText("");
            datePickerDataTarefa.setValue(null);;
        });

    }

}

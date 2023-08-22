
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Controller{

    
    @FXML
    private CheckBox check1;

    @FXML
    private CheckBox check2;

    @FXML
    private Button button1;

    @FXML
    void pegar() {
        
        System.out.println(check1.selectedProperty());//BooleanProperty [bean: CheckBox[id=check1, styleClass=check-box]'Java', name: selected, value: true]
        System.out.println(check2.selectedProperty());//BooleanProperty [bean: CheckBox[id=check2, styleClass=check-box]'Spring Boot', name: selected, value: false]
        
        System.out.println(check1.selectedProperty().getValue());//true
        System.out.println(check2.selectedProperty().getValue());//false
        
        System.out.println(check1.selectedProperty().getBean());//CheckBox[id=check1, styleClass=check-box]'Java'
        System.out.println(check2.selectedProperty().getBean());//CheckBox[id=check2, styleClass=check-box]'Spring Boot'
        
        System.out.println(check1.selectedProperty().getName());//selected
        System.out.println(check2.selectedProperty().getName());//selected
        
        System.out.println(check1.selectedProperty().getClass());//class javafx.scene.control.CheckBox$2
        System.out.println(check2.selectedProperty().getClass());//class javafx.scene.control.CheckBox$2

        System.out.println(check1.getText());//Java
        System.out.println(check2.getText());//PHP

        button1.setText("Olhe o Console");
    }

}


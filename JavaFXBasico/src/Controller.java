import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    @FXML
    private Button button1;

    @FXML
    private Label label1;

        @FXML
    private TextField text1;

    @FXML
    void buttonAct(ActionEvent event) {
        label1.setText(text1.getText().trim());
    }

    @FXML
    void labelAct(MouseEvent event) {

    }

}

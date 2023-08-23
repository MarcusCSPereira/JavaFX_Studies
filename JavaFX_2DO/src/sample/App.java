package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/view/login.fxml"));
        Parent root = loader.load();
        Scene tela = new Scene(root,700,400);
        
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        primaryStage.setTitle("Login Screen");
        primaryStage.setScene(tela);
        primaryStage.show();
        

    }
}

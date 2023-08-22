
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import model.Categoria;

public class Controller implements Initializable {

    private List<Categoria> categorias = new ArrayList<Categoria>();
    
    @FXML
    private ComboBox<Categoria> CBCategories;

    @FXML
    void initialize(ActionEvent event) {
    }
    
    private ObservableList<Categoria> obsCategorias;
    
    public void carregarCategorias(){

        Categoria categoria1 = new Categoria(1, "Bebidas");
        Categoria categoria2 = new Categoria(2, "Comidas");

        categorias.add(categoria2);
        categorias.add(categoria1);

        obsCategorias = FXCollections.observableArrayList(categorias);

        CBCategories.setItems(obsCategorias);
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregarCategorias();
    }

    @FXML
    private Label label1;

    @FXML
    private Button Escolha;

    @FXML
    private void Clique(ActionEvent event) {

        Categoria categoria = CBCategories.getSelectionModel().getSelectedItem();

        label1.setText(categoria.getNome() + ", que possui ID: " + categoria.getId());


    }
    
    

    
    

}

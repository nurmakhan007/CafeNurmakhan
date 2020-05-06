package sample;

import com.jfoenix.controls.JFXButton;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AdminController {
    @FXML
    private TableView<Order> tableViewAdmin;

    @FXML
    private TableColumn<Order, Integer> tableColumnPrice;

    @FXML
    private ImageView imgAdmin;

    @FXML
    private TableColumn<Order, String> tableColumnName;
    @FXML
    private JFXButton exitButton;

    @FXML
    private TableColumn<Order, String> tableColumnNameofFood;
    private static ArrayList <Order> list = new Database().getOrder();
    private static ObservableList<Order> o_list = FXCollections.observableArrayList();
    public void initialize() {
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnNameofFood.setCellValueFactory(new PropertyValueFactory<>("nameOfFood"));
        tableColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        o_list.setAll(list);
        tableViewAdmin.setItems(o_list);
        exitButton.setOnAction(event -> {
            change(exitButton,"samplee");
        });
    }

    public void change(Button button, String url) {
        button.getScene().getWindow().hide();
        FXMLLoader loader  = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/" + url + ".fxml"));
        try {
            loader.load();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

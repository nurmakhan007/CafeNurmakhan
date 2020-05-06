package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CommonController {
    @FXML
    private ImageView imgBesh;

    @FXML
    private JFXButton AboutUsButton;

    @FXML
    private Label ImanNurLabel;

    @FXML
    private Label dataEmailLabel;

    @FXML
    private ImageView imgMenuBesh;

    @FXML
    private JFXButton OnlineorderButton;

    @FXML
    private Label foodLabel;

    @FXML
    private Label EmailLabel;

    @FXML
    private Label dataAdressLabel;

    @FXML
    private Label MobilePhoneLabel;

    @FXML
    private Label textLabel;

    @FXML
    private Label drinkLabel;

    @FXML
    private Label NumberLabel;

    @FXML
    private AnchorPane MenuAnchorPane;

    @FXML
    private ImageView ImgCard;

    @FXML
    private AnchorPane HboxAnchorPane;

    @FXML
    private AnchorPane aboutUsAnchorPane;

    @FXML
    private ImageView qazaqgrillimg;

    @FXML
    private AnchorPane ContactAnchorPane;

    @FXML
    private JFXButton ContactButton;

    @FXML
    private AnchorPane OnlineOrderAnchorPane;

    @FXML
    private Label adressLabel;

    @FXML
    private JFXTextField TextfieldNameOfFood;

    @FXML
    private JFXTextField textFieldName;

    @FXML
    private ImageView znakImg;

    @FXML
    private JFXButton exitButton;

    @FXML
    private Label OrderLabel;

    @FXML
    private JFXButton menuButton;

    @FXML
    private JFXButton writeToUsButton;

    @FXML
    private JFXButton addOrderButton;
    private Database database = new Database();
        public void initialize() {
                addOrderButton.setOnAction(event -> {
                    String nameOfFood = TextfieldNameOfFood.getText();
                    String name = textFieldName.getText();
                    if (database.addOrder(nameOfFood,name)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Your order is accepted!!!");
                        alert.showAndWait();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Your order is not accepted!!!");
                        alert.showAndWait();
                    }
                });
                ContactAnchorPane.setVisible(false);
                aboutUsAnchorPane.setVisible(false);
                MenuAnchorPane.setVisible(false);
                OnlineOrderAnchorPane.setVisible(false);
                ContactButton.setOnAction(event -> {
                        ContactAnchorPane.setVisible(true);
                        aboutUsAnchorPane.setVisible(false);
                        MenuAnchorPane.setVisible(false);
                    OnlineOrderAnchorPane.setVisible(false);
                });
                AboutUsButton.setOnAction(event -> {
                        aboutUsAnchorPane.setVisible(true);
                        ContactAnchorPane.setVisible(false);
                        MenuAnchorPane.setVisible(false);
                        OnlineOrderAnchorPane.setVisible(false);
                });
                menuButton.setOnAction(event -> {
                        MenuAnchorPane.setVisible(true);
                        aboutUsAnchorPane.setVisible(false);
                        ContactAnchorPane.setVisible(false);
                    OnlineOrderAnchorPane.setVisible(false);
                });
                OnlineorderButton.setOnAction(event -> {
                    MenuAnchorPane.setVisible(false);
                    aboutUsAnchorPane.setVisible(false);
                    ContactAnchorPane.setVisible(false);
                    OnlineOrderAnchorPane.setVisible(true);
                });
                exitButton.setOnAction(event -> {
                    change(exitButton,"samplee");
                    System.out.println("exit");
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

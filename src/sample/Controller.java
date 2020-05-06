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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller   {

    @FXML
    private ImageView image;

    @FXML
    private Button exitButton;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Button signupButton;

    @FXML
    private Button loginButton;

    @FXML
    private JFXButton forgotpasswordButton;

    @FXML
    private JFXTextField passwordField;

    @FXML
    private JFXTextField loginField;

    private Database database = new Database();

    public void initialize() {
        signupButton.setOnAction(event -> {
            change(signupButton,"signup");
        });
        exitButton.setOnAction(event -> {
            System.exit(0);
        });
        loginButton.setOnAction(event -> {
          String login = loginField.getText();
          String password = passwordField.getText();
          int id = database.checkClient(login,password);
         if (id != -1) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setContentText("You are Logged!!!");
             alert.showAndWait();
            loginField.setText("");
             passwordField.setText("");
             change(loginButton,"comon");
         }
         else if (database.checkAdmin(login,password)){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setContentText("Welcome Admin!!!");
             alert.showAndWait();
            change(loginButton,"admin");
         }
         else {
             Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setContentText("EROR");
             alert.showAndWait();
             loginField.setText("");
             passwordField.setText("");
         }
        });
        forgotpasswordButton.setOnAction(event -> {
            change(forgotpasswordButton,"forgotpassword");
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

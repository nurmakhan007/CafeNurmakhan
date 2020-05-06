package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ForgotPasswordController {
    @FXML
    private JFXTextField LoginField;

    @FXML
    private JFXTextField newPasswordField;


    @FXML
    private JFXButton exitButton;

    @FXML
    private ImageView imgforgot;

    @FXML
    private JFXButton changeButton;

    private Database database = new Database();
    public void initialize() {
        changeButton.setOnAction(event -> {
           String login = LoginField.getText();
           String newPassword = newPasswordField.getText();
          if (database.changePassword(login,newPassword)) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setContentText("Succesfully changed!!!");
              alert.showAndWait();
              LoginField.setText("");
              newPasswordField.setText("");
          }
          else {
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setContentText("DO NOT changed!!!");
              alert.showAndWait();
              LoginField.setText("");
              newPasswordField.setText("");
          }
        });
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

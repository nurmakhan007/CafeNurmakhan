package sample;

import Server.ClientHandler;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SignupController {
    @FXML
    private Button ExitButton;

    @FXML
    private Label RegistrationLabel;

    @FXML
    private JFXPasswordField confrimpasswordField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField emailField;

    @FXML
    private Button RegistrationButton;

    @FXML
    private JFXTextField mobilePhoneField;

    @FXML
    private JFXTextField loginField;

    private Database database = new Database();
    private ClientHandler clientHandler = new ClientHandler();
    public void initialize() throws IOException {
        ArrayList <Client> clients = new ArrayList<>();
        clientHandler.writeRequest("GET_USERS");
        if (clientHandler.checkRequest("USERS_GOT")) {
            clients = ClientHandler.clients;
            System.out.println("nagan kirgish");
        }

        System.out.println( clients);
        RegistrationButton.setOnAction(event -> {
            String login = loginField.getText();
            String password = passwordField.getText();
            String email = emailField.getText();
            String mobilePhone = mobilePhoneField.getText();
            try {
                Client client = new Client(login,password,email,mobilePhone);
                if (clientHandler.writeRequest("ADD_USER",client)) {
                    //database.addClient(new Client(login,password,email,mobilePhone));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Congratulations You are Registred!!!");
                    alert.showAndWait();
                    loginField.setText("");
                    passwordField.setText("");
                    confrimpasswordField.setText("");
                    emailField.setText("");
                    mobilePhoneField.setText("");
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Not registred!!!");
                    alert.showAndWait();
                    loginField.setText("");
                    passwordField.setText("");
                    confrimpasswordField.setText("");
                    emailField.setText("");
                    mobilePhoneField.setText("");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ExitButton.setOnAction(event -> {
            change(ExitButton,"samplee");
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

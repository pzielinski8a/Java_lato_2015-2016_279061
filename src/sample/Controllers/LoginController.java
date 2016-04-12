package sample.Controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;
import sample.Models.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import sample.Controllers.NewAccountController;
import sample.NetworkConnection;


public class LoginController implements Initializable{

    @FXML
   private NewAccountController newAccout;

    @FXML
    private Button loginUser;

    @FXML
    private TextField insertPassword;

    @FXML
    private TextField insertLogin;

    MainController main = new MainController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loginEvent() throws IOException {

        if(insertLogin.getText().equals(main.serwer.getUsers().toArray()[1].toString())){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
        }

    }


}

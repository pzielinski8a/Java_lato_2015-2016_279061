package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Models.User;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;


public class NewAccountController implements Initializable {

    MainController main = new MainController();

    @FXML
    private TextField userPassword;

    @FXML
    private TextField userLastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewAccountController)) return false;

        NewAccountController that = (NewAccountController) o;

        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        return userRepeatPassword != null ? userRepeatPassword.equals(that.userRepeatPassword) : that.userRepeatPassword == null;

    }

    @FXML
    private Label userSpecific;

    @FXML
    private TextField userRepeatPassword;

    public TextField getUserFirstName() {
        return userFirstName;
    }

    @FXML
    private TextField userFirstName;

    public Button getCreateAccount() {
        return createAccount;
    }

    @FXML
    private Button createAccount;

    @FXML
    private DatePicker userDate;

    @Override
    public void initialize(URL location, ResourceBundle resources){
    }

    @FXML
    private void createNewUser(){
        main.serwer.getUsers().add(new User(userFirstName.getText()));

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/Views/Main.fxml"));
//        try {
//            Parent root = (Parent)loader.load();
//        }
//        catch (Exception e){
//            e.getMessage();
//        }
//
//        MainController main = loader.getController();
//        System.out.println(main);
//
//        try{
//           // main.addUser();
//        }
//        catch (Exception e){
//            e.getMessage();
//        }


    }

}

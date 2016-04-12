package sample.Controllers;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Models.Client;
import sample.Models.Server;
import sample.Models.User;
import sample.NetworkConnection;


public class MainController extends Application implements Initializable{

    @FXML
    private Button loginMain;

    @FXML
    private Button exit;

    @FXML
    private Button showRanking;

    @FXML
    private Button newAccount;

    public NetworkConnection client = createClient();
    public NetworkConnection serwer = createServer();


    @FXML
    private void openingWindowsHandler(ActionEvent event) throws IOException{
       if(event.getSource() == loginMain){
           createNewScene("/sample/Views/Login.fxml","login");
       }else if(event.getSource() == newAccount) {
          createNewScene("/sample/Views/NewAccount.fxml","newAccount");
        }
       else if(event.getSource() == exit){
           Platform.exit();
       }

    }

    private void createNewScene(String url,String controllerName) throws IOException{

        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
        Parent root = (Parent)loader.load();

        window.setScene(new Scene(root));
        window.initModality(Modality.APPLICATION_MODAL);
        window.initOwner(loginMain.getScene().getWindow());
        window.showAndWait();
    }


    private Client createClient() {
        System.out.println("teraz client");
        return new Client("127.0.0.1", 55555, data -> {
            Platform.runLater(() -> {
            });
        });
    }
    private Server createServer() {
        System.out.println("server odpalonyyy!");
        return new Server(55555, data -> {
            Platform.runLater(() -> {
            });
        }
        );
    }

    @Override
    public void stop() throws Exception {
        client.closeConnection();
        serwer.closeConnection();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       try{
           client.startConnection();
           serwer.startConnection();
       }catch (Exception e){

       }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

    }

}
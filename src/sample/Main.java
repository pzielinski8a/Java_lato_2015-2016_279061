package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controllers.MainController;
import sample.Models.Server;


public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {

      //  System.out.println(connection.getUsers().toString());
        window = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/Main.fxml"));
        Parent root = (Parent)loader.load();
        MainController main = loader.getController();
        window.setScene(new Scene(root));
        window.setTitle("Ranking v0.1");
        window.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}

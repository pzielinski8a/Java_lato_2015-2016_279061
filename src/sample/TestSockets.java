package sample;/**
 * Created by Piotr on 2016-03-20.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Models.Client;
import sample.Models.Server;

public class TestSockets extends Application {

//    private boolean isServer = true;
//    private boolean isServer = false;
    private TextArea messages = new TextArea();
//    private NetworkConnection connection = isServer ? createServer() : createClient();
    private NetworkConnection connection = createServer();


    private Parent createContent() {
        messages.setPrefHeight(550);
        TextField input = new TextField();
        input.setOnAction(event -> {
            String message = "Server: ";
            message += input.getText();
            input.clear();

            messages.appendText(message + "\n");

            try {
                connection.send(message);
              // connection.send(connection.getTab().length);
               // connection.send(connection.getUsers().toString());

            }
            catch (Exception e) {
                messages.appendText("Failed to send\n");
            }
        });

        VBox root = new VBox(20, messages, input);
        root.setPrefSize(600, 600);
        return root;
    }

    @Override
    public void init() throws Exception {
        connection.startConnection();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
        System.out.println("server odpalony!");
    }

    @Override
    public void stop() throws Exception {
        connection.closeConnection();
    }


    private Server createServer() {
        return new Server(55555, data -> {
            Platform.runLater(() -> {
                messages.appendText(data.toString() + "\n");
            });
        }
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
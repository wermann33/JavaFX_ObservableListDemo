package net.wermann.observerpatterndemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("observerPatternDemo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Observer Pattern Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

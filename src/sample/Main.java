package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        try{
            /*
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent parent = loader.load();

            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sample JavaFx Application");
            primaryStage.show();
            */

            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            ScrollPane scrollPane = loader.load();

            //AJUSTAR A JANELA A BARRA DE MENU
            scrollPane.setFitToHeight(true);
            scrollPane.setFitToWidth(true);

            scene = new Scene(scrollPane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sample JavaFx Application");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Scene getScene(){
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

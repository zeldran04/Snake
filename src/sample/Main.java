package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Snek");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();

//        FlowPane fp = new FlowPane();
//
//
//
//        Snake snake = new Snake();
//        SnakeCanvas c = new SnakeCanvas(snake);
//        SnakeController snakeController = new SnakeController(snake, c, fp);



    }


    public static void main(String[] args) {
        launch(args);
    }
}

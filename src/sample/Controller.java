package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Controller {

    public void buttonClicked(){
        FlowPane fp = new FlowPane();
        Stage stage = new Stage();


        Snake snake = new Snake();
        SnakeCanvas c = new SnakeCanvas(snake);
        SnakeController snakeController = new SnakeController(snake, c, fp);
        fp.setAlignment(Pos.CENTER);
        Scene scene = new Scene(fp, 600, 600);

        fp.getChildren().add(c);

        stage.setScene(scene);
        stage.setTitle("Snake Game");
        stage.show();
        c.requestFocus();

        System.out.println("Clicked");
    }

}

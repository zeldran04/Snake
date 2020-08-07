import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.animation.*;
import java.util.*;
import java.net.*;
import javafx.application.*;
import javafx.geometry.*;

public class App extends Application
{
   
   public void start(Stage stage)
   {
      
      FlowPane fp = new FlowPane();
      fp.setAlignment(Pos.CENTER);
      
      Snake snake = new Snake();
      SnakeCanvas c = new SnakeCanvas(snake);
      SnakeController snakeController = new SnakeController(snake, c);      
      
      fp.getChildren().add(c);
      
      
      Scene scene = new Scene(fp, 600, 600);
      stage.setScene(scene);
      stage.setTitle("Snake Game");
      stage.show();
      c.requestFocus();
   }
   
   public static void main(String[] args)
   {
      launch(args);
   }  
}
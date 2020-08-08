import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.animation.*;
import java.util.*;
import java.net.*;
import javafx.application.*;
import javafx.geometry.*;

public class SnakeController 
{
   //this is where it listens for events and checks in with the logic
   //if logic is ok then we draw to the canvas
   
   private Snake snake;
   private SnakeCanvas snakeCanvas;
   private String direction = "";
      
   
   public SnakeController(Snake snake, SnakeCanvas snakeCanvas)
   {
      this.snake = snake;
      this.snakeCanvas = snakeCanvas;
      snakeCanvas.setOnKeyPressed(new KeyHandler());
   }   
   
   public class KeyHandler implements EventHandler<KeyEvent>
   {
        public void handle(KeyEvent event)
        {         
           if(event.getCode() == KeyCode.RIGHT)
           { 
              direction = "right";
           }
           if(event.getCode() == KeyCode.LEFT)
           {
               direction = "left";
           }
           if(event.getCode() == KeyCode.UP)
           {
               direction = "up";
           }            
           if(event.getCode() == KeyCode.DOWN)
           {
              direction = "down";
           }
         
           //MOVE THE SNAKE
           snake.changeDirection(direction);
           //System.out.println(snake.getHead().getXCoordinate()+".."+snake.getHead().getYCoordinate());
       }
   }




}
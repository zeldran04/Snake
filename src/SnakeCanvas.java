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

public class SnakeCanvas extends Canvas
{
   AnimationHandler ah = new AnimationHandler();
   GraphicsContext gc = getGraphicsContext2D();
   
   private int time;
   private int speed = 10;
   private Snake snake;
   private SnakeBody snakeBody; //made to access x and y (Corn WARNED me) 
   private SnakeLogic snakeLogic = new SnakeLogic();   
   private Food food = new Food(600,600);
    
   public SnakeCanvas(Snake snake) 
   {
      this.snake = snake;
      setWidth(600);     
      setHeight(600);

      ah.start();  //start the animation
                        
      draw();
   }

   public void draw()
   {
      gc.clearRect(0,0,600,600);
      gc.setFill(Color.BLACK);
      gc.fillRect(0,0,600,600);//create the black background
      
      drawFood();
      
      SnakeBody current = snake.getTail();
      //gc.setFill(Color.GREEN);
      while(current != null)
      {
         gc.setFill(Color.GREEN);
         gc.fillRect(current.getXCoordinate(),current.getYCoordinate(),50,50);
         gc.setFill(Color.WHITE);
         gc.fillRect(current.getXCoordinate()+15,current.getYCoordinate()+15,20,20);
         current = current.getNext();
      }
   }
   
   public void drawFood()
   {
      gc.setFill(Color.BLUE);
      food.generateX();
      food.generateY();
      gc.fillRect(food.getLocationX(),food.getLocationY(),50,50);
   }

   public class AnimationHandler extends AnimationTimer
   {
      public void handle(long currentTimeInSeconds)
      {  
         if(snakeLogic.didSnakeEatFood(food, snake))
         {
            snake.growSnakeBody();
            snake.moveSnake(snake.getDirection());
            speed -= .3;
         }
         else if(!snakeLogic.didSnakeCollide(snake))
         {
            time += 1;
            
            if(time == speed)  //time should decrease when you eat a food
            {
               snake.moveSnake(snake.getDirection()); 
               System.out.println(snake.getHead().getXCoordinate()+".."+snake.getHead().getYCoordinate());          
               draw();
               time = 0;
            }
         }
         else
         {
            // GAME OVER SCREEN GOES HERE
            //maybe add play again method
            //System.out.println("GAMEOVER");
            //restart the game. set boolean to true
         }
      }
   }
}
import javafx.application.*;
import javafx.event.*;
import javafx.scene.text.*;
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
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class SnakeCanvas extends Canvas {
   AnimationHandler ah = new AnimationHandler();
   GraphicsContext gc = getGraphicsContext2D();

   private int time;
   private int speed = 10;
   private Snake snake;
   private SnakeBody snakeBody; //made to access x and y (Corn WARNED me) 
   private SnakeLogic snakeLogic = new SnakeLogic();
   private Food food = new Food(600, 600);
   Text text = new Text();
   public int score = 0;
   public int newScore;
   public int finalScore;
   public long Highscore;

   public SnakeCanvas(Snake snake) {
      this.snake = snake;
      setWidth(600);
      setHeight(600);

      ah.start();  //start the animation

      draw();
   }

   public void writeJSON() {
      JSONObject obj = new JSONObject();
      obj.put("score", score);


      try (FileWriter file = new FileWriter("roomTemps.json")) {
         file.write(obj.toJSONString());
      } catch (IOException e) {
         e.printStackTrace();
      }

      System.out.print(obj);

   }


   public void readJSON() {
      JSONParser parser = new JSONParser();

      try (Reader reader = new FileReader("roomTemps.json")) {

         JSONObject jsonObject = (JSONObject) parser.parse(reader);
         //System.out.println(jsonObject);

         Highscore = (Long) jsonObject.get("score");
         //System.out.println(Highscore);


      } catch (IOException e) {
         e.printStackTrace();
      } catch (ParseException e) {
         e.printStackTrace();
      }



   }


   public void draw()
   {
      gc.clearRect(0,0,600,600);
      gc.setFill(Color.BLACK);
      gc.fillRect(0,0,600,600);//create the black background

      gc.setFill(Color.WHITE);
      gc.setFont(new Font("", 30));
      gc.fillText("Score: " + (score), 10, 30);
      readJSON();
      gc.fillText("Highscore: " + (Highscore), 10, 70);

      drawFood();


      SnakeBody current = snake.getTail();
      //gc.setFill(Color.GREEN);
      while(current != null)
      {
         gc.setFill(Color.BROWN);
         gc.fillRect(current.getXCoordinate(),current.getYCoordinate(),50,50);
         gc.setFill(Color.WHITE);
         gc.fillRect(current.getXCoordinate()+15,current.getYCoordinate()+15,20,20);
         current = current.getNext();
      }
   }

   public void drawFood()
   {
      gc.setFill(Color.BLUE);
      gc.fillRect(food.getLocationX(),food.getLocationY(),50,50);
   }
   public void newFood()
   {

      food.generateX();
      food.generateY();

   }
   public void getShowText(int gstScore){
      this.newScore = gstScore;
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
            newFood();
            score += 100;

         }
         else if(!snakeLogic.didSnakeCollide(snake))
         {
            time += 1;

            if(time == speed)  //time should decrease when you eat a food
            {
               snake.moveSnake(snake.getDirection());
               //System.out.println(snake.getHead().getXCoordinate()+".."+snake.getHead().getYCoordinate());
               draw();
               time = 0;
            }
         }
         else
         {
            readJSON();
            if (score > Highscore){
               writeJSON();
            }
            }
         }
      }

   }


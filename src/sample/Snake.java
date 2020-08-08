package sample;
import java.util.*;

public class Snake
{
   //this class holds the actual snake
   //snake is a linked list
   
   private SnakeBody head;
   private SnakeBody tail;
   private int size = 0;  //size of the snake
   private String direction = "";
   
     
   public Snake() 
   {
      head = tail = new SnakeBody();
      size++;
   }
   
   public SnakeBody getHead()
   {
      return head;
   }
   
   public SnakeBody getTail()
   {
      return tail;
   }
   
   public void growSnakeBody()
   {
      //know which way the snake is pointing
      SnakeBody newBodyPart = new SnakeBody(tail.getXCoordinate(), tail.getYCoordinate());
      newBodyPart.setNext(tail);  //add snakebodypart to back of snake
      tail = newBodyPart;         //add snakebodypart to back of snake
      //moveSnake(direction);
   }
   
   public String getDirection()
   {
      return direction;
   }
   
   public void moveHead(String direction)
   {              
      if(direction == "right")
      {
         head.incrementXCoordinate("+");
      }
      else if(direction == "left")
      {
         head.incrementXCoordinate("-");
      }

      else if(direction == "down")
      {
         head.incrementYCoordinate("+");
      }

      else if(direction == "up")
      {
         head.incrementYCoordinate("-");
      }
      else
      {
         //when the snake is not moving
      }
   }
   
   public void moveSnake(String direction)
   {
      SnakeBody current = tail;
      while(current.getNext() != null)
      {
         //setting the x & y coords to the nextNodes coords in the linkedlist (snakebody)
         //from the back to the front (minus the head)
         current.setXCoordinate(current.getNext().getXCoordinate());
         current.setYCoordinate(current.getNext().getYCoordinate());
         current = current.getNext();
      }
      moveHead(direction); //move snake like a snail
   }
   
   public void changeDirection(String direction)
   {
      this.direction = direction;
   }

}
package sample;

public class SnakeLogic
{
   //Food food;

   public SnakeLogic()
   {
   
   }
   
   //checks if snake hit wall or self
   public boolean didSnakeCollide(Snake snake)
   {
      SnakeBody current = snake.getTail();
      while(current.getNext() != null)
      {
         if(snake.getHead().getXCoordinate() == current.getXCoordinate() && snake.getHead().getYCoordinate() == current.getYCoordinate())
         {
            return true; 
         }
         current = current.getNext();
      }
      //check if snake crashed into wall
      if(snake.getHead().getXCoordinate() <= 0 || snake.getHead().getXCoordinate() >= 600 || snake.getHead().getYCoordinate() <= 0 || snake.getHead().getYCoordinate() >= 600)
      {
         return true;
      } 
      return false;
   }
   
   //checks if it ate food
   public boolean didSnakeEatFood(Food food, Snake snake)
   {
      if(snake.getHead().getXCoordinate() == food.getLocationX())
      {
         if(snake.getHead().getYCoordinate() == food.getLocationY())
         {
            return true;
         }
      }
      return false;
   }

}
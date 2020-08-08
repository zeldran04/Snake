public class SnakeBody
{
   private int StartxCoordinate = 100;
   private int StartyCoordinate = 100;
   private int xCoordinate; 
   private int yCoordinate;
   private SnakeBody next;
   public SnakeBody()  //when game starts we create this head
   {
      xCoordinate = 100;
      yCoordinate = 100;
      next = null;
   }
   
   public SnakeBody(int xCoor, int yCoor)//when snake eats food create this node
   {
      xCoordinate = xCoor;
      yCoordinate = yCoor;
      next = null;  //GRFHAVRHE
   }

   public int getXCoordinate()
   {
      return xCoordinate;
   }
   
   public int getYCoordinate()
   {
      return yCoordinate;
   }
   
   public void setXCoordinate(int x)
   {
      xCoordinate = x;
   }
   
   public void setYCoordinate(int y)
   {
      yCoordinate = y;
   }
   
   public void incrementXCoordinate(String incrementer)
   {
      if(incrementer == "+")
      {
         xCoordinate+= 50;
      }
      else
      {
         xCoordinate-= 50;
      }
   }
   
   public void incrementYCoordinate(String incrementer)
   {
      if(incrementer == "+")
      {
         yCoordinate+= 50;
      }
      else
      {
         yCoordinate-= 50;
      }
   }

   
   public SnakeBody getNext()
   {
      return next;
   }
   
   public void setNext(SnakeBody next)
   {
      this.next = next;
   }

   
   
   

}
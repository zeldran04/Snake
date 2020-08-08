package sample;
import java.util.Random;

public class Food {
    private int WIDTH;
    private int HEIGHT;
    private int randX;
    private int randY;
    private Random randNum;

    Food(int width, int height) { //passes in max x and y bounds for playing
        WIDTH = width;
        HEIGHT = height;
        randNum = new Random();
        randX = 200;
        randY = 200;


    }
    public void generateX(){ //qwerty
        randX = randNum.nextInt((WIDTH/50))*50;

    }
    public void generateY(){
        randY = randNum.nextInt((HEIGHT/50))*50;

    }
    public int getLocationX() {

        return randX;
    }
    public int getLocationY() {
        return randY;
    }


}

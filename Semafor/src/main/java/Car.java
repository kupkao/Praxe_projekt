import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Car {
    public int x;
    public int y;
    public int withd;
    public int height;
    public int speed;
    Rectangle rectangle;
    BufferedImage car;
    public boolean start = true;

    public Car() {
        loadsemaforImage();
        defaultSize();
        move();

    }

    public void loadsemaforImage () {
        try {
            car = ImageIO.read(getClass().getResourceAsStream("Bez názvu-2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void defaultSize () {
        x = 850;
        y = 900;
        withd = 60;
        height = 80;
        speed = 10;
    }
    public void move () {
        if (start == true) {
            y -= speed;
            rectangle = new Rectangle(x,y,withd,height);
        }
        rectangle = new Rectangle(x,y,withd,height);

    }
    public void draw (Graphics g){
        g.drawImage(car,x,y,withd,height,null);
    }

}

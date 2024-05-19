import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Car {
    public int x;
    public int y;
    public int width;
    public int height;
    public int speed;
    Rectangle rectangle;
    BufferedImage car;
    public boolean start = true;

    public Car() {
        loadCarImage();
        defaultSize();
    }

    public void loadCarImage() {
        try {
            car = ImageIO.read(getClass().getResourceAsStream("Bez názvu-2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void defaultSize() {
        x = 850;
        y = 900;
        width = 60;
        height = 80;
        speed = 1;
        rectangle = new Rectangle(x, y, width, height);
    }

    public void move() {
        if (start) {
            y -= speed;
            rectangle.setLocation(x, y);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(car, x, y, width, height, null);
    }
}
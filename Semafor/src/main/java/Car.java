import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Car {
    private static int carCounter = 1;
    private int id;
    public int x, x1, x2, x3;
    public int y, y1, y2, y3;
    public int width, height;
    public int speed;
    public Rectangle rectangle, rectangle1, rectangle2, rectangle3;
    private BufferedImage carImage, carImage1, carImage2, carImage3;
    public boolean start = true;
    private Direction direction;

    public Car(int position) {
        this.id = carCounter++;
        loadCarImage();
        initializeRectangles();
        defaultSize(position);
        setDirection(position);
    }

    private void loadCarImage() {
        try {
            carImage = ImageIO.read(getClass().getResourceAsStream("Auto.png"));
            carImage1 = ImageIO.read(getClass().getResourceAsStream("Auto90.png"));
            carImage2 = ImageIO.read(getClass().getResourceAsStream("Auto.png"));
            carImage3 = ImageIO.read(getClass().getResourceAsStream("Auto90.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeRectangles() {
        rectangle = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        rectangle3 = new Rectangle();
    }

    public void defaultSize(int position) {
        width = 70;
        height = 95;
        speed = 1;

        switch (position) {
            case 1 -> {
                x = 700 + 50;
                y = 500 + 600;
                rectangle.setBounds(x, y, width, height);
            }
            case 2 -> {
                x1 = 700 + 800;
                y1 = 500 - 150;
                rectangle1.setBounds(x1, y1, height, width);
            }
            case 3 -> {
                x2 = 700 - 150;
                y2 = 500 - 600;
                rectangle2.setBounds(x2, y2, width, height);
            }
            case 4 -> {
                x3 = 700 - 800;
                y3 = 500 + 50;
                rectangle3.setBounds(x3, y3, height, width);
            }
        }
    }

    private void setDirection(int position) {
        switch (position) {
            case 1 -> direction = Direction.UP;
            case 2 -> direction = Direction.LEFT;
            case 3 -> direction = Direction.DOWN;
            case 4 -> direction = Direction.RIGHT;
        }
    }

    public void move() {
        if (start) {
            switch (direction) {
                case UP -> {
                    y -= speed;
                    rectangle.setLocation(x, y);
                }
                case LEFT -> {
                    x1 -= speed;
                    rectangle1.setLocation(x1, y1);
                }
                case DOWN -> {
                    y2 += speed;
                    rectangle2.setLocation(x2, y2);
                }
                case RIGHT -> {
                    x3 += speed;
                    rectangle3.setLocation(x3, y3);
                }
            }
        }
    }

    public void draw(Graphics g) {
        g.drawImage(carImage, x, y, width, height, null);
        g.drawImage(carImage1, x1, y1, height, width, null);
        g.drawImage(carImage2, x2, y2, width, height, null);
        g.drawImage(carImage3, x3, y3, height, width, null);
        g.setColor(Color.RED);
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        g.drawRect(rectangle1.x, rectangle1.y, rectangle1.width, rectangle1.height);
        g.drawRect(rectangle2.x, rectangle2.y, rectangle2.width, rectangle2.height);
        g.drawRect(rectangle3.x, rectangle3.y, rectangle3.width, rectangle3.height);
    }

    public int getId() {
        return id;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Rectangle getRectangle1() {
        return rectangle1;
    }

    public Rectangle getRectangle2() {
        return rectangle2;
    }

    public Rectangle getRectangle3() {
        return rectangle3;
    }
}

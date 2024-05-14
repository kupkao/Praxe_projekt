import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ProgramLogic implements Runnable {
    public Line2D line;
    public Rectangle rectangle;
    public int x1, y1, x2, y2;
    public int fps = 120;
    Thread programThread;
    Car car = new Car();
    ProgramPanelGUI programPanelGUI = new ProgramPanelGUI();

    public ProgramLogic() {

    }
    public void makeLine () {
        rectangle = new Rectangle(10,10,10,10);

    }
    public void draw (Graphics g) {
    }
    public void update () {

    }
    public void startProgramThread (){
        programThread = new Thread(this);
        programThread.start();
    }


    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (programThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                programPanelGUI.repaint();
                delta--;
                System.out.println("ahoj");
            }
        }
    }
}

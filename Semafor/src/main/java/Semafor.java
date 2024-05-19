import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Semafor {
    public int width = 50;
    public int height = 100;
    BufferedImage semaforImage;
    BufferedImage semafor2Image;

    public Semafor(ProgramPanelGUI programPanelGUI) {
        loadSemaforImage();
    }

    public void loadSemaforImage() {
        try {
            semaforImage = ImageIO.read(getClass().getResourceAsStream("Semafor.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            semafor2Image = ImageIO.read(getClass().getResourceAsStream("Semafor90.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(semaforImage, 850, 650, width, height, null);
        g.drawImage(semaforImage, 500, 410, width, -height, null);
        g.drawImage(semafor2Image, 1010, 420, -height, width, null);
        g.drawImage(semafor2Image, 400, 590, height, width, null);
    }
}


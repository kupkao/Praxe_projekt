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
        g.drawImage(semaforImage, 700-50, 500+150, width, height, null);
        g.drawImage(semaforImage, 700-50, 500-198, width, -height, null);
        g.drawImage(semafor2Image, 700-298, 500-50, height, width, null);
        g.drawImage(semafor2Image, 700+250, 500-50, -height, width, null);
    }
}


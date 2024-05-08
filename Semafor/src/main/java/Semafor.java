import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Semafor {
    public int width = 50 ;
    public int height = 100 ;
    public JButton jButton;
    ProgramPanelGUI programPanelGUI;
    Color color;
    BufferedImage semaforImage;
    BufferedImage semafor2Image;

    public Semafor(ProgramPanelGUI programPanelGUI) {
        this.programPanelGUI = programPanelGUI;
        loadsemaforImage();
    }

    public void loadsemaforImage () {
        try {
            semaforImage = ImageIO.read(getClass().getResourceAsStream("Semafor.png"));
        } catch (IOException i) {
            i.printStackTrace();
        }
        try {
            semafor2Image = ImageIO.read(getClass().getResourceAsStream("Semafor90.png"));
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void draw (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(semaforImage,850,650,width,height, null);
        g.drawImage(semaforImage,500,410,width,-height,null);
        g.drawImage(semafor2Image,1010,420,-height,width,null);
        g.drawImage(semafor2Image,400,590,height,width,null);
        }
    }


import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Semafor {
    public int x = 500;
    public int y = 500;
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
        semaforPosition();
    }

    public void semaforPosition (){
        x = 850;
        y = 600;
    }
    public void loadsemaforImage () {
        try {
            semaforImage = ImageIO.read(getClass().getResourceAsStream("Semafor.png"));
        } catch (IOException i) {
            i.printStackTrace();
        }
        try {
            semafor2Image = ImageIO.read(getClass().getResourceAsStream("semafor-clanokW.png"));
        } catch (IOException i) {
            i.printStackTrace();
        }


    }

    public void draw (Graphics g){
        g.drawImage(semaforImage,x,y,width,height, null);
        g.drawImage(semafor2Image,400,400,70,height,null);
        }
    }


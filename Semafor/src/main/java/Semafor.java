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

    public Semafor(ProgramPanelGUI programPanelGUI) {
        this.programPanelGUI = programPanelGUI;
        loadsemaforImage();
        semaforPosition();
    }

    public void semaforPosition (){
        x = 500;
        y = 500;
    }
    public void loadsemaforImage (){
        try {
           semaforImage= ImageIO.read(getClass().getResourceAsStream("Semafor.png"));
        }
        catch (IOException i){
            i.printStackTrace();

    }

    }
    public void draw (Graphics g){
        g.drawImage(semaforImage,x,y,width,height, null);
        }
    }


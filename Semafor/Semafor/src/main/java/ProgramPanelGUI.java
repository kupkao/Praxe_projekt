import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ProgramPanelGUI extends JPanel {
    BufferedImage backgroudImage;
    public int width = 1400;
    public int heigth = 1000;
    Semafor semafor = new Semafor(this);
    //Intersection intersection = new Intersection(this);
    Program program ;


    public void loadbackgroundImage (){
        try{
            backgroudImage = ImageIO.read(getClass().getResourceAsStream("křižovatka.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    public ProgramPanelGUI () {
        setPreferredSize(new Dimension(width,heigth));
        loadbackgroundImage();
        this.addMouseListener(new Program());
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(backgroudImage,0,0,width,heigth,null);
        //intersection.draw(g);
        semafor.draw(g);
        g.drawString("ahoj",400,400);


    }
}

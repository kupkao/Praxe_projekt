import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ImageRotate {
    Semafor semafor;
    public void imgaeRotate(Graphics2D g){
        try {
            semafor.semaforImage = ImageIO.read(getClass().getResourceAsStream("Semafor.png"));
        }
        catch (IOException i){
            i.printStackTrace();
        }


    }
    public void affineTransfortm (){
        int locationX = 300;
        int locationY = 300;

    }
}

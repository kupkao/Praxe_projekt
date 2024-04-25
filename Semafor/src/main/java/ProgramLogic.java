import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ProgramLogic {
    BufferedImage image;
    public int rotation = 90;
    public void rotateImage (){
        try {
            image = ImageIO.read(getClass().getResourceAsStream("Semafor.png"));
        }
        catch (IOException i){
            i.printStackTrace();
        }


    }
}

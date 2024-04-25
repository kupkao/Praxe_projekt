import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ProgramPanelGUI extends JPanel {
    public int width = 1000;
    public int heigth = 1000;
    Semafor semafor = new Semafor(this);

    public ProgramPanelGUI () {
        setPreferredSize(new Dimension(width,heigth));
        setBackground(Color.BLACK);


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        semafor.draw(g);
    }
}

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ProgramPanelGUI extends JPanel implements MouseListener {
    BufferedImage backgroundImage;
    public int width = 1400;
    public int height = 1000;
    Semafor semafor = new Semafor(this);
    Rectangle buttonRect = new Rectangle(1010, 400, 100, 20);
    ProgramLogic programLogic = new ProgramLogic();
    Car car = new Car();

    public ProgramPanelGUI() {
        setPreferredSize(new Dimension(width, height));
        loadBackgroundImage();
        this.addMouseListener(this);
        programLogic.startProgramThread();

    }


    public void loadBackgroundImage() {
        try {
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("křižovatka.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(backgroundImage, 0, 0, width, height, null);
        semafor.draw(g);
        //intersection.draw(g);
        g.setColor(Color.BLACK);
        g.fillRect(buttonRect.x, buttonRect.y, buttonRect.width, buttonRect.height);
        g.setColor(Color.RED);
        g.drawString("Zmačknete", buttonRect.x + 20, buttonRect.y + 15);
        g.setColor(Color.BLACK);
        programLogic.draw(g);
        car.draw(g);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (buttonRect.contains(e.getPoint())) {
            action();
        }
    }

    private void action() {
        JOptionPane.showMessageDialog(this, "Čekejte");
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}

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
    Semafor semafor;
    Rectangle buttonRect = new Rectangle(700+200, 500-200, 100, 20);
    Rectangle buttonRect1 = new Rectangle(700-300, 500+200, 100, 20);
    Rectangle buttonRect2 = new Rectangle(700+200, 500+200, 100, 20);
    Rectangle buttonRect3 = new Rectangle(700-300, 500-200, 100, 20);
    ProgramLogic programLogic;
    Car car;
    Walls walls = new Walls();

    public ProgramPanelGUI() {
        setPreferredSize(new Dimension(width, height));
        loadBackgroundImage();
        car = new Car();
        semafor = new Semafor(this);
        programLogic = new ProgramLogic(car, this);
        this.addMouseListener(this);
        programLogic.startProgramThread();
    }

    public void loadBackgroundImage() {
        try {
            backgroundImage = ImageIO.read(getClass().getResourceAsStream("Křižovatka.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, -30, -17, width, height, null);
        semafor.draw(g);
        g.setColor(Color.BLACK);
        //walls.draw(g);
        g.fillRect(buttonRect.x, buttonRect.y, buttonRect.width, buttonRect.height);
        g.fillRect(buttonRect1.x, buttonRect1.y,buttonRect1.width,buttonRect1.height);
        g.fillRect(buttonRect2.x, buttonRect2.y, buttonRect2.width, buttonRect2.height);
        g.fillRect(buttonRect3.x, buttonRect3.y, buttonRect3.width, buttonRect3.height);
        g.setColor(Color.RED);
        g.drawString("Zmačknete", buttonRect.x + 20, buttonRect.y + 15);
        g.drawString("Zmačknete", buttonRect1.x +20, buttonRect1.y + 15);
        g.drawString("Zmačknete", buttonRect2.x +20, buttonRect2.y + 15);
        g.drawString("Zmačknete", buttonRect3.x +20, buttonRect3.y + 15);
        car.draw(g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (buttonRect.contains(e.getPoint())) {
            action();
        }
        if (buttonRect1.contains(e.getPoint())) {
            action();
        }
        if (buttonRect2.contains(e.getPoint())) {
            action();
        }
        if (buttonRect3.contains(e.getPoint())) {
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

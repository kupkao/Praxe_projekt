import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramPanelGUI extends JPanel implements MouseListener {
    BufferedImage backgroundImage;
    public int width = 1400;
    public int height = 1000;
    Semafor semafor;
    Rectangle buttonRect = new Rectangle(900, 300, 100, 25);
    Rectangle buttonRect1 = new Rectangle(400, 700, 100, 25);
    Rectangle buttonRect2 = new Rectangle(900, 700, 100, 25);
    Rectangle buttonRect3 = new Rectangle(400, 300, 100, 25);
    ProgramLogic programLogic;
    List<Car> cars;
    Walls walls = new Walls();

    public ProgramPanelGUI() {
        setPreferredSize(new Dimension(width, height));
        loadBackgroundImage();
        cars = new ArrayList<>();
        semafor = new Semafor(this);
        programLogic = new ProgramLogic(this);
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
        g.drawImage(backgroundImage, -73, -185, 1600, 1300, null);
        semafor.draw(g);
        g.setColor(Color.BLACK);
        //walls.draw(g);
        g.fillRect(buttonRect.x, buttonRect.y, buttonRect.width, buttonRect.height);
        g.fillRect(buttonRect1.x, buttonRect1.y, buttonRect1.width, buttonRect1.height);
        g.fillRect(buttonRect2.x, buttonRect2.y, buttonRect2.width, buttonRect2.height);
        g.fillRect(buttonRect3.x, buttonRect3.y, buttonRect3.width, buttonRect3.height);
        g.setColor(Color.RED);
        g.drawString("Zmačknete", buttonRect.x + 20, buttonRect.y + 15);
        g.drawString("Zmačknete", buttonRect1.x + 20, buttonRect1.y + 15);
        g.drawString("Zmačknete", buttonRect2.x + 20, buttonRect2.y + 15);
        g.drawString("Zmačknete", buttonRect3.x + 20, buttonRect3.y + 15);
        for (Car car : cars) {
            car.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (buttonRect.contains(e.getPoint())) {
            toggleWall(0);
            toggleWall(1);
        }
        if (buttonRect1.contains(e.getPoint())) {
            toggleWall(1);
            toggleWall(0);
        }
        if (buttonRect2.contains(e.getPoint())) {
            toggleWall(2);
            toggleWall(3);
        }
        if (buttonRect3.contains(e.getPoint())) {
            toggleWall(3);
            toggleWall(2);
        }
    }

    private void toggleWall(int index) {
        programLogic.toggleWall(index);
    }

    public void addCar(Car car) {
        cars.add(car);
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

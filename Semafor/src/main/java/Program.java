import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Program implements MouseListener {
    public int x = 500;
    public int y = 500;
    public static void main(String[] args) {
        ProgramFrameGUI programGUI = new ProgramFrameGUI();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

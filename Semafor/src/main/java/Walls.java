import java.awt.*;
import java.util.ArrayList;

public class Walls {
    private final ArrayList<Rectangle> rects;

    public Walls() {
        rects = new ArrayList<>();
        initWalls();
    }

    private void initWalls() {
        rects.add(new Rectangle(700 - 200, 500 - 200, 1, 350));
        rects.add(new Rectangle(700 + 150, 500 - 200, 1, 350));
        rects.add(new Rectangle(700 - 200, 500 + 150, 350, 1));
        rects.add(new Rectangle(700 - 200, 500 - 200, 350, 1));
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        for (Rectangle rect : rects) {
            g.drawRect(rect.x, rect.y, rect.width, rect.height);
        }
    }

    public ArrayList<Rectangle> getRects() {
        return rects;
    }
}

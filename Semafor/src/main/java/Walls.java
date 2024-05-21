import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Walls {
    private final List<Wall> walls;

    public Walls() {
        walls = new ArrayList<>();
        initWalls();
    }

    private void initWalls() {
        walls.add(new Wall(new Rectangle(700 - 200, 500 - 200, 1, 350)));
        walls.add(new Wall(new Rectangle(700 + 150, 500 - 200, 1, 350)));
        walls.add(new Wall(new Rectangle(700 - 200, 500 + 150, 350, 1)));
        walls.add(new Wall(new Rectangle(700 - 200, 500 - 200, 350, 1)));
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        for (Wall wall : walls) {
            if (wall.isActive()) {
                g.drawRect(wall.getRect().x, wall.getRect().y, wall.getRect().width, wall.getRect().height);
            }
        }
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void deactivateWall(int index) {
        if (index >= 0 && index < walls.size()) {
            walls.get(index).setActive(false);
        }
    }

    public void activateWall(int index) {
        if (index >= 0 && index < walls.size()) {
            walls.get(index).setActive(true);
        }
    }

    public void toggleWall(int index) {
        if (index >= 0 && index < walls.size()) {
            Wall wall = walls.get(index);
            wall.setActive(!wall.isActive());
        }
    }

    public static class Wall {
        private final Rectangle rect;
        private boolean active;

        public Wall(Rectangle rect) {
            this.rect = rect;
            this.active = true;
        }

        public Rectangle getRect() {
            return rect;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }
}

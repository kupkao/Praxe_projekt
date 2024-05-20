import java.awt.*;

public class ProgramLogic implements Runnable {
    public int fps = 120;
    Thread programThread;
    Car car;
    ProgramPanelGUI programPanelGUI;
    Walls walls;
    int steps = 10;

    public ProgramLogic(Car car, ProgramPanelGUI programPanelGUI) {
        this.car = car;
        this.programPanelGUI = programPanelGUI;
        this.walls = new Walls();
    }

    public void startProgramThread() {
        programThread = new Thread(this);
        programThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (programThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                programPanelGUI.repaint();
                delta--;
            }
        }
    }

    public void update() {
        if (!carCollision(Direction.UP, car, walls, steps)) {
            car.move();
        }
    }

    public boolean carCollision(Direction direction, Car car, Walls walls, int steps) {
        Rectangle collisionRectangle;
        switch (direction) {
            case RIGHT -> collisionRectangle = new Rectangle(car.getX() + steps, car.getY(), car.getWidth(), car.getHeight());
            case LEFT -> collisionRectangle = new Rectangle(car.getX() - steps, car.getY(), car.getWidth(), car.getHeight());
            case UP -> collisionRectangle = new Rectangle(car.getX(), car.getY() - steps, car.getWidth(), car.getHeight());
            case DOWN -> collisionRectangle = new Rectangle(car.getX(), car.getY() + steps, car.getWidth(), car.getHeight());
            default -> throw new IllegalStateException("GG" + direction);
        }

        for (Rectangle rect : walls.getRects()) {
            if (collisionRectangle.intersects(rect)) {
                return true;
            }
        }
        return false;
    }
}

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ProgramLogic implements Runnable {
    public int fps = 120;
    Thread programThread;
    List<Car> cars;
    ProgramPanelGUI programPanelGUI;
    Walls walls;
    int steps = 10;
    ScheduledExecutorService scheduler;

    public ProgramLogic(ProgramPanelGUI programPanelGUI) {
        this.cars = new ArrayList<>();
        this.programPanelGUI = programPanelGUI;
        this.walls = new Walls();
        scheduler = Executors.newScheduledThreadPool(1);
        startCarSpawner();
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
        for (Car car : cars) {
            if (!carCollision(car)) {
                car.move();
            }
        }
    }

    public boolean carCollision(Car car) {
        Rectangle[] collisionRectangles = { car.getRectangle(), car.getRectangle1(), car.getRectangle2(), car.getRectangle3() };
        for (Walls.Wall wall : walls.getWalls()) {
            for (Rectangle collisionRectangle : collisionRectangles) {
                if (collisionRectangle != null && wall.isActive() && collisionRectangle.intersects(wall.getRect())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void spawnCar(int position) {
        Car newCar = new Car(position);
        cars.add(newCar);
        programPanelGUI.addCar(newCar);
    }

    private void startCarSpawner() {
        scheduler.scheduleAtFixedRate(() -> {
            for (int i = 1; i <= 4; i++) {
                spawnCar(i);
            }
        }, 0, 2 , TimeUnit.SECONDS);
    }

    public void deactivateWall(int index) {
        walls.deactivateWall(index);
    }

    public void toggleWall(int index) {
        walls.toggleWall(index);
    }
}

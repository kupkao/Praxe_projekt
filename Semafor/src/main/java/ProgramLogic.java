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

        // Check for collisions between cars
        checkCarCollisions();
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

    private void checkCarCollisions() {
        for (int i = 0; i < cars.size(); i++) {
            Car carA = cars.get(i);
            for (int j = i + 1; j < cars.size(); j++) {
                Car carB = cars.get(j);
                if ((carA.getRectangle() != null && carB.getRectangle() != null && carA.getRectangle().intersects(carB.getRectangle())) ||
                        (carA.getRectangle1() != null && carB.getRectangle1() != null && carA.getRectangle1().intersects(carB.getRectangle1())) ||
                        (carA.getRectangle2() != null && carB.getRectangle2() != null && carA.getRectangle2().intersects(carB.getRectangle2())) ||
                        (carA.getRectangle3() != null && carB.getRectangle3() != null && carA.getRectangle3().intersects(carB.getRectangle3()))) {
                    // Handle car collision
                    System.out.println("Collision detected between car " + carA.getId() + " and car " + carB.getId());
                    // Implement additional logic for handling the collision
                }
            }
        }
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
        }, 0, 10, TimeUnit.SECONDS); // Spawns cars every 5 seconds
    }

    public void deactivateWall(int index) {
        walls.deactivateWall(index);
    }

    public void toggleWall(int index) {
        walls.toggleWall(index);
    }
}

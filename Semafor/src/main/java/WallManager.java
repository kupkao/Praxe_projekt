import java.util.List;

public class    WallManager implements Runnable {
    private Walls walls;
    private boolean running;
    private int interval;

    public WallManager(Walls walls, int interval) {
        this.walls = walls;
        this.interval = interval;
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            cycleWalls();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void cycleWalls() {
        List<Walls.Wall> wallList = walls.getWalls();
        for (Walls.Wall wall : wallList) {
            wall.setActive(!wall.isActive());
        }
    }
}

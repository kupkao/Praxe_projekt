public class ProgramLogic implements Runnable {
    public int fps = 120;
    Thread programThread;
    Car car;
    ProgramPanelGUI programPanelGUI;

    public ProgramLogic(Car car, ProgramPanelGUI programPanelGUI) {
        this.car = car;
        this.programPanelGUI = programPanelGUI;
    }

    public void startProgramThread() {
        programThread = new Thread(this);
        programThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
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
        car.move();
    }
}
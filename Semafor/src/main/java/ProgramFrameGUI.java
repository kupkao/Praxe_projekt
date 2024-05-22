import javax.swing.*;

public class ProgramFrameGUI extends JFrame {
    public ProgramFrameGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1400, 1000);
        setTitle("Semafor");
        setResizable(true);
        setLocationRelativeTo(null);
        ProgramPanelGUI programPanelGUI = new ProgramPanelGUI();
        add(programPanelGUI);
        pack();
        setVisible(true);
    }
}

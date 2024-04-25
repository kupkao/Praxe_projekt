import javax.swing.*;

public class ProgramFrameGUI extends JFrame {
    public ProgramFrameGUI (){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1000,1000);
        setTitle("Semafor");
        setResizable(false);
        ProgramPanelGUI programPanelGUI = new ProgramPanelGUI();
        add(programPanelGUI);
        pack();

        setLocationRelativeTo(null);
    }

}

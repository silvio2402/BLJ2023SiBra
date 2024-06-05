import javax.swing.*;

import Model.DataStore;
import View.MainFrame;

public class App {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "3.0");
        DataStore.loadSampleData();
        // runs in AWT thread
        SwingUtilities.invokeLater(MainFrame::new);
    }

}

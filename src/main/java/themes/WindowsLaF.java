package themes;

import javax.swing.*;

public class WindowsLaF {

    public static void windows_LaF() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

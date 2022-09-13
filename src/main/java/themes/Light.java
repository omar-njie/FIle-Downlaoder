package themes;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlContrastIJTheme;

import javax.swing.*;

public class Light {


    public static void light_mode() {
        try {
            UIManager.setLookAndFeel(new FlatLightOwlContrastIJTheme());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

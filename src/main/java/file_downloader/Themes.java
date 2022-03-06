package file_downloader;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanContrastIJTheme;

import javax.swing.*;

public class Themes {

    public Themes() {
        dark_mode();
    }

    public static void dark_mode() {
        try {
            UIManager.setLookAndFeel(new FlatMaterialDeepOceanContrastIJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

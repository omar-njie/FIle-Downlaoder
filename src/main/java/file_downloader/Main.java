package file_downloader;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanContrastIJTheme;

import javax.swing.*;

public class Main {

    public static String custom_directory;
    public static boolean custom_directory_flag;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            dark_mode();
            new Ui();
        });
    }

    public static void dark_mode() {
        try {
            UIManager.setLookAndFeel(new FlatMaterialDeepOceanContrastIJTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

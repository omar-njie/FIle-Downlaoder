package file_downloader;

import themes.DefaultTheme;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        OsIdentifier osIdentifier = new OsIdentifier(os);
        if (osIdentifier.is_mac()) {
            System.setProperty("apple.awt.application.appearance", "system");
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }

        SwingUtilities.invokeLater(() -> {
            DefaultTheme.default_theme();
            new Settings();
        });
    }
}

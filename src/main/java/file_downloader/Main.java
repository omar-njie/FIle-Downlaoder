package file_downloader;

import themes.DefaultTheme;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DefaultTheme.default_theme();
            new Settings();
        });
    }
}

package file_downloader;

import themes.Dark;
import themes.DefaultTheme;
import themes.Light;
import themes.WindowsLaF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame
        implements Runnable, ActionListener {

    private final JMenuBar menu_bar = new JMenuBar();
    private final JMenu settings = new JMenu("Settings");
    private final JMenuItem reload = new JMenuItem("Reload");
    private final JMenuItem exit = new JMenuItem("Exit");
    private final ButtonGroup group = new ButtonGroup();
    private JPanel main_panel;
    private JLabel theme_label;
    private JCheckBox dark_checkbox;
    private JCheckBox light_checkbox;
    private JCheckBox windows_LaF_checkbox;
    private JButton set_button;
    private JButton clear_button;
    private JLabel dark_img;
    private JLabel light_img;
    private JCheckBox default_checkbox;

    public Settings() {
        run();
    }

    static void menu_items(JMenuItem reload, JMenuItem exit, JMenuBar menu_bar, JMenu settings, JMenuItem exit2) {
        settings.setFont(new Font("FiraCode Nerd Font", Font.BOLD, 18));
        reload.setFont(new Font("JetBrainsMono Nerd Font", Font.BOLD, 18));
        exit.setFont(new Font("JetBrainsMono Nerd Font", Font.BOLD, 18));
        menu_bar.add(settings);

        settings.add(reload);
        settings.add(exit2);
    }

    @Override
    public void run() {
        this.setTitle("Theme Settings");
        this.setContentPane(main_panel);
        this.setJMenuBar(menu_bar);
        this.setSize(399, 415);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        menu_items(reload, exit, menu_bar, settings, exit);

        theme_label.setText("Themes");
        dark_checkbox.setText("Dark Mode Contrast");
        light_checkbox.setText("Light Mode");
        windows_LaF_checkbox.setText("Windows LaF");
        default_checkbox.setText("Default Dark Theme");
        clear_button.setText("Clear");
        set_button.setText("Set Theme");

        group.add(dark_checkbox);
        group.add(light_checkbox);
        group.add(windows_LaF_checkbox);
        group.add(default_checkbox);
        default_checkbox.setSelected(true);

        reload.addActionListener(this);
        exit.addActionListener(this);
        clear_button.addActionListener(this);
        set_button.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }

        if (e.getSource() == reload) {
            group.clearSelection();
        }

        if (e.getSource() == clear_button) {
            group.clearSelection();
        }

        if (e.getSource() == set_button) {

            if (default_checkbox.isSelected()) {
                DefaultTheme.default_theme();
                this.dispose();
                ui_thread_starter();
            }
            if (dark_checkbox.isSelected()) {
                Dark.dark_mode();
                this.dispose();
                ui_thread_starter();

            }
            if (light_checkbox.isSelected()) {
                Light.light_mode();
                this.dispose();
                ui_thread_starter();
            }
            if (windows_LaF_checkbox.isSelected()) {
                WindowsLaF.windows_LaF();
                this.dispose();
                ui_thread_starter();
            }

        }
    }

    private void ui_thread_starter() {
        new Thread(Ui::new).start();
        this.update(this.getGraphics());
    }
}


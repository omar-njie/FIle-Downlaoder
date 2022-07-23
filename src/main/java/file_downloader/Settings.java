package file_downloader;

import themes.Dark;
import themes.Light;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame implements Runnable, ActionListener {

    private final JMenuBar menu_bar = new JMenuBar();
    private final JMenu settings = new JMenu("Settings");
    private final JMenuItem reload = new JMenuItem("Reload");
    private final JMenuItem exit = new JMenuItem("Exit");

    private JPanel main_panel;
    private JLabel theme_label;
    private final ButtonGroup group = new ButtonGroup();
    private JCheckBox dark_checkbox;
    private JCheckBox light_checkbox;
    private JCheckBox windows_LaF_checkbox;
    private JButton set_button;
    private JButton clear_button;
    private JLabel dark_img;
    private JLabel light_img;

    public Settings() {
        run();
    }

    @Override
    public void run() {
        this.setTitle("Theme Settings");
        this.setContentPane(main_panel);
        this.setJMenuBar(menu_bar);
        this.setSize(395, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        menu_items(reload, exit, exit, menu_bar, settings, exit);

        theme_label.setText("Themes");
        dark_checkbox.setText("Dark Mode");
        light_checkbox.setText("Light Mode");
        windows_LaF_checkbox.setText("Windows LaF");
        clear_button.setText("Clear");
        set_button.setText("Set Theme");

        group.add(dark_checkbox);
        group.add(light_checkbox);
        group.add(windows_LaF_checkbox);

        reload.addActionListener(this);
        exit.addActionListener(this);
        clear_button.addActionListener(this);
        set_button.addActionListener(this);


    }

    static void menu_items(JMenuItem reload, JMenuItem exit, JMenuItem jMenuItem, JMenuBar menu_bar, JMenu settings, JMenuItem exit2) {
        settings.setFont(new Font("FiraCode Nerd Font", Font.BOLD, 18));
        reload.setFont(new Font("JetBrainsMono Nerd Font", Font.BOLD, 18));
        exit.setFont(new Font("JetBrainsMono Nerd Font", Font.BOLD, 18));
        menu_bar.add(settings);

        settings.add(reload);
        settings.add(exit2);
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
            for (int i = 0; i <= 2; i++) {
                Dark dark_mode = new Dark(i);
                Light light_mode = new Light(i);
                Thread dark_theme_thread = new Thread(dark_mode);
                Thread light_theme_thread = new Thread(light_mode);
                if (dark_checkbox.isSelected()) {
                    dark_theme_thread.start();
                    Ui ui = new Ui();
                    Thread ui_thread = new Thread(ui);
                    ui_thread.start();
                    this.update(this.getGraphics());
                }

                if (light_checkbox.isSelected()) {
                    light_theme_thread.start();
                    new Ui();
                    this.repaint();
                }
            }
        }
    }
    public static void main(String[] args) {
       // Dark dark_mode = new Dark();
       // dark_mode.run();
        new Settings();
    }
}


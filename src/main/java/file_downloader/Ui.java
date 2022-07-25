package file_downloader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Enumeration;

import static javax.security.auth.callback.ConfirmationCallback.INFORMATION;

public class Ui extends JFrame implements
        ActionListener, Runnable {

    private final JCheckBox[] checkboxes = new JCheckBox[6];
    private final ButtonGroup group = new ButtonGroup();
    private final ButtonGroup group_2 = new ButtonGroup();
    private final JRadioButton[] radioButtons = new JRadioButton[5];
    private JPanel main_panel;
    private JLabel file_name_label;
    private JTextField file_name_textfield;
    private JLabel link_label;
    private JTextField link_textfield;
    private JPanel fileExtensionsPanel;
    private JLabel file_type_label;
    private JComboBox<String> file_ext_combobox;
    private JCheckBox pdf_checkbox;
    private JCheckBox png_checkbox;
    private JCheckBox docx_checkbox;
    private JCheckBox jpg_checkbox;
    private JLabel empty_space_label;
    private JLabel directories_label;
    private JPanel directories_panel;
    private JLabel empty_space_label2;
    private JRadioButton desktop_radiobutton;
    private JRadioButton downloads_radiobutton;
    private JRadioButton onedrive_radiobutton;
    private JRadioButton documents_radiobutton;
    private JRadioButton pictures_radiobutton;
    private JRadioButton custom_radiobutton;
    private JButton download_button;
    private JCheckBox _exe_checkbox;
    private JCheckBox _dmg_checkbox;

    private final JMenuBar menu_bar = new JMenuBar();
    private final JMenu settings = new JMenu("Settings");
    private final JMenuItem reload = new JMenuItem("Reload");
    private final JMenuItem themes = new JMenuItem("Themes");
    private final JMenuItem exit = new JMenuItem("Exit");
    String os_name = System.getProperty("os.name").toLowerCase();
    boolean is_windows = os_name.contains("windows");
    boolean is_mac = os_name.contains("mac");
    boolean is_linux = os_name.contains("linux");
    public String os;
    OsIdentifier os_identifier;

    @Override
    public void run() {
        this.setTitle("File Downloader");
        this.setContentPane(main_panel);
        this.setJMenuBar(menu_bar);
        this.setSize(500, 485);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        settings.setFont(new Font("FiraCode Nerd Font", Font.BOLD, 20));
        Settings.menu_items(reload, themes, exit, menu_bar, settings, themes);
        settings.addSeparator();
        settings.add(exit);

       settings.setToolTipText(
               "<html><ul>" +
                       "<li>" +
                            "<h3>Drop Settings Menu ALT+F</h3>" +
                       "</li>" +
                       "<li>" +
                            "<h3>Reload CTRL+R</h3>" +
                       "</li>" +
                       "<li>" +
                       "<h3>Themes CTRL+T</h3>" +
                       "</li>" +
                       "<li>" +
                            "<h3>Exit CTRL+E</h3>" +
                       "</li>" +
               "</ul></html>");
        reload.setToolTipText("<html><h3>Reload settings</h3></html>");
        themes.setToolTipText("<html><h3>Change theme</h3></html>");
        exit.setToolTipText("<html><h3>Exit</h3></html>");

        // shortcuts
        settings.setMnemonic('S');
        reload.setAccelerator(KeyStroke.getKeyStroke('R', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        themes.setAccelerator(KeyStroke.getKeyStroke('T', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        exit.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));



        file_name_label.setText("File Name");
        file_name_textfield.putClientProperty("JComponent.roundRect", true);
        fileExtensionsPanel: {
            file_type_label.setText("File Type");
            file_ext_combobox.putClientProperty("JComponent.roundRect", true);
            pdf_checkbox.setText("pdf");
            docx_checkbox.setText("docx");
            jpg_checkbox.setText("jpg");
            png_checkbox.setText("png");
            _exe_checkbox.setText("exe");
            _dmg_checkbox.setText("dmg");
            file_ext_combobox.addItem("java");
            file_ext_combobox.addItem("py");
            file_ext_combobox.addItem("cpp");
            file_ext_combobox.addItem("c");
            file_ext_combobox.addItem("js");
            file_ext_combobox.addItem("html");
            file_ext_combobox.addItem("css");
            group.add(pdf_checkbox);
            group.add(docx_checkbox);
            group.add(jpg_checkbox);
            group.add(png_checkbox);
            group.add(_exe_checkbox);
            group.add(_dmg_checkbox);

            checkboxes[0] = pdf_checkbox;
            checkboxes[1] = docx_checkbox;
            checkboxes[2] = jpg_checkbox;
            checkboxes[3] = png_checkbox;
            checkboxes[4] = _exe_checkbox;
            checkboxes[5] = _dmg_checkbox;
            for (int i = 0; i < 6; i++) {
                checkboxes[i].addActionListener(this);
            }

            os = System.getProperty("os.name").toLowerCase();
            os_identifier = new OsIdentifier(os);
            if (os_identifier.is_windows()) {
                System.out.println(os_identifier.getOs_name());
                _dmg_checkbox.setVisible(false);
            } else if (os_identifier.is_mac() || os_identifier.is_linux()) {
                System.out.println(os_identifier.getOs_name());
                _exe_checkbox.setVisible(false);
            }

            link_label.setText("Enter Link");
            link_textfield.putClientProperty("JComponent.roundRect", true);

            directories_label.setText("Directories");
            directories_panel: {
                desktop_radiobutton.setText("Desktop");
                downloads_radiobutton.setText("Downloads");
                onedrive_radiobutton.setText("OneDrive");
                documents_radiobutton.setText("Documents");
                pictures_radiobutton.setText("Pictures");
                custom_radiobutton.setText("Custom");
                group_2.add(desktop_radiobutton);
                group_2.add(downloads_radiobutton);
                group_2.add(onedrive_radiobutton);
                group_2.add(documents_radiobutton);
                group_2.add(pictures_radiobutton);
                group_2.add(custom_radiobutton);
                radioButtons[0] = desktop_radiobutton;
                radioButtons[1] = downloads_radiobutton;
                radioButtons[2] = onedrive_radiobutton;
                radioButtons[3] = documents_radiobutton;
                radioButtons[4] = pictures_radiobutton;
                for (int i = 0; i < 5; i++) {
                    radioButtons[i].addActionListener(this);
                }
                custom_radiobutton.addActionListener(this);

            }

            download_button.setText("Download");
            download_button.putClientProperty("JButton.buttonType", "roundRect");
            download_button.addActionListener(this);
            themes.addActionListener(this);
            reload.addActionListener(this);
            exit.addActionListener(this);

            download_button.setEnabled(false);

        }
    }

    /**
     * <p>
     *     <h2>
     *          This method is used to check if the user
     *          has selected a checkbox or a radiobutton if
     *          that's the case then enable the download button.
     *     </h2>
     * </p>
     *
     */
    private void download_btn_enabler() {
        // check if the download button is clicked
        Enumeration<AbstractButton> checked = group.getElements();
        Enumeration<AbstractButton> checked2 = group_2.getElements();
        do {
            for (int i = 0; i < 6; i++) {
                checkboxes[i] = (JCheckBox) checked.nextElement();
                if (checkboxes[i].isSelected()) {
                    download_button.setEnabled(true);
                    getRootPane().setDefaultButton(download_button);
                }
            }
            for (int i = 0; i < 5; i++) {
                radioButtons[i] = (JRadioButton) checked2.nextElement();
                if (radioButtons[i].isSelected()) {
                    download_button.setEnabled(true);
                    getRootPane().setDefaultButton(download_button);
                }
            }
            custom_radiobutton = (JRadioButton) checked2.nextElement();
            if (custom_radiobutton.isSelected()) {
                download_button.setEnabled(true);
                getRootPane().setDefaultButton(download_button);
            }
        } while (checked.hasMoreElements() && checked2.hasMoreElements());
    }


    /**
     * <p>
     *     <h2>
     *         This method is responsible for getting the directory and
     *         downloading the file.
     *     </h2>
     * </p>
     *
     */
    public void download() {
        String get_link = link_textfield.getText();
        String get_file_name = file_name_textfield.getText();
        String file_type = "";

        // loop through checkboxes to get file type
        for (JCheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                file_type = checkbox.getText();
            }
        }

        if (os_identifier.isMacOrLinux(file_name_textfield.getText().isEmpty(), link_textfield.getText().isEmpty())) {
            UIManager.put("OptionPane.messageFont", new Font("JetBrainsMono Nerd Font Mono", Font.BOLD, 25));
            JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String[] dirs = new String[5];
        // get the directories

        String desktop = "";
        String documents = "";
        String downloads = "";
        String pictures = "";
        String onedrive = "";
        if (os_identifier.is_windows()) {
            desktop = System.getProperty("user.home") + "\\Desktop\\";
            documents = System.getProperty("user.home") + "\\Documents\\";
            downloads = System.getProperty("user.home") + "\\Downloads\\";
            pictures = System.getProperty("user.home") + "\\Pictures\\";
            onedrive = System.getProperty("user.home") + "\\OneDrive\\";
        }
        if (os_identifier.is_mac()
                || os_identifier.is_linux()) {
            desktop = System.getProperty("user.home") + "/Desktop/";
            documents = System.getProperty("user.home") + "/Documents/";
            downloads = System.getProperty("user.home") + "/Downloads/";
        }

        dirs[0] = desktop;
        dirs[1] = downloads;
        dirs[2] = onedrive;
        dirs[3] = documents;
        dirs[4] = pictures;

        for (int i = 0; i < 5; i++) {
            if (radioButtons[i].isSelected()) {
                try {
                    new Downloader(new URL(get_link), dirs[i] + get_file_name + "." + file_type);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("Directory: " + dirs[i] + " File Name: " + get_file_name + "." + file_type);
            }
        }
        if (custom_radiobutton.isSelected()) {
            // choose the directory via JFileChooser
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int return_value = fileChooser.showOpenDialog(null);
            if (return_value == JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().getPath();
                String msg = """
                           You have chosen the directory: \n\040
                             """ + path;
                UIManager.put("OptionPane.messageFont", new Font("JetBrainsMono Nerd Font Mono", Font.BOLD, 20));
                JOptionPane.showMessageDialog(null, msg, "Success", INFORMATION);
                try {
                    if (os_identifier.is_windows()) {
                        new Downloader(new URL(get_link), path + "\\" + get_file_name + "." + file_type);
                    } else if (os_identifier.is_mac()
                            || os_identifier.is_linux()) {
                        new Downloader(new URL(get_link), path + "/" + get_file_name + "." + file_type);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                String msg = """
                            Please select a directory!
                             """.indent(1);
                UIManager.put("OptionPane.messageFont", new Font("JetBrainsMono Nerd Font Mono", Font.BOLD, 25));
                JOptionPane.showMessageDialog(null, msg);
            }
        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
        if (e.getSource() == reload) {
            file_name_textfield.setText("");
            file_ext_combobox.setSelectedIndex(0);
            link_textfield.setText("");

            for (int i = 0; i < 6; i++) {
                group.clearSelection();
            }

            for (int i = 0; i < 5; i++) {
                group_2.clearSelection();
            }

            download_button.setEnabled(false);

        }

        download_btn_enabler();

        if (e.getSource() == download_button) {
            download();
        }
    }
}



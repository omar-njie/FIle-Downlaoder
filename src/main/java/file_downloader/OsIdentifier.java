package file_downloader;

public class OsIdentifier {

    private String os_name;

    public OsIdentifier(String os_name) {
        this.os_name = os_name;
    }

    public String getOs_name() {
        return System.getProperty("os.name").toLowerCase();
    }

    public void setOs_name(String os_name) {
        this.os_name = os_name;
    }

    public boolean is_windows() {
        return os_name.contains("windows");
    }

    public boolean is_mac() {
        return os_name.contains("mac");
    }

    public boolean is_linux() {
        return os_name.contains("linux");
    }

    /**
     * <h2>
     *     Prompt error message dialog box if the text-fields are not filed
     * </h2>
     * <pre>{@code
     * // This section only:
     *        if (os_identifier.isMacOrLinux(file_name_textfield.getText().isEmpty(), link_textfield.getText().isEmpty())) {
     *            UIManager.put("OptionPane.messageFont", new Font("JetBrainsMono Nerd Font Mono", Font.BOLD, 25));
     *             JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
     *         }
     *
     * }</pre>
     */
    public boolean isMacOrLinux(boolean is_mac, boolean is_linux) {
        return is_mac || is_linux;
    }

    @Override
    public String toString() {
        return "OsIdentifier{" + "os_name =" + os_name + '}';
    }
}

package themes;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerContrastIJTheme;

import javax.swing.*;

public class DefaultTheme {

        public static void default_theme() {
            try {
                UIManager.setLookAndFeel(new FlatMaterialDarkerContrastIJTheme());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

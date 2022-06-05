package factory;

import factory.dialog.Dialog;
import factory.dialog.MacDialog;
import factory.dialog.WebDialog;
import factory.dialog.WindowsDialog;

public class Application {

    private Dialog dialog;

    void initialize() throws Exception {
        String osName = System.getProperty("os.name");
        System.out.println(osName);
        switch (osName) {
            case "Windows" -> dialog = new WindowsDialog();
            case "Web" -> dialog = new WebDialog();
            case "Mac OS X" -> dialog = new MacDialog();
            default -> throw new Exception("Error! Unknown operating system.");
        }
    }

    public Dialog getDialog() {
        return dialog;
    }

    public static void main(String[] args) throws Exception {
        System.getProperties().list(System.out);
        Application app = new Application();
        app.initialize();
        app.getDialog().render();

    }
}

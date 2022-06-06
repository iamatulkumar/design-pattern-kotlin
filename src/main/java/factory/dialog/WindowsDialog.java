package factory.dialog;

import factory.button.Button;
import factory.button.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    Button createButton() {
        System.out.println("Creating windows button");
        return new WindowsButton();
    }
}

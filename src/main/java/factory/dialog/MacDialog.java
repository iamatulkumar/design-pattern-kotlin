package factory.dialog;

import factory.button.Button;
import factory.button.MacButton;
import factory.button.WindowsButton;

public class MacDialog extends Dialog {
    @Override
    Button createButton() {
        System.out.println("Creating mac button");
        return new MacButton();
    }
}

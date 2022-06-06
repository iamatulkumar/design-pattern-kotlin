package factory.dialog;

import factory.button.Button;
import factory.button.WebButton;

public class WebDialog extends Dialog {
    @Override
    Button createButton() {
        System.out.println("Creating web button");
        return new WebButton();
    }
}

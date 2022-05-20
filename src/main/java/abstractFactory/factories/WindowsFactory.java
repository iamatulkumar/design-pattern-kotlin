package abstractFactory.factories;

import abstractFactory.buttons.Button;
import abstractFactory.buttons.WindowsButton;
import abstractFactory.checkBox.CheckBox;
import abstractFactory.checkBox.WindowsCheckbox;

public class WindowsFactory implements GUIFactory{
    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckbox();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

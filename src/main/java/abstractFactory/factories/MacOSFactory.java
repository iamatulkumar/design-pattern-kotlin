package abstractFactory.factories;

import abstractFactory.buttons.Button;
import abstractFactory.buttons.MacOSButton;
import abstractFactory.checkBox.CheckBox;
import abstractFactory.checkBox.MacOSCheckbox;

public class MacOSFactory implements GUIFactory{
    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckbox();
    }

    @Override
    public Button createButton() {
        return new MacOSButton();
    }
}

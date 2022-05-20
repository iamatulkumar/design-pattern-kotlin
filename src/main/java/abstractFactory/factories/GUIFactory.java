package abstractFactory.factories;

import abstractFactory.buttons.Button;
import abstractFactory.checkBox.CheckBox;

public interface GUIFactory {
    CheckBox createCheckBox();
    Button createButton();
}

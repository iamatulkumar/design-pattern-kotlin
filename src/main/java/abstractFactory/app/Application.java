package abstractFactory.app;

import abstractFactory.buttons.Button;
import abstractFactory.buttons.WindowsButton;
import abstractFactory.checkBox.CheckBox;
import abstractFactory.factories.GUIFactory;

public class Application {

    private Button button;
    private CheckBox checkBox;


    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void paint(){
        button.paint();
        checkBox.paint();
    }
}

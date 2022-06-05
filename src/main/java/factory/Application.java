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

    /**
     Factory Method
     The Factory Method separates product construction code from the code that actually uses the product. Therefore it’s easier to extend the product construction code independently from the rest of the code


     Usage
     1. Use the Factory Method when you don’t know beforehand the exact types and dependencies of the objects your code should work with.
     2. Use the Factory Method when you want to provide users of your library or framework with a way to extend its internal components.
     3. Use the Factory Method when you want to save system resources by reusing existing objects instead of rebuilding them each time.

     Pros
     You avoid tight coupling between the creator and the concrete products.
     Single Responsibility Principle. You can move the product creation code into one place in the program, making the code easier to support.
     Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.

     Cons
     The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern.
     The best case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes.

     Evolve
     Factory Method and evolve toward Abstract Factory, Prototype, or Builder

     Java usage
     java.util.Calendar#getInstance()
     java.util.ResourceBundle#getBundle()
     java.text.NumberFormat#getInstance()

     Reference:
     https://refactoring.guru/design-patterns/factory-method

     */

    public static void main(String[] args) throws Exception {
        System.getProperties().list(System.out);
        Application app = new Application();
        app.initialize();
        app.getDialog().render();
    }
}

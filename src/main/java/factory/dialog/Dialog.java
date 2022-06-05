package factory.dialog;

import factory.button.Button;

public abstract class Dialog {

    abstract Button createButton();

    public void render() {
        // Call the factory method to create a product object.
        Button okButton = createButton();
        // Now use the product.
        okButton.onClick("closeDialog");
        okButton.render();
    }
}

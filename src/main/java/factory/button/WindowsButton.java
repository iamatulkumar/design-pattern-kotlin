package factory.button;

public class WindowsButton implements Button {

    public void render(String a, String b) {
        System.out.println("Rendering Windows button " + a + " " + b);
    }

    @Override
    public void render() {
        System.out.println("Windows button Rendering");
    }

    @Override
    public void onClick(String f) {
        System.out.println("Windows button click " + f);
    }
}

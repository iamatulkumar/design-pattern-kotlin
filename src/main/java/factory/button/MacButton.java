package factory.button;

public class MacButton implements Button {

    public void render(String a, String b) {
        System.out.println("Rendering Mac button " + a + " " + b);
    }

    @Override
    public void render() {
        System.out.println("Mac button Rendering");
    }

    @Override
    public void onClick(String f) {
        System.out.println("Mac button click " + f);
    }
}

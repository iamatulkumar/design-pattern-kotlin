package factory.button;

public class WebButton implements Button {

    public void render(String a, String b) {
        System.out.println("Rendering web button " + a + " " + b);
    }

    @Override
    public void render() {
        System.out.println("Web button Rendering");
    }

    @Override
    public void onClick(String f) {
        System.out.println("Web button click " + f);
    }
}

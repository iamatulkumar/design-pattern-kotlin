package builder;

/**
 * Link: https://en.proft.me/2016/09/25/builder-design-pattern-java-and-python/
 *
 *
 * The classes and objects participating in this pattern are:
 *
 * Builder (VehicleBuilder)
 *              specifies an abstract interface for creating parts of a Product object
 * ConcreteBuilder (MotorCycleBuilder, CarBuilder, ScooterBuilder)
 *              constructs and assembles parts of the product by implementing the Builder interface
 *              defines and keeps track of the representation it creates
 *              provides an interface for retrieving the product
 * Director (Shop)
 *              constructs an object using the Builder interface
 * Product (Vehicle)
 *              represents the complex object under construction. ConcreteBuilder builds the product's internal
 *               representation and defines the process by which it's assembled
 *              includes classes that define the constituent parts, including interfaces for assembling the parts into the final result
 */
class Car {
    private String color;

    public Car() {}

    @Override
    public String toString() {
        return "Car [color=" + color + "]";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

// the builder abstraction
interface CarBuilder {
    void setColor(String color);
    Car getResult();
}

class CarBuilderImpl implements CarBuilder {
    private Car car;

    public CarBuilderImpl() {
        car = new Car();
    }

    @Override
    public void setColor(String color) {
        car.setColor(color);
    }

    @Override
    public Car getResult() {
        return car;
    }
}

public class DirectorBuilder {
    private CarBuilder builder;

    public DirectorBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    public Car construct() {
        builder.setColor("Red");
        return builder.getResult();
    }

    public static void main(String[] args) {
        CarBuilder builder = new CarBuilderImpl();
        DirectorBuilder carBuildDirector = new DirectorBuilder(builder);
        System.out.println(carBuildDirector.construct());
    }
}

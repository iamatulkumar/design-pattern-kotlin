package abstractFactory;

import abstractFactory.app.Application;
import abstractFactory.factories.GUIFactory;
import abstractFactory.factories.MacOSFactory;
import abstractFactory.factories.WindowsFactory;


/*
Use Ful Links :
Example - https://refactoring.guru/design-patterns/abstract-factory/java/example
https://www.geeksforgeeks.org/abstract-factory-pattern/
https://www.baeldung.com/java-abstract-factory-pattern

Pros :
1. Isolation of concrete classes: The Abstract Factory pattern helps you control the classes of objects that an application creates.
Because a factory encapsulates the responsibility and the process of creating product objects, it isolates clients from implementation classes.
Clients manipulate instances through their abstract interfaces. Product class names are isolated in the implementation of the concrete factory; they do not appear in client code.
2. Exchanging Product Families easily: The class of a concrete factory appears only once in an application,
that is where it’s instantiated. This makes it easy to change the concrete factory an application uses.
It can use various product configurations simply by changing the concrete factory. Because an abstract factory creates a complete family of products,
the whole product family changes at once.
3.Promoting consistency among products: When product objects in a family are designed to work together,
it’s important that an application use objects from only one family at a time. AbstractFactory makes this easy to enforce.n.

Cons :
1. adding the new ones might be challenging.
To support the new type of objects will require changing the AbstractFactory class and all of its subclasses.
2.


When to Use Abstract Factory Pattern:
1. The client is independent of how we create and compose the objects in the system
2. The system consists of multiple families of objects, and these families are designed to be used together
    We need a run-time value to construct a particular dependency

While the pattern is great when creating predefined objects,
adding the new ones might be challenging.
To support the new type of objects will require changing the AbstractFactory class and all of its subclasses.

Difference :

1. The main difference between a “factory method” and an “abstract factory” is that the factory method is a single method, and an abstract factory is an object.
2. The factory method is just a method, it can be overridden in a subclass, whereas the abstract factory is an object that has multiple factory methods on it.
3. The Factory Method pattern uses inheritance and relies on a subclass to handle the desired object instantiation.

 */

public class Demo {

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();


    }

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("mac")){
            factory = new MacOSFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
        }

}

package structural.facade;

import java.util.Arrays;

/*

Facade Design Pattern

The Facade is a Structural Design Pattern and one of the Gang of Four design patterns.
The Facade object is used to provide a front-facing interface by masking a more complex underlying system.
The Facade may provide a limited or dedicated set of functionalities. But, the functionalities Facade provides are mainly required by the client application. So, its more caring as per client needs.
The primary purpose of the Facade is to hide complexities of a system/subsystem by providing simpler interface to deal with.
Using Facade is super-easy when we have to deal with a complex system/subsystem having lots of functionalities and different configurations.
So, Facade hides minor and inner details of any third party library, system or subsystem we should know before we deal with it.
In Java there are many features like JDBC, JPA, JAX-RS etc. which hides the minor details and provide a simpler interface in form of annotations or easier configuration to deal with.
Even our computer system's POST (power-on-self-test) procedure which runs at the time we start our system; is a good example of Facade. it checks RAM, CPU, HDD and other connected peripherals before giving control over to operating system.
Facade introduces additional layer of abstraction via Facade. So, if the sub-system changes, we need to do corresponding changes in the facade layer as well.


Facade Pattern Vs Proxy Pattern
Proxy Pattern is similar to Facade except, it provides same interface as it's service object to make complex objects interchangeable.


 */
public class Main {

	public static void main(String[] args) {
		HomeFacade home = new HomeFacade();
		System.out.println("Weekend: Enjoying with friends and family at home...");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Setting up movie...");
		home.playMovieOnNetflix("Spider-Man: Far From Home");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Preparing food...");
		home.prepareFood(Arrays.asList("Napoletana Pizza", "Margherita Pizza", "Marinara Pizza",
				"Chicago-Style Deep Dish Pizza"));
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Enjoy Movie with Meal and Drink...");
		System.out.println("Movie Completed.");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Stopping Movie...");
		home.stopMovie();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Closing Kitchen...");
		home.closeKitchen();
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Done!");
	}

}

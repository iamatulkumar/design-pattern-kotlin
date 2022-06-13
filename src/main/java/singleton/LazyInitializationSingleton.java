package singleton;

public class LazyInitializationSingleton {

    private static LazyInitializationSingleton lazyInitializationSingleton;

    private LazyInitializationSingleton(){}  //private constructor.

    public static LazyInitializationSingleton getInstance(){
        if (lazyInitializationSingleton == null){ //if there is no instance available... create new one
            lazyInitializationSingleton = new LazyInitializationSingleton();
        }

        return lazyInitializationSingleton;
    }
}

// In above Singleton class, by using reflection you can create more than one instance
// Java Reflection is a process of examining or modifying the run-time behavior of a class at run time

package singleton;

/**
 * Without volatile modifier, it’s possible for another thread in Java to see half initialized state of 
 * singleton object variable, but with volatile variable guaranteeing happens-before relationship,
 * all the write will happen on volatile sSoleInstance before any read of sSoleInstance variable.
 *
 * The volatile modifier is used to let the JVM know that a thread accessing the variable must always
 * merge its own private copy of the variable with the master copy in the memory.
 *
 * Accessing a volatile variable synchronizes all the cached copied of the variables in the main memory.
 *
 * The volatile keyword does not cache the value of the variable and always read the variable from the main memory
 *
 * Volatile can only be applied to instance variables,
 * which are of type object or private. A volatile object reference can be null.
 *
 *
 */

public class VolatileSingleton {
    private static volatile VolatileSingleton volatileSingleton;

    //private constructor.
    private VolatileSingleton(){

        //Prevent form the reflection api.
        if (volatileSingleton != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static VolatileSingleton getInstance() {
        //Double check locking pattern
        if (volatileSingleton == null) { //Check for the first time

            synchronized (VolatileSingleton.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (volatileSingleton == null) volatileSingleton = new VolatileSingleton();
            }
        }

        return volatileSingleton;
    }
}

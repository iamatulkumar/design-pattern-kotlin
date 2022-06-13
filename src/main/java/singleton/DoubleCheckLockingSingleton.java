package singleton;

/**
 * you will make the Singleton class in the synchronized block if the instance is null. So, the synchronized block will be executed only when the
 * doubleCheckLockingSingleton is null and prevent unnecessary synchronization once the instance variable is initialized
 */
public class DoubleCheckLockingSingleton {
    private static DoubleCheckLockingSingleton doubleCheckLockingSingleton;

    //private constructor.
    private DoubleCheckLockingSingleton(){

        //Prevent form the reflection api.
        if (doubleCheckLockingSingleton != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static DoubleCheckLockingSingleton getInstance() {
        //Double check locking pattern
        if (doubleCheckLockingSingleton == null) { //Check for the first time

            synchronized (DoubleCheckLockingSingleton.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (doubleCheckLockingSingleton == null) doubleCheckLockingSingleton = new DoubleCheckLockingSingleton();
            }
        }

        return doubleCheckLockingSingleton;
    }
}

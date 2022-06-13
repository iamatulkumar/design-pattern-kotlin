package singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton threadSafeSingleton;

    //private constructor.
    private ThreadSafeSingleton(){
        //Prevent form the reflection api.
//        if (threadSafeSingleton != null){
//            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
//        }
    }

    public synchronized static ThreadSafeSingleton getInstance(){
        if (threadSafeSingleton == null){ //if there is no instance available... create new one
            threadSafeSingleton = new ThreadSafeSingleton();
        }

        return threadSafeSingleton;
    }
}

//But, there are some cons of using this approach:

//Slow performance because of locking overhead.
//Unnecessary synchronization that is not required once the instance variable is initialized.
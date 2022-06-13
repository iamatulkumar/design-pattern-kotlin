package singleton;

/**
 * Objective:
 *      The purpose of the Singleton class is to control object creation, limiting the number of objects to only one.
 *      The singleton allows only one entry point to create the new instance of the class
 *      Restrict the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine.
 */

/**
 *
 * SimpleSingleton  is not thread safe not reflection safe not lazy initialize
 * LazyInitializationSingleton is lazy initialize
 * ReflectionProofSingleton  is reflection safe and lazy initialize
 * ThreadSafeSingleton
 */
public class SingletonApplication {

    public static void main(String[] args) {

/*        //Instance 1
        LazyInitializationSingleton instance1 = LazyInitializationSingleton.getInstance();

        //Instance 2
        LazyInitializationSingleton instance2 = LazyInitializationSingleton.getInstance();

        //now lets check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode());
        System.out.println("Instance 2 hash:" + instance2.hashCode());*/


/*        //Create the 1st instance
        LazyInitializationSingleton instance1 = LazyInitializationSingleton.getInstance();

        //Create 2nd instance using Java Reflection API.
        LazyInitializationSingleton instance2 = null;
        try {
            Class<LazyInitializationSingleton> clazz = LazyInitializationSingleton.class;
            java.lang.reflect.Constructor<LazyInitializationSingleton> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance2 = cons.newInstance();
        } catch (NoSuchMethodException | java.lang.reflect.InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        //now lets check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode());
        System.out.println("Instance 2 hash:" + instance2.hashCode());*/

/*        //Create the 1st instance
        ReflectionProofSingleton instance1 = ReflectionProofSingleton.getInstance();

        //Create 2nd instance using Java Reflection API.
        ReflectionProofSingleton instance2 = null;
        try {
            Class<ReflectionProofSingleton> clazz = ReflectionProofSingleton.class;
            java.lang.reflect.Constructor<ReflectionProofSingleton> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance2 = cons.newInstance();
        } catch (NoSuchMethodException | java.lang.reflect.InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        //now lets check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode());
        System.out.println("Instance 2 hash:" + instance2.hashCode());*/

        ///This is not thread safe

        /*//Thread 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                LazyInitializationSingleton instance1 = LazyInitializationSingleton.getInstance();
                System.out.println("Instance 1 hash:" + instance1.hashCode());
            }
        });

        //Thread 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LazyInitializationSingleton instance2 = LazyInitializationSingleton.getInstance();
                System.out.println("Instance 2 hash:" + instance2.hashCode());
            }
        });

        //start both the threads
        t1.start();
        t2.start();*/

        ///This is not thread safe

        //Thread 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
                System.out.println("Instance 1 hash:" + instance1.hashCode());
            }
        });

        //Thread 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance();
                System.out.println("Instance 2 hash:" + instance2.hashCode());
            }
        });

        //start both the threads
        t1.start();
        t2.start();

    }
}


//you can make your class a Singleton class that is thread, reflection and serialization safe.
// This Singleton is still not the perfect Singleton. You can violate the Singleton principle by creating more than one
// instance of the Singleton class by using cloning or using multiple class loaders

package singleton;

public class SimpleSingleton {
    private static SimpleSingleton simpleSingleton = new SimpleSingleton();

    private SimpleSingleton(){
        //Nothing
    }

    public static SimpleSingleton getInstance() {
        return simpleSingleton;
    }

}

//  Here instance is created even though client application might not be using it. This might be a considerable issue if your
//  Singleton class in creating a database connection or creating a socket. This may cause the memory leak problem
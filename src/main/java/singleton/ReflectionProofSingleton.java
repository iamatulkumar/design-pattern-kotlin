package singleton;

public class ReflectionProofSingleton {
    private static ReflectionProofSingleton reflectionProofSingleton;

    //private constructor.
    private ReflectionProofSingleton(){

        //Prevent form the reflection api.
        if (reflectionProofSingleton != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static ReflectionProofSingleton getInstance(){
        if (reflectionProofSingleton == null){ //if there is no instance available... create new one
            reflectionProofSingleton = new ReflectionProofSingleton();
        }

        return reflectionProofSingleton;
    }
}

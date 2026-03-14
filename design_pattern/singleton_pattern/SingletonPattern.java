public class SingletonPattern {

    private static volatile SingletonPattern instance;
    private String data;

    private SingletonPattern(String data){
        this.data = data;
    }

    public static SingletonPattern getInstance(String data){
        if(instance==null){
            synchronized (SingletonPattern.class){
                if(instance == null){
                    instance = new SingletonPattern(data);
                }
            }
        }
        return instance;
    }
}



// or you can use eager initialization
//
//private static final SingletonPattern instance = new SingletonPattern(data);
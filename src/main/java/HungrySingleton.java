/**
 * 饿汉
 */
public class HungrySingleton {
    private static HungrySingleton _instance = new HungrySingleton();
    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return _instance;
    }
}

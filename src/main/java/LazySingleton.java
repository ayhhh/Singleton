/**
 * 懒汉模式
 * DCL
 */
public class LazySingleton {
    /**
     * volatile： 防止指令重排序
     */
    private static volatile LazySingleton _instance;
    private LazySingleton(){

    }

    /**
     * double check
     * @return
     */
    public static LazySingleton getInstance(){
        if(_instance == null){
            synchronized (LazySingleton.class){
                if(_instance  == null){
                    _instance = new LazySingleton();
                }
            }
        }
        return _instance;
    }
}

/**
 * 静态内部类实现单例
 * 利用类加载机制
 */
public class InnerStaticClassSingleton2 {

    private InnerStaticClassSingleton2(){
        if(InnerClassHolder._instance != null){
            throw new RuntimeException("singleton object already exists");
        }

    }
    public static InnerStaticClassSingleton2 getInstance(){
        return InnerClassHolder._instance;
    }
    private static class InnerClassHolder{
        private static InnerStaticClassSingleton2 _instance = new InnerStaticClassSingleton2();
    }
}

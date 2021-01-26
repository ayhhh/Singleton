/**
 * 静态内部类实现单例
 * 利用类加载机制
 */
public class InnerStaticClassSingleton {

    private InnerStaticClassSingleton(){

    }
    public static InnerStaticClassSingleton getInstance(){
        return InnerClassHolder._instance;
    }
    private static class InnerClassHolder{
        private static InnerStaticClassSingleton _instance = new InnerStaticClassSingleton();
    }
}

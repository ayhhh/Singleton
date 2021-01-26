import java.lang.reflect.Constructor;

/**
 * 反射攻击解决方法
 * 重写构造方法来解决
 * 实质上也是利用类加载机制
 */
public class ReflectSolution {
    public static void main(String[] args) throws Exception {
        /**
         * 获取到单例对象
         */
        InnerStaticClassSingleton2 innerStaticClassInstance = InnerStaticClassSingleton2.getInstance();
        /**
         * 通过反射拿到构造方法
         */
        Constructor<? extends InnerStaticClassSingleton2> declaredConstructor3 = innerStaticClassInstance.getClass().getDeclaredConstructor();
        /**
         * 设置为可访问的
         */
        declaredConstructor3.setAccessible(true);
        /**
         * 通过反射机制拿到新实例
         */
        InnerStaticClassSingleton2 newInnerStaticClassInstance = declaredConstructor3.newInstance();
        /**
         * 比较
         */
        System.out.println(innerStaticClassInstance == newInnerStaticClassInstance);
    }
}


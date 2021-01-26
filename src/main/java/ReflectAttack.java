import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 懒汉、饿汉、静态内部类都可以使用反射机制进行攻击
 */
public class ReflectAttack {
    public static void main(String[] args) throws Exception {
        /**
         * 获取到单例对象
         */
        HungrySingleton hungryInstance = HungrySingleton.getInstance();
        LazySingleton lazyInstance = LazySingleton.getInstance();
        InnerStaticClassSingleton innerStaticClassInstance = InnerStaticClassSingleton.getInstance();
        /**
         * 通过反射拿到构造方法
         */
        Constructor<? extends HungrySingleton> declaredConstructor1 = hungryInstance.getClass().getDeclaredConstructor();
        Constructor<? extends LazySingleton> declaredConstructor2 = lazyInstance.getClass().getDeclaredConstructor();
        Constructor<? extends InnerStaticClassSingleton> declaredConstructor3 = innerStaticClassInstance.getClass().getDeclaredConstructor();
        /**
         * 设置为可访问的
         */
        declaredConstructor1.setAccessible(true);
        declaredConstructor2.setAccessible(true);
        declaredConstructor3.setAccessible(true);
        /**
         * 通过反射机制拿到新实例
         */
        HungrySingleton newHungryInstance = declaredConstructor1.newInstance();
        LazySingleton newLazyInstance = declaredConstructor2.newInstance();
        InnerStaticClassSingleton newInnerStaticClassInstance = declaredConstructor3.newInstance();
        /**
         * 比较
         */
        System.out.println(hungryInstance == newHungryInstance);
        System.out.println(lazyInstance == newLazyInstance);
        System.out.println(innerStaticClassInstance == newInnerStaticClassInstance);
    }
}

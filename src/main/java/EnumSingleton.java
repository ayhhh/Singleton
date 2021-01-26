/**
 * 枚举类型实现单例模式
 * 天然不支持反射创建对应的实例，且有自己的反序列化机制
 * 利用类加载机制保证线程安全
 */
public enum EnumSingleton {
    INSTANCE;
}

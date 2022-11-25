package prototype.withOwnInterface;

import java.util.Map;

public class TopClassCache {
    private static Map<String, TopClass> cache =
            Map.of("default", new TopClass(0, new InnerClass(0, "")));

    public static TopClass put(String key, TopClass topClass) {
        cache.put(key, topClass);
        return topClass;
    }

    public static TopClass get(String key) {
        return cache.get(key).clone();
    }
}

package singleton.thread_safe;

public final class Singleton {
    // EN: The field must be declared volatile so that double check lock would
    // work correctly.
    //
    // RU: Поле обязательно должно быть объявлено volatile, чтобы двойная
    // проверка блокировки сработала как надо.
    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        Singleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}

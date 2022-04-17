package singletonpattern;

import java.util.Objects;

public class OldSingleton {

    private volatile static OldSingleton uniqueInstance;

    private OldSingleton() {}

    public static synchronized OldSingleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (OldSingleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new OldSingleton();
                }
            }
        }
        return uniqueInstance;
    }
}

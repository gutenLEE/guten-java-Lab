package singletonpattern;

import java.util.Objects;

public class OldSingleton {

    private static OldSingleton uniqueInstance;

    private OldSingleton() {}

    public static OldSingleton getInstance() {
        return Objects.requireNonNullElseGet(uniqueInstance, OldSingleton::new);
    }
}

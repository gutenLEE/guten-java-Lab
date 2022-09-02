package oop;

public interface DoIt {

    void doSomething(int i, double x);

    int doSomethingElse(String s);

    default boolean didItWork(int i, double x, String s) {
        // Method body
        return false;
    }
}

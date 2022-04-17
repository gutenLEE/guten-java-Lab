package singletonpattern;

public class Test {

    public static void main(String[] args) {
        OldSingleton instance = OldSingleton.getInstance();
        System.out.println(instance);
        OldSingleton instance_2 = OldSingleton.getInstance();
        System.out.println(instance_2);

    }
}


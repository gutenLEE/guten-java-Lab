package singletonpattern;

public class Test {

    public static void main(String[] args) {
//        OldSingleton instance = OldSingleton.getInstance();
//        System.out.println(instance);
//        OldSingleton instance_2 = OldSingleton.getInstance();
//        System.out.println(instance_2);

        EnumSingleton uniqueSingleton = EnumSingleton.INSTANCE.getInstance();
        System.out.println("uniqueSingleton = " + uniqueSingleton.getInstance());
        EnumSingleton uniqueSingleton_2 = EnumSingleton.INSTANCE.getInstance();
        System.out.println("uniqueSingleton_2 = " + uniqueSingleton_2.getInstance());
    }
}


package adapterpattern;

public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();

        WildTurkey turkey = new WildTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("칠면조가 말하길...");
        turkey.gobble();
        turkey.fly();

        System.out.println("오리가 말하길....");
        testDuck(duck);

        System.out.println("칠면조 어댑터가가 말하길...");
        testDuck(turkeyAdapter);

        System.out.println("====================");
        DuckAdapter duckAdapter = new DuckAdapter(duck);
        testTurkey(duckAdapter);

    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

    static void testTurkey(Turkey turkey) {
        turkey.gobble();
        turkey.fly();
    }


}

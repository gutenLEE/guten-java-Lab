package refactorjsoup.builder;

/**
 * @author gutenlee
 * @since 2022/11/16
 */
public class Tester {
    public static void main(String[] args)
    {
        MkJsoupBuilder mkJsoupBuilder = new MkJsoupBuilder();
        CivilEngineer engineer = new CivilEngineer(mkJsoupBuilder);
        engineer.constructMkConnection("url");

        MkConnection conntion = mkJsoupBuilder.getConntion();
        System.out.println("conntion = " + conntion);
        conntion.hello();

    }
}

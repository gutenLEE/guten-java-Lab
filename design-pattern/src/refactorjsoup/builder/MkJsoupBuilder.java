package refactorjsoup.builder;

/**
 * @author gutenlee
 * @since 2022/11/16
 */
public class MkJsoupBuilder implements HouseBuilder {
    private MkConnection mkConnection;


    public MkJsoupBuilder()
    {
        this.mkConnection = new MkConnection();
    }

    public void buildMethod()
    {
        mkConnection.setMethod("GET");
    }

    @Override
    public void buildUrl(String url) {
        mkConnection.setUrl(url);
    }

    public MkConnection getConntion()
    {
        return this.mkConnection;
    }


}

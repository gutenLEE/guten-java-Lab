package refactorjsoup.builder;

/**
 * @author gutenlee
 * @since 2022/11/16
 */
public class TipHouseBuilder implements HouseBuilder {
    private MkConnection mkConnection;

    public TipHouseBuilder()
    {
        this.mkConnection = new MkConnection();
    }

    public void buildMethod()
    {
        mkConnection.setMethod("Wooden Poles");
    }

    public void buildCookie()
    {
        mkConnection.setTimeout("Wood and Ice");
    }


    @Override
    public void buildUrl(String url) {
        mkConnection.setUrl(url);
    }

    public void buildRoof()
    {
        mkConnection.setUserAgent("Wood, caribou and seal skins");
    }

    public MkConnection getConntion()
    {
        return this.mkConnection;
    }
}

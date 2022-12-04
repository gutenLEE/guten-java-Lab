package refactorjsoup.builder;

/**
 * @author gutenlee
 * @since 2022/11/16
 */
public class CivilEngineer {
    private final HouseBuilder houseBuilder;

    public CivilEngineer(HouseBuilder houseBuilder)
    {
        this.houseBuilder = houseBuilder;
    }

    public void constructMkConnection(String url)
    {
        this.houseBuilder.buildUrl(url);
        this.houseBuilder.buildMethod();
    }

    public void constructComConnection(String url) {
        this.houseBuilder.buildUrl(url);
        this.houseBuilder.buildMethod();
    }

}

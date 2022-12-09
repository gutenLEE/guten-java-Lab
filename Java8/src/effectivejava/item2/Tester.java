package effectivejava.item2;

/**
 * @author gutenlee
 * @since 2022/12/09
 */
public class Tester {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(3, 3)
                .calories(2345)
                .carbohydrate(234)
                .fat(12)
                .build();
    }
}

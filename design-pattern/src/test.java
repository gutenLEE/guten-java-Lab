import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;

public class test {
    public static void main(String[] args) {

        //BigDecimal multiply = new BigDecimal("9532951007").multiply(new BigDecimal("1058.88"));
        //System.out.println(new BigDecimal("1058.88"));

        System.out.println(new BigDecimal("9532951007"));
        System.out.println(new BigDecimal("10.5888"));
        BigDecimal add = new BigDecimal("9532951007").multiply(BigDecimal.valueOf(10.5888)).setScale(0, RoundingMode.HALF_UP);
        System.out.println("add = " + add);

        int result = LocalDate.of(2022, 2, 1).lengthOfMonth();
        System.out.println("result = " + result);
        LocalDate localDate = LocalDate.of(2022, 12, result).minusMonths(11);
        System.out.println(LocalDate.of(localDate.getYear(), localDate.getMonthValue(), 1));
    }
}

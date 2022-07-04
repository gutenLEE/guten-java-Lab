package chap10;

import org.junit.jupiter.api.Test;
import org.mockito.cglib.core.Local;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author gutenlee
 * @since 2022/06/29
 */
public class BeCareful {

    @Test
    void dateFormat() throws Exception {
        LocalDate localDate = LocalDate.of(1945, 8, 25);
        String strDate = fromDate(localDate);

        // 변수나 필드를 사용해서 기댓값 표현하지 않기
        assertEquals(localDate.getYear() + "년 " +
                localDate.getMonthValue() + "월 " +
                localDate.getDayOfMonth() + "일", strDate);

        // 개선
        // -> 복잡하지 않고 기대하는 값도 명확하게 표현하고 있따.
        assertEquals("1945년 8월 25일", strDate);

    }

    private String fromDate(LocalDate localDate){
        Date date = Date.valueOf(localDate);
        SimpleDateFormat simple = new SimpleDateFormat("yyyy년 M월 dd일");
        String format = simple.format(date);
        return format;
    }


}

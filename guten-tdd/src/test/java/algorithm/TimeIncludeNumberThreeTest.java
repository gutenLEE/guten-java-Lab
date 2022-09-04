package algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 이것이 코딩테스트다 - 시각 113p
 * @author gutenlee
 * @since 2022/09/04
 */
public class TimeIncludeNumberThreeTest {
    /**
     * 정수 N이 입력되면 00시00분00초 ~ N시59분59초까지의 모든 시각 중에서 3이 하나라도 포함되는
     * 모든 경우의 수를 구하는 프로그램을 작성하시오.
     *
     * 기능
     *  - 문자열이 3을 포함하고 있는가
     *  - 입력값 시간 범위 생성
     */

    @Test
    void createTime() throws Exception {
        TimeIncludeNumberThree time = new TimeIncludeNumberThree(3);
        assertThat(time.getHour()).isEqualTo(3);
        assertThat(time.getMinutes()).isEqualTo(59);
        assertThat(time.getSeconds()).isEqualTo(59);
    }

    @Test
    void include_3() throws Exception {
        TimeIncludeNumberThree time = new TimeIncludeNumberThree(5);
        assertThat(time.countIfInclude_3()).isEqualTo(11475);
    }


}

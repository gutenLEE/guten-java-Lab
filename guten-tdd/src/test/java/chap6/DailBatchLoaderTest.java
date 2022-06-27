package chap6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

class DailBatchLoaderTest {

    private Times mockTimes = Mockito.mock(Times.class);

    private final DailyBatchLoader loader = new DailyBatchLoader();

    @BeforeEach
    void setUp() {
        loader.setBasePath("src/test/resources");
        loader.setTimes(mockTimes);
    }

    @Test
    void loadCount() throws Exception {
        given(mockTimes.today()).willReturn(LocalDate.of(2022, 6, 28));

        int ret = loader.load();
        assertThat(ret).isEqualTo(3);
    }


}
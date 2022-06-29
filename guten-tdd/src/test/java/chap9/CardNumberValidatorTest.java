package chap9;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

/**
 * @author gutenlee
 * @since 2022/06/29
 */
public class CardNumberValidatorTest {

    private WireMockServer wireMockServer;

    @BeforeEach
    void setUp() {
        // 테스트 실행 전에 wireMockServer를 시작하면, 실제 http 서버가 뜬다.
        wireMockServer = new WireMockServer(options().port(8089));
        wireMockServer.start();
    }

    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void valid() throws Exception {
        wireMockServer.stubFor(post(urlEqualTo("/card"))
                .withRequestBody(equalTo("12341234"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain").withBody("ok")));

    }
//

}

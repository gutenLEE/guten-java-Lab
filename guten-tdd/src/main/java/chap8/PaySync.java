package chap8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gutenlee
 * @since 2022/06/20
 */
public class PaySync {

    private PayInfoDao payInfoDao = new PayInfoDao(); // 의존 대상을 직접 생성하고 있음

    public void sync() throws IOException {

        Path path = Paths.get("D://data//pay//cp00001.csv"); // 하드 코딩된 파일 경로. 파일 경로가 반드시 유효해야만 테스트 진행 가능.
        List<PayInfo> payInfos = Files.lines(path)
                .map(line -> {
                    String[] data = line.split(",");
                    PayInfo payInfo = new PayInfo(data[0], data[1], Integer.parseInt(data[2]));
                    return payInfo;
                })
                .collect(Collectors.toList());
        payInfos.forEach(pi -> payInfoDao.insert(pi));

    }

}

package chap6;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author gutenlee
 * @since 2022/06/28
 */
public class DailBatchLoader {
    private String basePath = "";

    public int load(){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Path basicPath = Paths.get(basePath, date.format(formatter), "batch.txt");
        return 1;
    }

}

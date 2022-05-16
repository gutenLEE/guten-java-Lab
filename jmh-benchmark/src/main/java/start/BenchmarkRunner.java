package start;

import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;

/**
 * @author gutenlee
 * @since 2022/05/16
 */
public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
        MyState sta = new MyState();
        sta.benchmarkStringBuffer(sta);
    }

}

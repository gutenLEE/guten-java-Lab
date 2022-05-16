package start;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * @author gutenlee
 * @since 2022/05/16
 */
@State(Scope.Benchmark)
public class MyState {
    int iterations = 1000;
    String initial = "abc";
    String suffix = "def";

    @Benchmark
    public StringBuffer benchmarkStringBuffer(MyState state) {
        StringBuffer stringBuffer = new StringBuffer(state.initial);
        stringBuffer.append(String.valueOf(state.suffix).repeat(Math.max(0, state.iterations)));
        return stringBuffer;
    }
}

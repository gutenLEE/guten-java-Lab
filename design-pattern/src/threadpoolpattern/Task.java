package threadpoolpattern;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gutenlee
 * @since 2022/07/12
 */
public abstract class Task {
    private AtomicInteger ID_GENERATOR = new AtomicInteger();
    private int id;
    private int timeMS;

    public Task(int timeMS) {
        this.timeMS = timeMS;
    }

    public int getId() {
        return id;
    }

    public int getTimeMS() {
        return timeMS;
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID_GENERATOR=" + ID_GENERATOR +
                ", id=" + id +
                ", timeMS=" + timeMS +
                '}';
    }
}

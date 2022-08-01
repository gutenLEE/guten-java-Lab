package threadpoolpattern;

import lombok.extern.slf4j.Slf4j;



/**
 * @author gutenlee
 * @since 2022/07/12
 */
public class Worker implements Runnable {

    private final Task task;

    public Worker(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        String log = String.format("%s processing %s", Thread.currentThread().getName(), task.toString());
        System.out.println("log = " + log);
    }
}

package strategypattern.sample;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author gutenlee
 * @since 2022/07/19
 */
public class Wizard {

    private final Deque<Runnable> undoStack = new LinkedList<>();
    private final Deque<Runnable> redoStack = new LinkedList<>();

    /**
     * Cast spell.
     */
    public void castSpell(Runnable runnable) {
        runnable.run();
        undoStack.offerLast(runnable);
    }

    /**
     * Undo last spell.
     */
    public void undoLastSpell() {
        if (!undoStack.isEmpty()) {
            var previousSpell = undoStack.pollLast();
            redoStack.offerLast(previousSpell);
            previousSpell.run();
        }
    }

    /**
     * Redo last spell.
     */
    public void redoLastSpell() {
        if (!redoStack.isEmpty()) {
            var previousSpell = redoStack.pollLast();
            undoStack.offerLast(previousSpell);
            previousSpell.run();
        }
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}

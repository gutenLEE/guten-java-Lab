package strategypattern.sample;


import lombok.Data;
import lombok.Getter;

/**
 * @author gutenlee
 * @since 2022/07/19
 */
@Data
public abstract class Target {

    private Size size;

    private Visibility visibility;

    /**
     * Print status.
     */
    public void printStatus() {
        String format = String.format("%s, [size=%s] [visibility=%s]", this, getSize(), getVisibility());
        System.out.println(format);
    }

    /**
     * Changes the size of the target.
     */
    public void changeSize() {
        var oldSize = getSize() == Size.NORMAL ? Size.SMALL : Size.NORMAL;
        setSize(oldSize);
    }

    /**
     * Changes the visibility of the target.
     */
    public void changeVisibility() {
        var visible = getVisibility() == Visibility.INVISIBLE
                ? Visibility.VISIBLE : Visibility.INVISIBLE;
        setVisibility(visible);
    }
}

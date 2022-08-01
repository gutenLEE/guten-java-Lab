package strategypattern.sample;

import lombok.RequiredArgsConstructor;

/**
 * @author gutenlee
 * @since 2022/07/19
 */
@RequiredArgsConstructor
enum Size {

    SMALL("small"),
    NORMAL("normal");

    private final String title;

    @Override
    public String toString() {
        return title;
    }
}

package effectivejava.Item16;

/**
 * @author gutenlee
 * @since 2022/12/20
 */
public class TopLevelClass {
    void accessMembers(OuterClass outer) {
        // Compiler error: Cannot make a static reference to the non-static
        //     field OuterClass.outerField
        // System.out.println(OuterClass.outerField);

        System.out.println(outer.outerField);
        System.out.println(OuterClass.staticOuterField);
    }
}

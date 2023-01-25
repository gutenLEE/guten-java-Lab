package effectivejava.item20;

/**
 * @author gutenlee
 * @since 2023/01/25
 */
abstract class GraphicObject implements GraphicInterface {
    // wholly shared by all subclasses
    int x, y;
    void moveTo(int newX, int newY) {

    }

    abstract void draw();
    abstract void resize();
}

package effectivejava.item17;

import java.util.Objects;

/**
 * 불변 클래스
 * @author gutenlee
 * @since 2023/01/04
 */
public final class ImmutableClass {

    private String fieldA;
    private final String fieldB;

    private final MutableObject mutableObject;

    public ImmutableClass(String fieldA, String fieldB, MutableObject mutableObject) {
        this.fieldA = fieldA;
        this.fieldB = fieldB;
        this.mutableObject = mutableObject;
    }

    public void setFieldA(String value) {
        this.fieldA = value;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "fieldA='" + fieldA + '\'' +
                ", fieldB='" + fieldB + '\'' +
                ", mutableObject=" + mutableObject +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableClass that = (ImmutableClass) o;
        return Objects.equals(fieldA, that.fieldA) && Objects.equals(fieldB, that.fieldB) && Objects.equals(mutableObject, that.mutableObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldA, fieldB, mutableObject);
    }
}

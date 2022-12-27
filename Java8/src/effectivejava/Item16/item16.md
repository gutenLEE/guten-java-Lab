중첩 클래스

클래스 내에 존재하는 클래스
- 종류
  - non-static (inner class) 
    - local classes
    - anonymous classes
  - static
  - 
중첩 클래스는 둘러싼 클래스의 멤버임
  - non-static 클래스 (inner class)는 둘러싼 클래스의 필드(private 포함)에 접근할 수 있음
  - 논스태틱 클래스는 둘러싼 클래스의 **멤버**이므로 private, public, protected, package-private 접근제한자 선언 가능
  - static 중첩 클래스는 둘러싼 클래스의 필드에 접근할 수 없음.

왜 중첩클래스를 사용하나?
1. 클래스들을 논리적인 그룹화가 가능함.
   1. 어떤 클래스가 특정 클래스만을 위해 존재한다면 사용된다면 그 클래스 내부에 함께 둘수있음.
2. 캡슐화를 증대시킴 - A, B 탑레벨 클래스가 있을때, B클래스를 A 클래스 내부로 숨기면 A 클래스의 필드를 Private으로 선언할 수 있음. 그리고 B가 이 필드에 접근할 수 있고, 외부는 B 클래스의₩존재에 대해 모르게 할 수 있음
3. 가독성 있고 지속가능한 코드로 만들 수 있음 - 탑레벨 클래스 내부에 작은 클래스를 중첩하면 코드가 사용되는 위치에 더 가깝게 배치할 수 있다.


```text
Note that a static nested class interacts with the instance members of its outer class just like any other top-level class. The static nested class StaticNestedClass can't directly access outerField because it's an instance variable of the enclosing class, OuterClass. The Java compiler generates an error at the highlighted statement:

static class StaticNestedClass {
    void accessMembers(OuterClass outer) {
       // Compiler error: Cannot make a static reference to the non-static
       //     field outerField
       System.out.println(outerField);
    }
}
To fix this error, access outerField through an object reference:

System.out.println(outer.outerField);
Similarly, the top-level class TopLevelClass can't directly access outerField either.
```

```java
public class ShadowTest {
    public int x = 0;

    class FirstLevel {

        public int x = 1;
        
        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println(this);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
            System.out.println(ShadowTest.this);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
```
위 코드에는 3개의 x 변수 존재
1. ShadowTest 필드 x
2. FirstLevel 필드 x
3. FirstLevel.methodInFirstLevel 메서드 파라미터 x -> **이 x가 FirstLevel 클래스 멤버 x를 가리고 있음**  

   그래서 methodInFirstLevel 메서드에서 변수 x를 출력해보면 메서드 파라미터 x를 참조한다.  
   FirstLevel 클래스 멤버 x를 참조하려면 this 키워드 필요하다. ```this.x```  
   ShadowTest 클래스 멤버 x를 참조하려면 this가 ShadowTest 영역의 this 임을 명시해야한다. ```ShadowTest.this.x```
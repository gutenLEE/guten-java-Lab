package studyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gutenlee
 * @since 2022/10/17
 */
public class ProxyDemo {
    interface Original {
        void originalMethod(String str);
    }

    static class OriginalImpl implements Original {
        @Override
        public void originalMethod(String str) {
            subCall();
        }

        static void subCall(){
            System.out.println("sub called");
        }
    }

    static class Handler implements InvocationHandler {
        private final Original original;

        public Handler(Original original) {
            this.original = original;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("Before Proxy");
            method.invoke(original, args);
            System.out.println("After proxy");
            return null;
        }
    }

    public static void main(String[] args) {
        OriginalImpl original = new OriginalImpl();
        Handler handler = new Handler(original);
        Original a = (Original) Proxy.newProxyInstance(
                Original.class.getClassLoader(),
                new Class[]{Original.class},
                handler
        );
        a.originalMethod("hello");
    }
}

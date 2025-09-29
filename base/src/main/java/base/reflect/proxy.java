package base.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello {
    void morning(String name);

    int sum(int a, int b);
}

/**
 * proxy
 *
 * @author relsola
 */
@Slf4j
public class proxy {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                log.info(String.valueOf(method));
                if (method.getName().equals("morning")) {
                    log.info("Good morning, " + args[0]);
                }

                if (method.getName().equals("sum")) {
                    return (Integer) args[0] + (Integer) args[1];
                }

                return null;
            }
        };

        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[]{Hello.class}, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler

        hello.morning("Bob");
        log.info("1 + 4 = {}", hello.sum(1, 4));
    }
}
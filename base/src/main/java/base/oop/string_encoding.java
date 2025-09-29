package base.oop;

import lombok.extern.slf4j.Slf4j;

import java.util.StringJoiner;

/**
 * string_encoding
 *
 * @author relsola
 */
@Slf4j
public class string_encoding {

    public static void main(String[] args) {
        String s1 = "Hello";

        String s2 = new String(new char[]{'H', 'e', 'l', 'l', 'o'});

        s2 = s2.toUpperCase();
        log.info("s1: {}, s2: {}", s1, s2);

        log.info("s1.equals(s2): {}", s1.toUpperCase().equals(s2));

        String s = "Hi %s, your score is %d!";
        log.info(s);
        log.info(s.formatted("Alice", 80));
        log.info(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));

        log.info(String.valueOf(new Mo("m0NESY", 5)));

        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        log.info(sj.toString());
    }

    static class Mo {
        String name;
        int age;

        Mo(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Mo { name = \"" + name + "\", age = " + age + " }";
        }
    }
}

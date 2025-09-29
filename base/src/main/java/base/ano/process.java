package base.ano;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
    int min() default 0;

    int max() default 255;
}


class Person {
    @Range(min = 1, max = 20)
    public String name;

    @Range(max = 10)
    public String city;
}


/**
 * process
 *
 * @author relsola
 */
@Slf4j
public class process {

    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        person.name = "woc";
        person.city = "kkxl";

        // 遍历所有Field:
        for (Field field : person.getClass().getFields()) {
            // 获取Field定义的@Range:
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                Object value = field.get(person);
                // 如果值是String:
                if (value instanceof String s) {
                    log.info(s);
                    // 判断值是否满足@Range的min/max:
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    } else {
                        log.info("Valid field: {}", field.getName());
                    }
                }
            }
        }
    }
}



package oop.oop;

import lombok.extern.slf4j.Slf4j;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

enum Weekday {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    private final String chinese;

    Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}

record Point(int x, int y) {
    public static Point of() {
        return new Point(0, 0);
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }
}

/**
 * java_bean
 *
 * @author relsola
 */
@Slf4j
public class java_bean {
    public static void main(String[] args) throws IntrospectionException {

        BeanInfo info = Introspector.getBeanInfo(Person.class);
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            log.info(pd.getName());
            log.info("  {}", pd.getReadMethod());
            log.info("  {}", pd.getWriteMethod());
        }

        Weekday day = Weekday.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            log.info("Today is {}. Work at home!", day);
        } else {
            log.info("Today is {}. Work at office!", day);
        }

        var z = Point.of();
        var p = Point.of(123, 456);
        log.info(z.toString());
        log.info(p.toString());
    }

}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
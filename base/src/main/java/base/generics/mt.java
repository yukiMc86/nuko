package base.generics;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * mt
 *
 * @author relsola
 */
@Slf4j
public class mt {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        log.info(Pair.create("second"));
    }

}


class Pair<T> {
    private final T first;
    private final T last;

    public Pair(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        first = clazz.newInstance();
        last = clazz.newInstance();
    }

    public static <K> K create(K v) throws InstantiationException, IllegalAccessException {
        Pair<String> pair = new Pair<>(String.class);
        if (v instanceof String s) {
            return (K) (pair.first + "first --> " + s);
        }
        return v;
    }

    // super 只能写不能读  extends 只能读不能写
    public static <_T> void copy(List<? super _T> dest, List<? extends _T> src) {
        for (int i = 0; i < src.size(); i++) {
            _T t = src.get(i);
            dest.add(t);
        }
    }
}

package base.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReverseList<T> implements Iterable<T> {

    private final List<T> list = new ArrayList<>();

    ReverseList(List<T> list) {
        this.list.addAll(list);
    }

    public void add(T t) {
        list.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    class ReverseIterator implements Iterator<T> {
        int index;

        ReverseIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReverseList.this.list.get(index);
        }
    }
}

/**
 * coll
 *
 * @author relsola
 */
@Slf4j
public class coll {

    public static void main(String[] args) {

        for (var i : List.of(12, 34, 56).toArray(Integer[]::new)) log.info(i.toString());

        for (var i : new ReverseList(List.of("A", "B", "C"))) log.info((String) i);
    }

}

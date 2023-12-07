package Task_4;

import java.util.Iterator;

public class DoubleIterator<T> implements Iterator<T> {
    public Iterator<T> first;
    public Iterator<T> second;
    public boolean switchIterator = false;

    public DoubleIterator(Iterator<T> first, Iterator<T> second) {
        this.first = first;
        this.second = second;
        this.switchIterator = false;
    }

    @Override
    public boolean hasNext() {
        if (!switchIterator && first.hasNext())
            return true;
        return second.hasNext();
    }
    
    @Override
    public T next() {
        if (!switchIterator && first.hasNext()) {
            return first.next();
        }
        return second.next();
    }
}
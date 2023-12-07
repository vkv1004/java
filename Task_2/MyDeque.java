package Task_2;

import java.util.NoSuchElementException;
import java.util.Stack;
import interfaces.Deque;

public class MyDeque<T> implements Deque<T> {
    private Stack<T> firstStack = new Stack<>();
    private Stack<T> secondStack = new Stack<>();

    @Override
    public void addFirst(T el) {
        firstStack.push(el);
    }

    @Override
    public void addLast(T el) {
        while (firstStack.size() != 0) {
            secondStack.push(firstStack.pop());
        }
        secondStack.push(el);
        while (secondStack.size() != 0) {
            firstStack.push(secondStack.pop());
        }
    }

    @Override
    public T removeFirst() {
        if (firstStack.size() == 0) {
            throw new NoSuchElementException();
        } else {
            return firstStack.pop();
        }
    }

    @Override
    public T removeLast() {
        if (firstStack.size() == 0) {
            throw new NoSuchElementException();
        } else {
            while (firstStack.size() != 0) {
                secondStack.push(firstStack.pop());
            }
            T last = secondStack.pop();
            while (secondStack.size() != 0) {
                firstStack.push(secondStack.pop());
            }
            return last;
        }
    }

    @Override
    public T peekFirst() {
        return firstStack.peek();
    }

    @Override
    public T peekLast() {
        while (firstStack.size() != 0) {
            secondStack.push(firstStack.pop());
        }
        T last = secondStack.peek();
        while (secondStack.size() != 0) {
            firstStack.push(secondStack.pop());
        }
        return last;
    }

    @Override
    public boolean isEmpty() {
        return firstStack.isEmpty();
    }

    @Override
    public int size() {
        return firstStack.size();
    }

    @Override
    public void printDeque() {
        while (firstStack.size() != 0) {
            secondStack.push(firstStack.pop());
        }
        while (secondStack.size() != 0) {
            T tmp = secondStack.pop();
            firstStack.push(tmp);
            System.out.print(tmp + " ");
        }
        System.out.println();
    }
}
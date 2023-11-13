package Task_1;

import interfaces.List;

public class MyLinkedList<E> implements List<E>, Iterable<E> {
    public Node<E> head;
    public Node<E> tail;
    public int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public static class Node<T> {
        public T element;
        public Node<T> prev;
        public Node<T> next;

        public Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public void add(E el) {
        Node<E> newNode = new Node<>(el, tail, null);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E el) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            insertHead(el);
        } else if (index == size) {
            add(el);
        } else {
            Node<E> currentNode = getNode(index);
            Node<E> newNode = new Node<>(el, currentNode.prev, currentNode);
            currentNode.prev.next = newNode;
            currentNode.prev = newNode;
            size++;
        }
    }

    public void insertHead(E el) {
        Node<E> newNode = new Node<>(el, null, head);
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
    }

    public void printList() {
        Node<E> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.element + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public Node<E> getNode(int index) {
        Node<E> currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> currentNode = getNode(index);
        return currentNode.element;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        } else {
            Node<E> currentNode = getNode(index);
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        if (head == null) {
            return null;
        } else {
            return head.element;
        }
    }

    public E getLast() {
        if (head == null) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public MyIterator<E> iterator() {
        return new MyIterator<>(head);
    }
}

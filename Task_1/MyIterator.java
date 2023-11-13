package Task_1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import Task_1.MyLinkedList.Node;

public class MyIterator<T> implements Iterator<T> {
  public Node<T> currentNode;
  public MyIterator(Node<T> head) {
    this.currentNode = head;
  }

  @Override
  public boolean hasNext() {
    return currentNode != null && currentNode.next != null;
  }

  @Override
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    T value = currentNode.element;
    currentNode = currentNode.next;
    return value;
  }

  public boolean hasPrevious() {
    return currentNode != null && currentNode.prev != null;
  }

  public T previous() {
    if (!hasPrevious()) {
      throw new NoSuchElementException();
    }
    T value = currentNode.element;
    currentNode = currentNode.prev;
    return value;
  }
}

package imit.seminars.seminar_2;

import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SimpleBuffer<T> implements IBuffer<T>, Iterable<Node<T>> {
    private Node<T> head;
    private Node<T> tail;

    private int size;
    public SimpleBuffer() {
        head = new Node<T>();
        tail = head;
        head.setNext(tail);
        tail.setNext(null);
        size = 0;
    }
    @Override
    public void add(T element) {
        if (isEmpty()) {
            tail = new Node<>();
            head.setData(element);
            head.setNext(tail);
        } else {
            tail.setData(element);
            tail.setNext(new Node<T>());
            tail = tail.getNext();
        }
        ++size;
    }

    @Override
    public T get() {
        T data = head.getData();
        head = head.getNext();
        --size;

        return data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = new Node<>();
        tail = head;
        head.setNext(tail);
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SimpleBuffer{");

        sb.append("head=").append(head);
        sb.append(", tail=").append(tail);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new Iterator<>() {
            private Node<T> current;
            @Override
            public boolean hasNext() {
                if (current == null) {
                    current = head;
                    return Optional.ofNullable(current).isPresent();
                } else {
                    current = current.getNext();
                    return Optional.ofNullable(current).isPresent();
                }
            }
            @Override
            public Node<T> next() {
                return current.getNext();
            }
        };
    }
}

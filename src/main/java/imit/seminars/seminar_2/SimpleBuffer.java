package imit.seminars.seminar_2;

public class SimpleBuffer<T> implements IBuffer<T>
//    Iterable<T>
{
    private static class Node<T> {

        private T data;
        private Node<T> next;
        public Node() {
            data = null;
            next = null;
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }
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
            tail.setNext(new Node<T>(element));
            tail = tail.getNext();
        }
        ++size;
    }

    @Override
    public T get() {
        T data = tail.getData();
        Node<T> tmp = head;
        while (tmp.getNext() != tail) {
            tmp = tmp.getNext();
        }
        tail = tmp;
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
}

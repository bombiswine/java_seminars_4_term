package imit.seminars.seminar_2;

public class Node<T> {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("data=").append(data);
        sb.append(", next=").append(next);
        sb.append("}");
        return sb.toString();
    }
}
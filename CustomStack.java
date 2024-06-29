package dataStructure;

import java.util.NoSuchElementException;

public class CustomStack<T> {
    private Node<T> top;

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}


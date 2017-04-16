package main.utils.interfaces;

/**
 * Created by Oscar on 08/04/2017.
 */
public interface Stack {
    void push(Object o);

    Object pop();

    Object peek();

    int size();

    boolean isEmpty();

    void makeEmpty();
}

package model.adt;

import java.util.List;

import exceptions.ToyException;

public interface MyIStack<T> {
    T pop() throws ToyException;

    void push(T e);

    boolean isEmpty();

    List<T> getReversed();

}

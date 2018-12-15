package com.epam.Andriushchenko.Task3.Part1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.UnaryOperator;

public class MyUniqElemList<E> extends ArrayList<E> {

    public MyUniqElemList(Collection<? extends E> c) {
        for (Object o : c) {
            if (!contains(o)) {
                add((E) o);
            }
        }
    }

    @Override
    public E set(int index, E element) {
        checkForElementExist(element);
        return super.set(index, element);
    }

    @Override
    public boolean add(E e) {
        checkForElementExist(e);
        return super.add(e);
    }

    @Override
    public void add(int index, E element) {
        checkForElementExist(element);
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        checkForCollectionElementsExist(c);
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkForCollectionElementsExist(c);
        return super.addAll(index, c);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        throw new UnsupportedOperationException();
    }

    private void checkForElementExist(Object element) {
        if (contains(element)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkForCollectionElementsExist(Collection c) {
        for (Object o : c) {
            checkForElementExist(o);
        }
    }
}
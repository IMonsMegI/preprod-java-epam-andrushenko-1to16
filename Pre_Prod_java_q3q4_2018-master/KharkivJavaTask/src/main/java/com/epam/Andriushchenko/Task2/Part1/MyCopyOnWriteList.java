package com.epam.Andriushchenko.Task2.Part1;

import java.util.*;

public class MyCopyOnWriteList<E> implements List<E> {
    private final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elements;
    private List<Observer> obsList = new ArrayList<>();
    private boolean updObsList = false;


    public MyCopyOnWriteList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyCopyOnWriteList(int initCap) {
        if (initCap >= 0) {
            elements = new Object[initCap];
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator iterator() {
        Iterator newIterator = new MyIterator(elements, size);
        obsList.add((Observer) newIterator);
        updObsList = false;
        return newIterator;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public boolean add(Object o) {
        increaseArrayIfNeed();
        notifyAllIterators();
        elements[size++] = o;
        return true;
    }

    @Override
    public void add(int index, Object element) {
        checkIndexCorrect(index);
        increaseArrayIfNeed();
        notifyAllIterators();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection c) {
        checkNotNullCollection(c);
        notifyAllIterators();
        if (c.size() != 0) {
            Object[] a = c.toArray();
            increaseArrayIfNeed(a.length);
            System.arraycopy(a, 0, elements, size, a.length);
            size += a.length;
            return a.length != 0;
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        checkNotNullCollection(c);
        notifyAllIterators();
        if (c.size() != 0) {
            Object[] a = c.toArray();
            increaseArrayIfNeed(a.length);
            int moveElem = size - index;
            if (moveElem > 0) {
                System.arraycopy(elements, index, elements, index + a.length, moveElem);
            }
            System.arraycopy(a, 0, elements, index, a.length);
            size += a.length;
            return a.length != 0;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        notifyAllIterators();
        Object removedElem = remove(indexOf(o));
        return Objects.equals(removedElem, o);
    }

    @Override
    public E remove(int index) {
        checkIndexCorrect(index);
        notifyAllIterators();
        E removeObj = get(index);
        int moveElem = size - index - 1;
        if (moveElem > 0) {
            System.arraycopy(elements, index + 1, elements, index, moveElem);
        }
        elements[--size] = null;
        return removeObj;
    }

    @Override
    public boolean removeAll(Collection c) {
        checkNotNullCollection(c);
        notifyAllIterators();
        return removeElem(c, false);
    }

    @Override
    public void clear() {
        notifyAllIterators();
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndexCorrect(index);
        return (E) elements[index];
    }

    @Override
    public E set(int index, Object element) {
        checkIndexCorrect(index);
        notifyAllIterators();
        Object old = elements[index];
        elements[index] = element;
        return (E) old;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        checkNotNullCollection(c);
        return removeElem(c, true);
    }

    @Override
    public boolean containsAll(Collection c) {
        checkNotNullCollection(c);
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E[] toArray(Object[] a) {
        if (a.length < size) {
            return (E[]) Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return (E[]) a;
    }

    private void checkNotNullCollection(Collection c) {
        if (c == null || c.contains(null)) {
            throw new NullPointerException();
        }
    }

    private void growArray() {
        int newSize = size + (size >> 1);
        elements = Arrays.copyOf(elements, newSize);
    }

    private void growArray(int length) {
        int newSize = size + (size >> 1) + length;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void checkIndexCorrect(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArrayIfNeed() {
        if (elements.length - 1 == size) {
            growArray();
        }
    }

    private void increaseArrayIfNeed(int length) {
        if (elements.length - 1 <= size + length) {
            growArray(length);
        }
    }

    private boolean removeElem(Collection coll, boolean flagOfExist) {
        boolean modified = false;
        if (coll != null) {
            final Object[] elements = this.elements;
            int remove = 0, left = 0;
            try {
                for (; remove < size; remove++) {
                    if (coll.contains(elements[remove]) == flagOfExist) {
                        elements[left++] = elements[remove];
                    }
                }
            } finally {
                if (remove != size) {
                    System.arraycopy(elements, remove, elements, left, size - remove);
                    left += size - remove;
                }
                if (left != size) {
                    size = left;
                    modified = true;
                }
            }
        }
        return modified;
    }

    private void notifyAllIterators() {
        if (!updObsList) {
            for (Observer obs : obsList) {
                obs.updateIterator();
            }
        }
    }

    private class MyIterator implements Iterator, Observer {
        private int index;
        private Object[] elems;
        private int sizeOfElems;
        private boolean updFlag = false;

        public MyIterator(Object[] elements, int size) {
            elems = elements;
            sizeOfElems = size;
        }

        @Override
        public boolean hasNext() {
            return index < sizeOfElems;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return elems[index++];
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }


        @Override
        public void updateIterator() {
            if (!updFlag) {
                updFlag = true;
                elems = Arrays.copyOf(elements, elements.length);
            }
        }
    }
}
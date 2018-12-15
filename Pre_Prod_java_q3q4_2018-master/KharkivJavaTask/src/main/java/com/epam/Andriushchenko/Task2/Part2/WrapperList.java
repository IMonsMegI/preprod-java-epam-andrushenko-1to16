package com.epam.Andriushchenko.Task2.Part2;

import java.util.*;

public class WrapperList<E> implements List<E> {

    private List<E> unmod;
    private List<E> mod;

    public WrapperList(List unmod, List mod) {
        if (unmod == null || mod == null) {
            throw new NullPointerException();
        }
        this.unmod = unmod;
        this.mod = mod;
    }

    @Override
    public int size() {
        return unmod.size() + mod.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator iterator() {
        return new WrapperIterator();
    }


    @Override
    public Object[] toArray() {
        Object[] unmodArr = Arrays.copyOf(unmod.toArray(), size());
        System.arraycopy(mod, 0, unmodArr, unmod.size() - 1, mod.size());
        return unmodArr;
    }

    @Override
    public boolean add(Object o) {
        return mod.add((E) o);
    }

    @Override
    public void add(int index, Object element) {
        checkIndexForUnmodPartOfWrapper(index);
        mod.add(index - unmod.size(), (E) element);
    }

    @Override
    public boolean addAll(Collection c) {
        return mod.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        checkIndexForUnmodPartOfWrapper(index);
        return mod.addAll(index - unmod.size(), c);
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        checkIndexForUnmodPartOfWrapper(index);
        return mod.remove(o);
    }

    @Override
    public E remove(int index) {
        checkIndexForUnmodPartOfWrapper(index);
        return mod.remove(index - unmod.size());
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object elem : c) {
            if (unmod.contains(elem)) {
                throw new UnmodifierCollectionException("Collection cant be modifier!");
            }
        }
        return mod.removeAll(c);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        return index < unmod.size() ? unmod.get(index) : mod.get(index - unmod.size());
    }

    @Override
    public E set(int index, Object element) {
        checkIndexForUnmodPartOfWrapper(index);
        return mod.set(index - unmod.size(), (E) element);
    }

    @Override
    public int indexOf(Object o) {
        return unmod.contains(o) ? unmod.indexOf(o) : (mod.indexOf(o) != -1) ? mod.indexOf(o) + unmod.size() : -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return mod.contains(o) ? mod.lastIndexOf(o) + unmod.size() : unmod.lastIndexOf(o);
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
        if (!unmod.containsAll(c) && c.size() != unmod.size()) {
            throw new UnmodifierCollectionException("Collection cant be modifier!");
        }
        return mod.retainAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        Objects.requireNonNull(c);
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public E[] toArray(Object[] a) {
        if (a.length < size()) {
            return (E[]) Arrays.copyOf(toArray(), size(), a.getClass());
        }
        System.arraycopy(toArray(), 0, a, 0, size());
        if (a.length > size()) {
            a[size()] = null;
        }
        return (E[]) a;
    }

    private void checkIndexForUnmodPartOfWrapper(int index) {
        if (index < unmod.size()) {
            throw new UnmodifierCollectionException("Collection cant be modifier!");
        }
    }

    private class WrapperIterator implements Iterator {
        private Iterator unmodIter;
        private Iterator modIter;

        public WrapperIterator() {
            unmodIter = unmod.iterator();
            modIter = mod.iterator();
        }

        @Override
        public boolean hasNext() {
            return unmodIter.hasNext() || modIter.hasNext();
        }

        @Override
        public Object next() {
            return unmodIter.hasNext() ? unmodIter.next() : modIter.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
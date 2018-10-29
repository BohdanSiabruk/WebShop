package com.epam.preproduction.siabruk.util;

import com.epam.preproduction.siabruk.entity.Bicycle;

import java.util.*;

public class BicycleContainerSafe implements List<Bicycle> {

    private Bicycle[] bicycles;


    public BicycleContainerSafe() {

        this.bicycles = new Bicycle[0];
    }

    @Override
    public int size() {

        return bicycles.length;
    }

    @Override
    public boolean isEmpty() {

        return bicycles.length == 0;
    }

    @Override
    public boolean contains(Object o) {

        return o instanceof Bicycle && indexOf(o) != -1;
    }

    @Override
    public Iterator<Bicycle> iterator() {

        return new BicycleContainerIterator();
    }

    @Override
    public Object[] toArray() {

        return bicycles.clone();
    }

    @Override
    public <T> T[] toArray(T[] a) {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Bicycle bicycle) {

        add(size(), bicycle);
        return true;
    }

    @Override
    public boolean remove(Object o) {

        remove(indexOf(o));

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for (Object i : c.toArray()) {
            if (!this.contains(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Bicycle> c) {

        for (Bicycle d : c) {
            add(d);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Bicycle> c) {
        for (Bicycle d : c) {
            add(index++, d);
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        for (Object d : c) {
            if (contains(d)) {
                remove(indexOf(d));
            }
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        for (Object d : c) {
            if (!contains(d)) {
                remove(d);
            }
        }

        return true;
    }

    @Override
    public void clear() {

        bicycles = new Bicycle[0];
    }

    @Override
    public Bicycle get(int index) {

        return bicycles[index];
    }

    @Override
    public Bicycle set(int index, Bicycle element) {

        Bicycle[] copyBicycle = new Bicycle[bicycles.length];
        System.arraycopy(bicycles, 0, copyBicycle, 0, bicycles.length);
        copyBicycle[index] = element;
        bicycles = copyBicycle;

        return copyBicycle[index];
    }

    @Override
    public void add(int index, Bicycle bicycle) {

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }

        Bicycle[] newElements;

        int numMoved = size() - index;
        if (numMoved == 0) {
            newElements = Arrays.copyOf(bicycles, size() + 1);
        } else {
            newElements = new Bicycle[size() + 1];
            System.arraycopy(bicycles, 0, newElements, 0, index);
            System.arraycopy(bicycles, index, newElements, index + 1, numMoved);
        }

        newElements[index] = bicycle;

        this.bicycles = newElements;
    }

    @Override
    public Bicycle remove(int index) {

        if (index > bicycles.length || index < 0) {
            throw new IndexOutOfBoundsException("this element is not correct");
        }

        Bicycle[] copyBicycles = new Bicycle[bicycles.length - 1];

        System.arraycopy(bicycles, 0, copyBicycles, 0, copyBicycles.length);

        Bicycle c = bicycles[index];
        for (int i = index + 1; i < copyBicycles.length; i++) {
            copyBicycles[i - 1] = copyBicycles[i];
        }

        bicycles = copyBicycles;

        return c;
    }

    @Override
    public int indexOf(Object o) {

        int index = -1;
        for (int i = 0; i < bicycles.length; i++) {
            if (o.equals(bicycles[i])) index = i;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {

        int index = -1;
        for (int i = bicycles.length; i >= 0; i--) {
            if (o.equals(bicycles[i])) index = i;
        }
        return index;
    }

    @Override
    public ListIterator<Bicycle> listIterator() {

        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<Bicycle> listIterator(int index) {

        throw new UnsupportedOperationException();
    }

    @Override
    public List<Bicycle> subList(int fromIndex, int toIndex) {

        throw new UnsupportedOperationException();
    }

    private class BicycleContainerIterator implements Iterator<Bicycle> {

        private int cursor;
        private Bicycle last;

        public BicycleContainerIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < bicycles.length;
        }

        @Override
        public Bicycle next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            this.last = bicycles[cursor++];
            return this.last;
        }
    }
}

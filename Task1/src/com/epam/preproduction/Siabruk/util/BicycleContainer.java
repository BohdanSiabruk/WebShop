package com.epam.preproduction.Siabruk.util;

import com.epam.preproduction.Siabruk.entity.Bicycle;

import java.util.*;
import java.util.function.Predicate;

public class BicycleContainer implements List<Bicycle> {

    private static final int INITIAL_CAPACITY = 10;
    private Bicycle[] bicycles;
    private int size;
    private int capacity;

    public BicycleContainer() {
        this.capacity = INITIAL_CAPACITY;
        this.bicycles = new Bicycle[this.capacity];
        this.size = 0;
    }

    public Bicycle[] getBicycles() {
        return bicycles;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }


    private void reallocate() {
        this.capacity = capacity * 2;
        this.bicycles = Arrays.copyOf(this.bicycles, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return o instanceof Bicycle && indexOf(o) != -1;
    }

    @Override
    public Iterator<Bicycle> iterator() {
        return new BicycleContainerIterator(b -> b != null);
    }

    public Iterator<Bicycle> iterator(Predicate<Bicycle> predicate) {
        return new BicycleContainerIterator(predicate);
    }

    @Override
    public Bicycle[] toArray() {
        return Arrays.copyOf(bicycles, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Bicycle bicycle) {
        if (size == capacity) {
            reallocate();
        }

        bicycles[size++] = bicycle;

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
        boolean addAll = false;

        for (Bicycle o : c) {
            add(o);
            addAll = true;
        }

        return addAll;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Bicycle> c) {
        boolean addAll = false;

        for (Bicycle o : c) {
            add(index, o);
            index++;
            addAll = true;
        }

        return addAll;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object x : c) {
            if (contains(x)) remove(x);
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object d: c){
            if (!contains(d)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < bicycles.length; i++) {
            size = 0;
            bicycles[i] = null;
        }
    }

    @Override
    public Bicycle get(int index) {
        return bicycles[index];
    }

    @Override
    public Bicycle set(int index, Bicycle element) {
        return bicycles[index] = element;
    }

    @Override
    public void add(int index, Bicycle element) {
        if (size == capacity) {
            reallocate();
        }
        if (size > index) {
            for (int i = size; i >= index; i--) {
                bicycles[i + 1] = bicycles[i];
            }

            bicycles[index] = element;
            size++;
        } else {
            throw new IndexOutOfBoundsException("not correct index");
        }
    }

    @Override
    public Bicycle remove(int index) {
        Bicycle c = bicycles[index];
        for (int i = index + 1; i < size; i++) {
            bicycles[i - 1] = bicycles[i];
        }
        size--;

        return c;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        remove(index);
        return true;
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
        private Predicate<Bicycle> bicyclePredicate;

        public BicycleContainerIterator(Predicate<Bicycle> predicate) {
            this.cursor = 0;
            this.last = null;
            this.bicyclePredicate = bicycle -> bicycle != null && predicate.test(bicycle);
        }

        @Override
        public boolean hasNext() {
            return hasNextIndexByPredicate();
        }

        @Override
        public Bicycle next() {
            if (!hasNextIndexByPredicate()) {
                throw new IndexOutOfBoundsException();
            }

            this.last = bicycles[cursor++];
            return this.last;
        }

        private boolean hasNextIndexByPredicate() {
            boolean hasNext = true;

            while (!bicyclePredicate.test(bicycles[cursor])) {

                if (bicycles[cursor] == null || cursor == size) {
                    hasNext = false;
                    break;
                }

                cursor++;
            }

            return hasNext;
        }
    }
}

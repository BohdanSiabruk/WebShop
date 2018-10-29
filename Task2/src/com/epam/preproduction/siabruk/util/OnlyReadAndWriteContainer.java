package com.epam.preproduction.siabruk.util;

import com.epam.preproduction.siabruk.exception.NoAccessException;
import com.epam.preproduction.siabruk.entity.Bicycle;

import java.util.*;

public class OnlyReadAndWriteContainer implements List<Bicycle> {

    private final List<Bicycle> unmodifiedList;
    private List<Bicycle> modifyList;

    public OnlyReadAndWriteContainer(List<Bicycle> unmodifiedList, List<Bicycle> modifyList) {

        this.unmodifiedList = unmodifiedList;
        this.modifyList = modifyList;
    }

    @Override
    public int size() {

        return unmodifiedList.size() + modifyList.size();
    }

    @Override
    public boolean isEmpty() {

        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return (indexOf(o) != -1);
    }

    @Override
    public Iterator<Bicycle> iterator() {
        return new BicycleContainerIterator();
    }

    @Override
    public Object[] toArray() {

        return Arrays.copyOf(new Object[0], size());
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Bicycle bicycle) {
        modifyList.add(bicycle);
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

        for (Object i : c.toArray()) {
            add((Bicycle) i);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Bicycle> c) {
        if (index >= 0 && index <= size()) {
            if (condition(index)) {
                return modifyList.addAll(index - unmodifiedList.size(), c);
            } else {
                throw new NoAccessException("You attempt to add a collection to the unmodified list");
            }
        } else {
            throw new IndexOutOfBoundsException("You attempt to add a collection with an index that exceeds the length of the array");
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        for (Object d : c) {
            if ((unmodifiedList.contains(d))) {
                throw new NoAccessException("you can not remove");
            } else {
                modifyList.remove(d);
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        List<Bicycle> copyList = new ArrayList<>();
        copyList.addAll(modifyList);

        if (c.containsAll(unmodifiedList)) {
            for (Bicycle d : modifyList) {
                if (!c.contains(d)) {
                    copyList.remove(d);
                }
            }
            modifyList = copyList;
            return true;
        } else {
            throw new NoAccessException("You trying retain elements from unmodifiable list");
        }
    }

    @Override
    public void clear() {

        if (unmodifiedList.isEmpty()) {
            modifyList.clear();
        } else {
            throw new NoAccessException("you can not clear!");
        }
    }

    @Override
    public Bicycle get(int index) {

        if (index < unmodifiedList.size()) {
            return unmodifiedList.get(index);
        } else {
            return modifyList.get(index - unmodifiedList.size());
        }
    }

    @Override
    public Bicycle set(int index, Bicycle element) {

        if (condition(index)) {
            return modifyList.set(index - unmodifiedList.size(), element);
        } else {
            throw new NoAccessException("can`t set");
        }
    }

    @Override
    public void add(int index, Bicycle element) {

        if (condition(index)) {
            modifyList.add(index - unmodifiedList.size(), element);
        } else {
            throw new NoAccessException("can`t add");
        }
    }

    public boolean condition(int index) {
        return index >= unmodifiedList.size();
    }

    @Override
    public Bicycle remove(int index) {

        if (index >= unmodifiedList.size()) {
            return modifyList.remove(index - unmodifiedList.size());
        } else {
            throw new NoAccessException("can`t add");
        }
    }

    @Override
    public int indexOf(Object o) {

        int index = -1;
        if (unmodifiedList.indexOf(o) != -1) {
            index = unmodifiedList.indexOf(o);
        } else {
            if (modifyList.indexOf(o) != -1) {
                index = modifyList.indexOf(o) + unmodifiedList.size();
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {

        int index = -1;
        if (unmodifiedList.lastIndexOf(o) != -1) {
            index = unmodifiedList.lastIndexOf(o);
        } else {
            if (modifyList.lastIndexOf(o) != -1) {
                index = modifyList.lastIndexOf(o) + unmodifiedList.size();
            }
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
            return cursor < size();
        }

        @Override
        public Bicycle next() {

            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            if (cursor < unmodifiedList.size() && cursor < size()) {
                this.last = unmodifiedList.get(cursor);
            } else {
                this.last = modifyList.get(cursor - unmodifiedList.size());

            }
            cursor++;

            return this.last;
        }
    }
}


package com.epam.preproduction.siabruk.container;

import java.util.ArrayList;
import java.util.Collection;

public class ListContainerUniqueBicycle<Bicycle> extends ArrayList<Bicycle> {

    @Override
    public Bicycle set(int index, Bicycle element) {

        if (!contains(element)) {
            return super.set(index, element);

        } else
            throw new IllegalArgumentException("not correct index");
    }

    @Override
    public boolean add(Bicycle e) {

        if (!contains(e)) {
            return super.add(e);
        } else {
            return false;
        }

    }

    @Override
    public void add(int index, Bicycle element) {

        if (!contains(element)) {
            super.add(index, element);
        } else {
            throw new IllegalArgumentException("this element is exist");
        }

    }

    @Override
    public boolean addAll(Collection<? extends Bicycle> c) {

        if (!containsAll(c)) {
            return super.addAll(size(), c);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends Bicycle> c) {

        for (Bicycle d : c) {
            if (contains(d)) {
                return false;
            }
        }
        return super.addAll(index, c);
    }
}

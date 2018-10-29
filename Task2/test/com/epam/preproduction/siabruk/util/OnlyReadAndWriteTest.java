package com.epam.preproduction.siabruk.util;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.entity.MountainBike;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OnlyReadAndWriteTest {

    private OnlyReadAndWriteContainer bicycleContainer;
    private List<Bicycle> unmodify;
    private List<Bicycle> modify;

    @Before
    public void beforeEach() {

        unmodify = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            unmodify.add(new MountainBike(20 + i, "black", 155 + i, 32, "rigid"));
        }

        modify = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            modify.add(new MountainBike(30 + i, "black", 155 + i, 32, "rigid"));
        }

        bicycleContainer = new OnlyReadAndWriteContainer(unmodify, modify);
    }

    @Test
    public void testIsEmpty() {

        bicycleContainer = new OnlyReadAndWriteContainer(new ArrayList<>(), new ArrayList<>());
        assertTrue(bicycleContainer.isEmpty());
    }

    @Test
    public void testClear() {

        bicycleContainer = new OnlyReadAndWriteContainer(new ArrayList<>(), modify);
        bicycleContainer.clear();

        assertTrue(bicycleContainer.isEmpty());
    }

    @Test
    public void testGet() {

        bicycleContainer = new OnlyReadAndWriteContainer(unmodify, modify);
        assertEquals(new MountainBike(20, "black", 155, 32, "rigid"), bicycleContainer.get(0));
    }

    @Test
    public void testSet() {

        bicycleContainer = new OnlyReadAndWriteContainer(modify, unmodify);
        bicycleContainer.set(6, new Bicycle(12, "dark", 343));

        assertEquals(new Bicycle(12, "dark", 343), bicycleContainer.get(6));
    }

    @Test
    public void testAdd() {

        bicycleContainer = new OnlyReadAndWriteContainer(modify, unmodify);
        bicycleContainer.add(7, new Bicycle(12, "dark", 343));

        assertEquals(new Bicycle(12, "dark", 343), bicycleContainer.get(7));
    }

    @Test
    public void testRemove() {

        bicycleContainer = new OnlyReadAndWriteContainer(unmodify, modify);
        bicycleContainer.remove(5);

        assertEquals(new MountainBike(31, "black", 156, 32, "rigid"), bicycleContainer.get(5));
    }

    @Test
    public void testIndexOf() {

        bicycleContainer = new OnlyReadAndWriteContainer(unmodify, modify);

        assertEquals(6, bicycleContainer.indexOf(new MountainBike(31, "black", 156, 32, "rigid")));
    }

    @Test
    public void testLastIndexOf() {

        bicycleContainer = new OnlyReadAndWriteContainer(unmodify, modify);
        bicycleContainer.set(8, new MountainBike(33, "black", 158, 32, "rigid"));

        assertEquals(8, bicycleContainer.lastIndexOf(new MountainBike(33, "black", 158, 32, "rigid")));
    }

    @Test
    public void testContains() {

        bicycleContainer = new OnlyReadAndWriteContainer(unmodify, modify);

        assertTrue(bicycleContainer.contains(new MountainBike(20, "black", 155, 32, "rigid")));
    }

    @Test
    public void testAddAll() {
        bicycleContainer = new OnlyReadAndWriteContainer(unmodify, modify);

        bicycleContainer.addAll(modify);

        assertEquals(13, bicycleContainer.size());
    }

    @Test
    public void testAddAllIndex() {
        bicycleContainer = new OnlyReadAndWriteContainer(unmodify, modify);

        bicycleContainer.addAll(6, modify);

        assertEquals(13, bicycleContainer.size());

    }

    @Test
    public void testRetainAll() {
        bicycleContainer = new OnlyReadAndWriteContainer(unmodify, modify);
        List<Bicycle> testList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            testList.add(new MountainBike(20 + i, "black", 155 + i, 32, "rigid"));
        }
        bicycleContainer.retainAll(testList);
        assertEquals(5, bicycleContainer.size());
    }

    @Test
    public void testRemoveAll() {

        bicycleContainer = new OnlyReadAndWriteContainer(unmodify, modify);
        List<Bicycle> testList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            testList.add(new MountainBike(30 + i, "black", 155 + i, 32, "rigid"));
        }
        bicycleContainer.removeAll(testList);

        assertEquals(7, bicycleContainer.size());
    }
}

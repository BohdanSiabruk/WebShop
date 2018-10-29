package com.epam.preproduction.siabruk.util;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.entity.MountainBike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleContainerSafeTest {

    private BicycleContainerSafe bicycleContainerSafe;
    private BicycleContainerSafe bicycles1;

    @Before
    public void beforeEach() {

        bicycleContainerSafe = new BicycleContainerSafe();

        for (int i = 0; i < 5; i++) {
            bicycleContainerSafe.add(new MountainBike(20 + i, "black", 155 + i, 32, "rigid"));

        }
        bicycles1 = new BicycleContainerSafe();
        Bicycle bicycle = new Bicycle(29, "dark", 34);
        bicycles1.add(bicycle);
        bicycles1.add(bicycle);
        bicycles1.add(bicycle);

    }

    @Test
    public void testAddObj() {

        bicycleContainerSafe = new BicycleContainerSafe();
        Bicycle bicycle = new Bicycle(29, "dark", 34);
        bicycleContainerSafe.add(bicycle);
        bicycleContainerSafe.add(bicycle);
        bicycleContainerSafe.add(bicycle);

        assertEquals(3, bicycleContainerSafe.size());
    }

    @Test
    public void testAdd() {

        MountainBike mountainBike = new MountainBike(20, "black", 155, 32, "rigid");
        bicycleContainerSafe.add(mountainBike);
        bicycleContainerSafe.add(mountainBike);


        assertEquals(mountainBike, bicycleContainerSafe.get(6));
    }

    @Test
    public void testAddIndex() {

        MountainBike mountainBike3 = new MountainBike(44, " dark", 34, 34, "sus");
        bicycleContainerSafe.add(1, mountainBike3);

        System.out.println(bicycleContainerSafe.size());
        bicycleContainerSafe.add(6, mountainBike3);

        assertEquals(mountainBike3, bicycleContainerSafe.get(6));
    }

    @Test
    public void remove() {

        bicycleContainerSafe = new BicycleContainerSafe();
        Bicycle bicycle = new Bicycle(29, "dark", 34);
        bicycleContainerSafe.add(bicycle);
        bicycleContainerSafe.add(bicycle);
        bicycleContainerSafe.add(bicycle);
        bicycleContainerSafe.add(bicycle);


        bicycleContainerSafe.remove(2);

        assertEquals(3, bicycleContainerSafe.size());

    }


    @Test
    public void testRemoveObject() {

        bicycleContainerSafe.remove(new MountainBike(20, "black", 155, 32, "rigid"));

        assertFalse("found element", bicycleContainerSafe.contains(new MountainBike(20, "black", 155, 32, "rigid")));
    }

    @Test
    public void testGet() {

        Object x = bicycleContainerSafe.get(1);

        assertEquals(new MountainBike(21, "black", 156, 32, "rigid"), x);
    }


    @Test
    public void testAddAll() {

        bicycleContainerSafe.addAll(bicycles1);

        assertEquals(8, bicycleContainerSafe.size());
    }

    @Test
    public void testAddAllToIndex() {

        BicycleContainerSafe bicycles1 = new BicycleContainerSafe();
        Bicycle bicycle = new Bicycle(29, "dark", 34);
        bicycles1.add(bicycle);
        bicycles1.add(bicycle);
        bicycles1.add(bicycle);

        bicycleContainerSafe.addAll(3, bicycles1);

        assertEquals(bicycle, bicycleContainerSafe.get(3));
    }


    @Test
    public void testRemoveAll() {

        BicycleContainerSafe newList = new BicycleContainerSafe();
        Bicycle bicycle = new Bicycle(23, "DDD", 23);
        newList.add(bicycle);
        newList.add(bicycle);

        bicycleContainerSafe.addAll(newList);
        bicycleContainerSafe.removeAll(newList);

        assertEquals(5, bicycleContainerSafe.size());
    }

    @Test
    public void testClear() {

        bicycleContainerSafe.clear();

        assertEquals(0, bicycleContainerSafe.size());
    }


}
package com.epam.preproduction.Siabruk.util;

import com.epam.preproduction.Siabruk.entity.Bicycle;
import com.epam.preproduction.Siabruk.entity.MountainBike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BicycleContainerTest {

    BicycleContainer bicycleContainer;
    BicycleContainer bicycleContainer1;
    MountainBike mountainBike;
    MountainBike mountainBike1;
    MountainBike mountainBike2;
    MountainBike mountainBike3;
    MountainBike mountainBike4;
    MountainBike mountainBike5;
    MountainBike mountainBike6;
    MountainBike mountainBike7;
    MountainBike mountainBike8;
    MountainBike mountainBike9;
    MountainBike mountainBike10;
    MountainBike mountainBike11;
    MountainBike mountainBike12;

    @Before
    public void setup() {
        mountainBike = new MountainBike(29, "red", 30, 8, "suspense");
        mountainBike1 = new MountainBike(28, "red", 30, 8, "suspense");
        mountainBike2 = new MountainBike(27, "red", 30, 8, "suspense");
        mountainBike3 = new MountainBike(26, "red", 30, 8, "suspense");
        mountainBike4 = new MountainBike(25, "red", 30, 8, "suspense");
        mountainBike5 = new MountainBike(24, "red", 30, 8, "suspense");
        mountainBike6 = new MountainBike(23, "red", 30, 8, "suspense");
        mountainBike7 = new MountainBike(22, "red", 30, 8, "suspense");
        mountainBike8 = new MountainBike(21, "red", 30, 8, "suspense");
        mountainBike9 = new MountainBike(20, "red", 30, 8, "suspense");
        mountainBike10 = new MountainBike(19, "red", 30, 8, "suspense");
        mountainBike11 = new MountainBike(18, "red", 30, 8, "suspense");
        mountainBike12 = new MountainBike(17, "red", 30, 8, "suspense");

        bicycleContainer = new BicycleContainer();
        bicycleContainer.add(mountainBike);
        bicycleContainer.add(mountainBike1);
        bicycleContainer.add(mountainBike2);
        bicycleContainer.add(mountainBike3);
        bicycleContainer.add(mountainBike4);
        bicycleContainer.add(mountainBike5);
        bicycleContainer.add(mountainBike6);
        bicycleContainer.add(mountainBike7);
        bicycleContainer.add(mountainBike8);
        bicycleContainer.add(mountainBike9);
        bicycleContainer.add(mountainBike10);
        bicycleContainer.add(mountainBike11);
        bicycleContainer.add(mountainBike12);

        bicycleContainer1 = new BicycleContainer();
        bicycleContainer1.add(mountainBike);
        bicycleContainer1.add(mountainBike1);
        bicycleContainer1.add(mountainBike2);
    }

    @Test
    public void testAdd() {

        bicycleContainer.add(mountainBike3);

        assertEquals(mountainBike3, bicycleContainer.get(13));
    }

    @Test
    public void testAddIndex() {

        bicycleContainer.add(1, mountainBike3);

        for (Bicycle d: bicycleContainer){
            System.out.println(d);
        }

        assertEquals(mountainBike3, bicycleContainer.get(1));
    }

    @Test
    public void remove() {

        bicycleContainer.remove(2);

        assertEquals(12, bicycleContainer.size());
}

    @Test
    public void testRemove() {

        bicycleContainer.remove(2);

        assertEquals(mountainBike3, bicycleContainer.get(2));
    }

    @Test
    public void testRemoveObject() {

        bicycleContainer.remove(mountainBike1);

        assertFalse("found element", bicycleContainer.contains(mountainBike1));
    }

    @Test
    public void testGet() {

        Object x = bicycleContainer.get(1);

        assertEquals(mountainBike1, x);
    }

    @Test
    public void testEqualsBicycle() {
        Bicycle bicycle1 = new Bicycle(29, "red", 28);
        Bicycle bicycle2 = new Bicycle(29, "red", 28);

        assertEquals(bicycle1, bicycle2);

    }

    @Test
    public void testEqualsBicycleNot() {
        Bicycle bicycle1 = new Bicycle(29, "red", 28);
        Bicycle bicycle3 = new Bicycle(26, "red", 28);


        assertNotEquals(bicycle1, bicycle3);
    }

    @Test
    public void testAddAll(){

        bicycleContainer.addAll(bicycleContainer1);

        assertEquals(16, bicycleContainer.size());
    }

    @Test
    public void testAddAllToIndex(){
        bicycleContainer.addAll(3, bicycleContainer1);
        for (Bicycle d : bicycleContainer) {
            System.out.println(d);
        }

        assertEquals(mountainBike, bicycleContainer.get(3));
    }

    @Test
    public void testClear(){
        bicycleContainer.clear();



        assertEquals(0, bicycleContainer.size());
    }
}
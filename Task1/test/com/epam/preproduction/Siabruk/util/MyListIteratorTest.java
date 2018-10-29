package com.epam.preproduction.Siabruk.util;

import com.epam.preproduction.Siabruk.entity.Bicycle;
import com.epam.preproduction.Siabruk.entity.MountainBike;
import com.epam.preproduction.Siabruk.util.BicycleContainer;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MyListIteratorTest {

    private Iterator<Bicycle> iterator;
    private BicycleContainer bicycles;

    @Before
    public void beforeEach() {
        bicycles = new BicycleContainer();

        for (int i = 0; i < 5; i++) {
            bicycles.add(new MountainBike(20 + i, "black", 155 + i, 32, "rigid"));
        }

        iterator = bicycles.iterator();
    }

    @Test
    public void testHasNext() {
        BicycleContainer emptyBicycles = new BicycleContainer();
        Iterator<Bicycle> emptyIterator = emptyBicycles.iterator();

        assertEquals(false, emptyIterator.hasNext());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testNext() {
        BicycleContainer emptyBicycles = new BicycleContainer();
        Iterator<Bicycle> emptyIterator = emptyBicycles.iterator();

        emptyIterator.next();
    }

    @Test
    public void testHasNextFull() {
        assertEquals(true, iterator.hasNext());
    }

    @Test
    public void testNextFull() {
        Bicycle bicycle = iterator.next();
        assertTrue(bicycle instanceof MountainBike);
    }

    @Test
    public void testFullIteration() {
        while (iterator.hasNext()) {
            Bicycle bicycle = iterator.next();
            assertNotNull(bicycle);
        }
    }

    @Test
    public void testCustomEvenIteration() {
        int countItems = 0;
        iterator = bicycles.iterator(bicycle -> bicycle.getWheelSize() % 2 == 0);

        while (iterator.hasNext()) {
            Bicycle bicycle = iterator.next();
            assertNotNull(bicycle);
            countItems++;
        }

        assertEquals(3, countItems);
    }

    @Test
    public void testCustomOddIteration() {
        int countItems = 0;
        iterator = bicycles.iterator(bicycle -> bicycle.getWheelSize() % 2 != 0);

        while (iterator.hasNext()) {
            Bicycle bicycle = iterator.next();
            assertNotNull(bicycle);
            countItems++;
        }

        assertEquals(2, countItems);
    }
}

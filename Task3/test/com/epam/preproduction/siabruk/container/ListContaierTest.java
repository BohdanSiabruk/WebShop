package com.epam.preproduction.siabruk.container;

import com.epam.preproduction.siabruk.entity.Bicycle;
import org.junit.Before;
import org.junit.*;

import static org.junit.Assert.*;

public class ListContaierTest {

    private ListContainerUniqueBicycle bicycles;
    private ListContainerUniqueBicycle bicycles1;

    private Bicycle bicycle3;

    @Before
    public void beforeEach() {
        bicycles = new ListContainerUniqueBicycle();
        bicycles1 = new ListContainerUniqueBicycle();

        Bicycle bicycle = new Bicycle(27, "red", 34);
        Bicycle bicycle1 = new Bicycle(26, "red", 34);
        Bicycle bicycle2 = new Bicycle(25, "red", 34);
        bicycle3 = new Bicycle(28, "red", 34);

        bicycles.add(bicycle);
        bicycles.add(bicycle1);
        bicycles.add(bicycle2);

        Bicycle bicycle4 = new Bicycle(28, "red", 34);
        Bicycle bicycle5 = new Bicycle(29, "red", 34);

        bicycles1.add(bicycle4);
        bicycles1.add(bicycle5);
    }

    @Test
    public void testSet() {
        bicycles.set(2, bicycle3);

        assertEquals(bicycle3, bicycles.get(2));
    }

    @Test
    public void testAdd(){
        bicycles.add(bicycle3);

        assertEquals(4, bicycles.size());
    }

    @Test
    public void testAddIndex(){
        bicycles.add(1, bicycle3);

        assertEquals(bicycle3, bicycles.get(1));
    }

    @Test
    public void testAddAll(){
        bicycles.addAll(bicycles1);

        assertEquals(5, bicycles.size());
    }

    @Test
    public void testAddAllIndex(){
        bicycles.addAll(1, bicycles1);

        assertEquals(new Bicycle(28, "red", 34), bicycles.get(1));
    }
}



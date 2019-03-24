package com.mars.rover;

import org.junit.Test;
import static org.junit.Assert.*;

public class MarsRoverTest {

    @Test
    public void testMarsRoverNavigation() throws Exception {

        Rover rover = new Rover(1, 2, "N");
        rover = NavigateMarsRover.navigateMarsRover(rover, "LMLMLMLMM");

        assertEquals(1, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals("N", rover.getDirection());


    }

    @Test
    public void testMarsRoverNavigationNewInput() throws Exception {

        Rover rover = new Rover(3, 5, "E");
        rover = NavigateMarsRover.navigateMarsRover(rover, "LLMLMMRM");

        assertEquals(1, rover.getX());
        assertEquals(3, rover.getY());
        assertEquals("W", rover.getDirection());


    }

}
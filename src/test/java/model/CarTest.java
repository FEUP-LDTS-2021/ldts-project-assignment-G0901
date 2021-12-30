package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarTest {
    @BeforeEach
    void setUp() {
        car = new Car(10, 20);
    }
    @Test
    public void testValues() {
        assertEquals(10, car.getX());
        assertEquals(20, car.getY());
    }

    @Test
    public void testMovement() {
        car.moveX(10);
        car.moveY(10);
        assertEquals(20, car.getX());
        assertEquals(30, car.getY());
    }

}

package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarModelTest {
    private CarModel car;
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(10, 20);
        car = new CarModel(position);
    }

    @Test
    public void testValues() {
        assertEquals(10, car.getPosition().getX());
        assertEquals(20, car.getPosition().getY());
    }

    @Test
    public void testMovement() {
        car.moveRight();
        car.moveRight();
        assertEquals(12, car.getPosition().getX());
        car.moveLeft();
        assertEquals(11, car.getPosition().getX());
    }

}

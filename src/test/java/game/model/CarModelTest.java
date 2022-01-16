package game.model;

import game.model.game.CarModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarModelTest {
    private CarModel car;
    private Position position;

    @BeforeEach
    void setUp() {
        car = new CarModel(0, 40);
    }

    @Test
    void testValues() {
        assertEquals(0, car.getLane());
        assertEquals(40, car.getY());
    }

    @Test
     void testMovement() {
        car.moveRight();
        assertEquals(1, car.getLane());
        car.moveLeft();
        assertEquals(0, car.getLane());
    }

}

package game.model;

import game.model.game.CarModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarModelTest {
    private CarModel car;
    private CarModel enemy;
    private int velocity;

    @BeforeEach
    void setUp() {
        car = new CarModel(0, 40);
        enemy = new CarModel(1, 20);
        velocity = 1;
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
        car.moveLeft();
        assertEquals(0, car.getLane());
        enemy.moveY(velocity);
        assertEquals(21,enemy.getY());
    }

}

package game.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyModelTest {
    private EnemyModel enemy1;
    private EnemyModel enemy2;
    private Position position;

    @BeforeEach
    void setUp(){
        position = new Position(38,10);
        enemy1 = new EnemyModel(position);
        enemy2 = new EnemyModel();
    }

    @Test
    void TestValues(){
        assertEquals(38, enemy1.getPosition().getX());
        assertEquals(10, enemy1.getPosition().getY());
        assertEquals(20, enemy2.getPosition().getY());
    }

    @Test
    void TestMovement(){
        enemy1.getCloser(3);
        assertEquals(13,enemy1.getPosition().getY());
        enemy1.getCloser(2);
        enemy1.getCloser(2);
        enemy1.getCloser(1);
        assertEquals(18,enemy1.getPosition().getY());

    }

}

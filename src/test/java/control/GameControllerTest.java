package control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import model.CarModel;
import model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameControllerTest {
    @Test
    public void CheckKeys()  {
        GameController controller = new GameController();
        CarModel model = new CarModel(new Position(10,20));
        com.googlecode.lanterna.input.KeyStroke key = new KeyStroke(KeyType.ArrowLeft);
        controller.processKey(key, model);
        controller.processKey(key, model);
        assertEquals(8, model.getPosition().getX());
    }


}
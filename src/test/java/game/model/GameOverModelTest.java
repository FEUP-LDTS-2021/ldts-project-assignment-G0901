package game.model;

import com.googlecode.lanterna.TerminalSize;
import game.model.menu.GameOverModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverModelTest {
    private GameOverModel model;

    @BeforeEach
    void setUp() {
        model = new GameOverModel("test");
        model.current_item = 0;
    }

    @Test
    void nexItem() {
        model.nextItem();
        assertEquals(1, model.current_item);

        model.current_item = model.getNumberItems();
        model.nextItem();
        assertEquals(0, model.current_item);
    }

    @Test
    void previousItem() {
        model.previousItem();

        assertEquals(model.getNumberItems() - 1, model.current_item);
    }

    @Test
    void isSelected() {
        assertTrue(model.isSelected(0));
        model.nextItem();
        assertFalse(model.isSelected(0));
    }

    @Test
    void whichSelected() {
        assertEquals(0, model.whichSelected());
        model.nextItem();
        assertEquals(1, model.whichSelected());
    }

    @Test
    void numberItems() {
        assertEquals(model.items.length, model.getNumberItems());
    }

    @Test
    void getItem() {
        assertEquals(model.items[1], model.getItem(1));
    }

    @Test
    void getTitle() {
        String text = model.title;

        assertEquals(text, model.getTitle());
    }

    @Test
    void getSize() {
        TerminalSize size_test = model.size;
        assertEquals(size_test, model.getSize());
    }
}

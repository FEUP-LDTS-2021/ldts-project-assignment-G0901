package game.model;

import game.model.menu.GenericTabModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericTabModelTest {
    GenericTabModel model;

    @BeforeEach
    void setUp() {
        model = Mockito.mock(GenericTabModel.class, Mockito.CALLS_REAL_METHODS);
        model.setItems(new String[] {"test1", "test2", "test3"});
    }

    @Test
    void testNext() {
        model.nextItem();

        assertEquals(1, model.getCurrentItem());
    }

    @Test
    void testLast() {
        for (int i = 0; i < model.getNumberItems() + 1; i++) {
            model.nextItem();
        }

        assertTrue(model.isLast());
    }

    @Test
    void testPrevious() {
        model.nextItem();
        model.previousItem();

        assertEquals(0, model.getCurrentItem());
    }

    @Test
    void testFirst() {
        for (int i = 0; i < model.getNumberItems() + 1; i++) {
            model.previousItem();
        }
        assertTrue(model.isFirst());
    }
}

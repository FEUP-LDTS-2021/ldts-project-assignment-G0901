package game.model;

import game.model.menu.SelectTrackModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectTrackModelTest {
    private SelectTrackModel model;

    @BeforeEach
    void setUp() {
        model = new SelectTrackModel();

    }

    @Test
    void testIsFirst() {
        Boolean is_first = model.isFirst();

        assertTrue(is_first);
    }

    @Test
    void testIsLast() {
        for (int i = 0; i < model.getTracks().size(); i++) {
            model.nextItem();
        }

        Boolean is_first = model.isLast();

        assertTrue(is_first);
    }

    @Test
    void testNextItem() {
        for (int i = 0; i < model.getTracks().size(); i++) {
            model.nextItem();
        }

        assertEquals(model.getTracks().get(model.getTracks().size() - 1),
                model.getCurrentTrack());
    }

    @Test
    void testPreviousItem() {
        for (int i = 0; i < model.getTracks().size(); i++) {
            model.previousItem();
        }
        assertEquals(model.getTracks().get(0), model.getCurrentTrack());
    }

    @Test
    void testNavigation() {
        model.nextItem();
        model.previousItem();

        assertEquals(model.getTracks().get(0), model.getCurrentTrack());
    }
}

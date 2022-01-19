package game.model;

import game.model.menu.RulesModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RulesModelTest {
    private RulesModel model;

    @BeforeEach
    void setUp() {
        model = new RulesModel();

    }

    @Test
    void getTitle() {
        String text = model.title;

        assertEquals(text, model.getTitle());
    }

    @Test
    void getKeys() {
        String text = model.keys;

        assertEquals(text, model.getKeys());
    }

    @Test
    void getDescription() {
        String text = model.description;

        assertEquals(text, model.getDescription());
    }

    @Test
    void getProceed() {
        String text = model.proceed;

        assertEquals(text, model.getProceed());
    }
}

package game.model;

import com.googlecode.lanterna.TerminalSize;
import game.model.rules.RulesModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RulesModelTest {
    private RulesModel model;

    @BeforeEach
    void setUp() {
        model = new RulesModel(new TerminalSize(40, 40));

    }

    @Test
    void getSize() {
        TerminalSize size_test = model.size;
        assertEquals(size_test, model.getSize());
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

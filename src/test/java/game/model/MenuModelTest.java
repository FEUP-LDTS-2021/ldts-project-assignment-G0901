package game.model;

import game.model.menu.MenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuModelTest {
    private MenuModel model;

    private String background_color = "#353535";
    private String text_color = "#D9D9D9";

    @BeforeEach
    void setUp() {
        model = new MenuModel();
    }

    @Test
    void testBackground() {
        String color = model.getBackgroundColor();

        assertEquals(background_color, color);
    }

    @Test
    void testText() {
        String color = model.getTextColor();

        assertEquals(text_color, color);
    }
}

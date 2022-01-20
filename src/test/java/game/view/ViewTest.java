package game.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

public class ViewTest {
    View view;
    TextGraphics graphics;
    List<String> test_list;
    Character test_color_char;
    String test_color_string;
    GUI gui;


    @BeforeEach
    void setUp() {
        view = Mockito.mock(View.class, Mockito.CALLS_REAL_METHODS);
        graphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);

        test_list = new ArrayList<>();
        test_list.add("1234");
        test_list.add("1234");
        test_list.add("1234");

        test_color_char = 'B';
        test_color_string = "#FFFF00";

        Mockito.when(graphics.getSize()).thenReturn(new TerminalSize(20, 20));
        Mockito.when(gui.getGraphics()).thenReturn(graphics);

    }

    @Test
    void testDrawSprite() {
        view.drawSprite(graphics, test_list, test_color_char, 5, 5);

        // expected 12 because: 3(list items) * 4(chars in each) = 12
        Mockito.verify(graphics, Mockito.times(12)).putString(anyInt(), anyInt(), anyString());
    }

    @Test
    void testDrawMenu() {
        view.drawMenu(test_list, test_color_string, gui, 5, false);

        Mockito.verify(graphics, Mockito.times(3)).putString(anyInt(), anyInt(), anyString(), any(SGR.class));
    }

    @Test
    void testDrawScore() {
        view.drawScore("1", gui, 5);

        Mockito.verify(graphics, Mockito.times(11)).putString(anyInt(), anyInt(), anyString(), any(SGR.class));
    }

    @Test
    void testGetSize() {
        assertEquals(4, view.getSize(test_list));
    }

    @Test
    void testLoadSprite() {
        List<String> list = view.loadSprite("menu/title.txt");

        // expected 8 because: actual number of lines of menu/title.txt
        assertEquals(8, list.size());
    }
}

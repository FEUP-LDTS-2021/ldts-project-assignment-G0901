package game.gui;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import game.model.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GUITest {

    private GUI gui;
    private Screen screen;

    @BeforeEach
    void setUp() throws IOException {
       gui = new GUI(new Size(40,40));
       screen = Mockito.mock(Screen.class);
       gui.screen = screen;
    }

    @Test
    void getAction() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));
        assertEquals(GUI.ACTION.RIGHT , gui.getAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));
        assertEquals(GUI.ACTION.LEFT , gui.getAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));
        assertEquals(GUI.ACTION.QUIT, gui.getAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
        assertEquals(GUI.ACTION.UP, gui.getAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
        assertEquals(GUI.ACTION.DOWN, gui.getAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Escape));
        assertEquals(GUI.ACTION.ESC, gui.getAction());

        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));
        assertEquals(GUI.ACTION.ENTER, gui.getAction());
    }

    @Test
    void clearRefresh() throws IOException {
        gui.clear();
        gui.refresh();

        Mockito.verify(screen, Mockito.times(1)).clear();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void getters() {
        assertEquals(gui.screen, gui.getScreen());
        assertEquals(gui.graphics, gui.getGraphics());
    }
}

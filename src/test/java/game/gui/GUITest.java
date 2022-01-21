package game.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GUITest {
    private GUI gui;
    private Screen screen;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        graphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);

        gui = new GUI(screen);
    }

    @Test
    void testFill() throws IOException {
        gui.fillScreen("#ffffff");

        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(
                TextColor.Factory.fromString("#ffffff")
        );
        Mockito.verify(graphics, Mockito.times(1)).fill(' ');
    }

    @Test
    void clear() throws IOException {
        gui.clear();

        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    void refresh() throws IOException {
        gui.refresh();

        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void getActionNone() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(null);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.NONE , action);
    }

    @Test
    void getActionRight() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.RIGHT , action);
    }

    @Test
    void getActionLeft() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.LEFT , action);
    }

    @Test
    void getActionQuit() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.QUIT, action);
    }

    @Test
    void getActionUp() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.UP, action);
    }

    @Test
    void getActionDown() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.DOWN, action);
    }

    @Test
    void getActionEsc() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Escape));

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.ESC, action);
    }

    @Test
    void getActionEnter() throws IOException {
        Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.ENTER, action);
    }
}

package game.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.view.menu.MenuView;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class MenuViewTest {
    @Test
    public void testMenuView() throws IOException {
        GUI gui = mock(GUI.class);
        MenuModel model = mock(MenuModel.class);
        when(model.getTitle()).thenReturn("test");
        when(model.getBackgroundColor()).thenReturn("test");
        MenuView view = new MenuView(model);
        TextGraphics graphics = mock(TextGraphics.class);
        when(graphics.getSize()).thenReturn(new TerminalSize(0, 0));
        when(gui.getGraphics()).thenReturn(graphics);

        view.drawElements(gui);

        verify(gui, times(1)).fillScreen("test");
    }
}

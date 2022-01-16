package game.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.view.menu.MenuView;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.plaf.basic.BasicTreeUI;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class MenuViewTest {
    private MenuView view;
    private GUI gui;
    private MenuModel model;
    private TerminalPosition position;
    private TextColor textColor;
    private TextGraphics graphics;

   @BeforeEach
   void setUp() {
       gui = Mockito.mock(GUI.class);
       model = Mockito.mock(MenuModel.class);
       position = Mockito.mock(TerminalPosition.class);
       textColor = Mockito.mock(TextColor.class);
       graphics = mock(TextGraphics.class);


       view = new MenuView(model);


   }
    @Test
    public void drawElements() throws IOException {
        when(gui.getGraphics()).thenReturn(graphics);
        when(gui.getGraphics().getSize()).thenReturn(new TerminalSize(0, 0));
        when(model.getTitle()).thenReturn("test");
        when(model.isSelected(anyInt())).thenReturn(Boolean.TRUE);

        view.drawElements(gui);

        verify(gui, times(1)).fillScreen(view.background_color);
        verify(graphics, times(model.getNumberItems())).putString(position, model.getItem(anyInt()));
        verify(graphics, times(model.getNumberItems())).setForegroundColor(textColor);
    }
}

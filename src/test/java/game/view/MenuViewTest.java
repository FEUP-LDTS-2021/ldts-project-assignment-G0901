package game.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.menu.MenuModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuViewTest {
    private MenuView menu_view;
    private GUI gui;
    private MenuModel model;
    private TerminalPosition position;
    private TextColor textColor;
    private TextGraphics graphics;
    private View view;

   @BeforeEach
   void setUp() {
       model = new MenuModel();
       graphics = Mockito.mock(TextGraphics.class);
       gui = Mockito.mock(GUI.class);

       gui.graphics = graphics;

       when(gui.getGraphics()).thenReturn(graphics);
       when(gui.getGraphics().getSize()).thenReturn(new TerminalSize(40, 40));


       menu_view = new MenuView(model);
   }

    @Test
    public void drawElements() throws IOException {
       menu_view.drawElements(gui);
       verify(gui,times(1)).refresh();
    }
}

package game.view.menu;

import com.googlecode.lanterna.TerminalSize;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.view.View;

import java.io.IOException;

public class MenuView extends View<MenuModel> {
    public MenuView(MenuModel model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        TerminalSize size = gui.getGraphics().getSize();
        gui.fillScreen(model.getBackgroundColor());


        gui.getGraphics().putString(size.getColumns() / 2 - model.getTitle().length() / 2,
                size.getRows() / 4 - model.getTitle().length() / 2,
                model.getTitle());

        gui.refresh();
    }
}

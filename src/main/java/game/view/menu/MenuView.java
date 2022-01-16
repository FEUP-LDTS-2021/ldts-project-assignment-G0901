package game.view.menu;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.view.View;

import java.io.IOException;

public class MenuView extends View<MenuModel> {
    public String background_color = "#353535";
    private String text_color = "#D9D9D9";
    private String selected_color = "#d44ede";

    public MenuView(MenuModel model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        TerminalSize size = gui.getGraphics().getSize();

        gui.getGraphics().setForegroundColor(TextColor.Factory.fromString(text_color));

        gui.getGraphics().putString(size.getColumns() / 2 - model.getTitle().length() / 2,
                size.getRows() / 4 - model.getTitle().length() / 2, model.getTitle());


        for (int i = 0; i < model.getNumberItems(); i++){
            gui.getGraphics().setForegroundColor(TextColor.Factory.fromString(text_color));


            if (model.isSelected(i))
                gui.getGraphics().setForegroundColor(TextColor.Factory.fromString(selected_color));


            gui.getGraphics().putString(size.getColumns() / 2 - model.getItem(i).length() / 2,
                    ((size.getRows() / 2) + ((size.getRows() / 2) / model.getNumberItems() * i)) - model.getItem(i).length() / 2, model.getItem(i));
        }

        gui.refresh();
    }
}

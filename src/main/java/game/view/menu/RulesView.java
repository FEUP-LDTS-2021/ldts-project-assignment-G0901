package game.view.menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import game.gui.GUI;
import game.model.menu.RulesModel;
import game.view.View;

import java.io.IOException;
import java.util.List;

public class RulesView extends View<RulesModel> {
    private List<String> title;
    private List<String> keys;
    private List<String> description;
    private List<String> proceed;

    public RulesView(RulesModel model) {
       super(model);
       title = loadSprite(model.getTitle());
       keys = loadSprite(model.getKeys());
       description = loadSprite(model.getDescription());
       proceed = loadSprite(model.getProceed());

   }

   @Override
    public void drawElements(GUI gui) throws IOException {
       TerminalSize size = gui.getGraphics().getSize();

       gui.fillScreen(background_color);

       drawMenu(title, title_color, gui, size.getRows() / 5, false);
       drawMenu(description, item_color, gui, size.getRows() / 2, false);
       drawMenu(keys, item_color, gui, size.getRows() / 2 + 15, false);
       drawMenu(proceed, item_color, gui, size.getRows() / 2 + 25, true);
       gui.refresh();
   }
}

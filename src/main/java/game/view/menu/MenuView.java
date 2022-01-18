package game.view.menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.view.View;
import game.view.game.TrackView;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MenuView extends View<MenuModel> {
    public String background_color = "#353535";
    private String item_color = "#D9D9D9";
    private String title_color = "#293241";
    private String selected_color = "#d44ede";

    private int number_of_items;
    private int row;

    private List<String> title;
    private List<String> item;
    private List<List<String>> item_list = new LinkedList<>();
    private TrackView trackView;

    public MenuView(MenuModel model) {
        super(model);
        number_of_items = model.getNumberItems();
        title = loadSprite(model.getTitle());
        loadItemsSprites(item_list, model.getItems());
    }


    @Override
    public void drawElements(GUI gui) throws IOException {
        TerminalSize size = model.getSize();

        gui.getGraphics().setBackgroundColor(TextColor.Factory.fromString(background_color));
        gui.getGraphics().fillRectangle(new TerminalPosition(0, 0), new TerminalSize(size.getColumns(), size.getRows()), ' ');

        drawMenu(title, title_color, gui, size.getRows() / 5, false);

        for (int i = 0; i < number_of_items; i++) {
            item = item_list.get(i);
            row = calculateRow(size, i);

            if (model.isSelected(i))
                drawMenu(item, selected_color, gui, row, true);
            else drawMenu(item, item_color, gui, row, false);
        }
        gui.refresh();
    }

    private int calculateRow(TerminalSize size, int i) {
       return size.getRows() / 2 + ((size.getRows() / 2) / number_of_items * i);
    }

    public void loadItemsSprites(List<List<String>> itemsList, String[] items) {
        for (int i = 0; i < items.length; i++) {
            itemsList.add(loadSprite(items[i]));
        }
    }
}


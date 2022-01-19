package game.view.menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import game.gui.GUI;
import game.model.game.TrackModel;
import game.model.menu.GameOverModel;
import game.view.View;
import game.view.game.TrackView;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GameOverView extends View<GameOverModel> {
    public String score;
    private int number_of_items;
    private int row;

    private List<String> title;
    private List<String> score_file;
    private List<String> item;
    private List<List<String>> item_list = new LinkedList<>();

    private TrackView track_view;

    public GameOverView(GameOverModel model) {
        super(model);
        number_of_items = model.getNumberItems();
        title = loadSprite(model.getTitle());
        score_file = loadSprite(model.getScore_string());
        loadItemsSprites(item_list, model.getItems());
        track_view = new TrackView(new TrackModel());
        score = String.valueOf(model.getScore());
    }


    @Override
    public void drawElements(GUI gui) throws IOException {
        track_view.drawElements(gui);
        TerminalSize size = gui.getGraphics().getSize();

        gui.fillScreen(background_color);

        drawMenu(title, title_color, gui, size.getRows() / 5, false);
        drawMenu(score_file, item_color, gui, size.getRows() / 2, false);
        gui.graphics.putString(size.getColumns() / 2, (int) (size.getRows() * 0.60F), score);

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
        return (int) (size.getRows() * 0.75F + (size.getRows() / 10) * i);
    }

    public void loadItemsSprites(List<List<String>> itemsList, String[] items) {
        for (int i = 0; i < items.length; i++) {
            itemsList.add(loadSprite(items[i]));
        }
    }

}

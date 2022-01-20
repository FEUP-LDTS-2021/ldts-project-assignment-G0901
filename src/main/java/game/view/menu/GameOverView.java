package game.view.menu;

import com.googlecode.lanterna.TerminalSize;
import game.gui.GUI;
import game.model.game.TrackModel;
import game.model.menu.GameOverModel;
import game.model.menu.GenericTabModel;
import game.view.View;
import game.view.game.TrackView;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GameOverView extends GenericTabView {
    private String score;
    private List<String> score_file;

    public GameOverView(GameOverModel model) {
        super(model);
        number_of_items = model.getNumberItems();
        title = loadSprite(model.getTitle());
        loadItemsSprites(item_list, model.getItems());
        score_file = loadSprite(model.getScore_string());
        score = String.valueOf(model.getScore());
    ;}


    @Override
    public void drawElements(GUI gui) throws IOException {
        TerminalSize size = gui.getGraphics().getSize();

        gui.fillScreen(background_color);

        drawMenu(this.title, title_color, gui, size.getRows() / 5, false);
        drawMenu(score_file, item_color, gui, size.getRows() / 2, false);
        drawScore(score, gui, size.getRows() / 2 + 8);

        for (int i = 0; i < number_of_items; i++) {
            item = item_list.get(i);
            row = calculateRow(size, i);

            if (model.isSelected(i))
                drawMenu(item, selected_color, gui, row, true);
            else drawMenu(item, item_color, gui, row, false);
        }

        gui.refresh();
    }

    @Override
    public int calculateRow(TerminalSize size, int i) {
        return (int) (size.getRows() * 0.75F + (size.getRows() / 10) * i);
    }
}

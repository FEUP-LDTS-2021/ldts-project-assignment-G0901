package game.view.menu;

import com.googlecode.lanterna.TextColor;
import game.gui.GUI;
import game.model.menu.SelectTrackModel;
import game.view.View;

import java.io.IOException;
import java.util.List;

public class SelectTrackView extends View<SelectTrackModel> {
    private List<String> current_track;
    private List<String> left_arrow;
    private List<String> right_arrow;

    public SelectTrackView(SelectTrackModel model) {
        super(model);
        left_arrow = loadSprite("Menu/left_arrow.txt");
        right_arrow = loadSprite("Menu/right_arrow.txt");
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.fillScreen(background_color);

        drawTrackFlag(gui);
        drawArrows(gui);

        gui.refresh();
    }

    private void drawTrackFlag(GUI gui) throws IOException {
        current_track = loadSprite("Track/" + model.getCurrentTrack() + "_flag.txt");

        int x_pos = gui.getGraphics().getSize().getColumns() / 2 - getSize(current_track) / 2;
        int y_pos = gui.getGraphics().getSize().getRows() / 2 - current_track.size() / 2;

        drawSprite(gui.getGraphics(), current_track, 'B', x_pos, y_pos);
    }

    private void drawArrows(GUI gui) throws IOException {
        int y_pos = gui.getGraphics().getSize().getRows() / 2 - left_arrow.size() / 2;
        int width = gui.getGraphics().getSize().getColumns();

        if (!model.isFirst())
            drawSprite(gui.getGraphics(), left_arrow, 'Z',
                (int)(width * 0.05), y_pos);

        if (!model.isLast())
            drawSprite(gui.getGraphics(), right_arrow, 'Z',
                (int)(width * 0.95) - getSize(right_arrow), y_pos);
    }
}

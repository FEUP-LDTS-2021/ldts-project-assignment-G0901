package game.view.game;

import com.googlecode.lanterna.TextColor;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;
import game.view.View;

import java.io.IOException;

public class GameView extends View<GameModel> {
    public TrackView track_view;
    public CarView car_view;

    public GameView(GameModel model) {
        super(model);
        this.track_view = new TrackView(model.getTrackModel());
        this.car_view = new CarView(model.getCarModel());
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        track_view.drawElements(gui);
        car_view.drawElements(gui);
        for (CarModel enemy: model.getEnemies()) {
            CarView enemy_view = new CarView(enemy);
            enemy_view.drawElements(gui);
        }
        drawInGameScore(gui);

        gui.refresh();

    }

    private void drawInGameScore(GUI gui) {
        gui.getGraphics().setBackgroundColor(TextColor.Factory.fromString(model.getTrackModel().getBackgroundColor()));
        gui.getGraphics().setForegroundColor(TextColor.Factory.fromString(colors.get("B")));
        drawScore(String.valueOf(model.getScore()), gui, 15);
    }
}
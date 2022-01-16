package game.view.game;

import game.gui.GUI;
import game.model.game.EnemyModel;
import game.model.game.GameModel;
import game.view.View;

import java.io.IOException;

public class GameView extends View<GameModel> {
    public TrackView track_view; //TODO Change views into subclass
    public CarView car_view;
    public EnemyView enemy_view;

    public GameView(GameModel model) {
        super(model);
        this.track_view = new TrackView();
        this.car_view = new CarView();
        this.enemy_view = new EnemyView();
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        track_view.draw(gui.getGraphics(), model.getTrackModel());
        car_view.draw(gui.getGraphics(), model.getCarModel());
        for (EnemyModel e: model.getEnemies())
        {
            if (e.getPosition().getY() > (gui.getGraphics().getSize().getRows() / 2))
                enemy_view.draw(gui.getGraphics(), e);
        }

        gui.refresh();

    }
}
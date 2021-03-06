package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.GameModel;

public class CarController extends Controller<GameModel> {
    public CarController(GameModel model) {
        super(model);
    }

    public void step(Application application, GUI.ACTION action)
    {
        if (action == GUI.ACTION.LEFT)
            if (getModel().getCarModel().getLane() > -1)
                getModel().getCarModel().moveLeft();
        if (action == GUI.ACTION.RIGHT)
            if (getModel().getCarModel().getLane() < 1)
                getModel().getCarModel().moveRight();

    }
}

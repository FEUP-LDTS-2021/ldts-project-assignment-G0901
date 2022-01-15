package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.CarModel;

public class CarController extends Controller<CarModel> {
    public CarController(CarModel model) {
        super(model);
    }

    public void step(Application application, GUI.ACTION action)
    {
        if (action == GUI.ACTION.LEFT)
            if (getModel().getLane() > -1)
                getModel().moveLeft();
        if (action == GUI.ACTION.RIGHT)
            if (getModel().getLane() < 1)
                getModel().moveRight();
    }

}

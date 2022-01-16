package game.view.game;
import game.gui.GUI;
import game.model.game.CarModel;
import game.view.View;

import java.io.IOException;
import java.util.List;

public class CarView extends View<CarModel> {
    private List<String> car;
    private int x_pos;

    public CarView(CarModel model) {
        super(model);
        car = loadSprite("car1.txt");
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        getPosition(gui);
        drawSprite(gui.getGraphics(), car, 'R', x_pos, model.getY() - car.size());
    }

    private void getPosition(GUI gui) {
        int width = gui.getGraphics().getSize().getColumns();
        int height = gui.getGraphics().getSize().getRows();

        double perspective = (double)(model.getY() - height / 2) / (height / 2);
        double lane_distance = width * 0.3 * perspective;

        x_pos = (int)(width / 2 - getSize(car) / 2);
        x_pos += model.getLane() * (int)(0.1 * lane_distance + 0.8 * lane_distance);
    }
}
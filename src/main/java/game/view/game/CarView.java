package game.view.game;
import com.googlecode.lanterna.TerminalSize;
import game.gui.GUI;
import game.model.game.CarModel;
import game.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarView extends View<CarModel> {
    private List<List<String>> cars;
    private List<String> car;
    private int x_pos;

    public CarView(CarModel model) {
        super(model);
        cars = new ArrayList<>();
        cars.add(loadSprite("car/car1.txt"));
        cars.add(loadSprite("car/car2.txt"));
        cars.add(loadSprite("car/car3.txt"));
        cars.add(loadSprite("car/car4.txt"));
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        getPosition(gui);
        drawSprite(gui.getGraphics(), car, 'R', x_pos, model.getY());
    }

    private void getPosition(GUI gui) {
        int i;
        double perspective, lane_distance;
        TerminalSize size = gui.getGraphics().getSize();

        perspective = (double)(model.getY() - size.getRows() / 2) / (size.getRows() / 2);
        lane_distance = size.getColumns() * 0.3 * perspective;

        //choose the car sprite
        i = (int)(perspective * cars.size());
        i = Math.min(i, cars.size() - 1);
        i = Math.max(i, 0);
        car = cars.get(i);

        x_pos = size.getColumns() / 2 - getSize(car);
        x_pos += model.getLane() * (int)(0.1 * lane_distance + 0.8 * lane_distance);
    }
}
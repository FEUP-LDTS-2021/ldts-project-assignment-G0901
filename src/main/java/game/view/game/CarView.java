package game.view.game;
import game.gui.GUI;
import game.model.Size;
import game.model.game.CarModel;
import game.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarView extends View<CarModel> {
    private List<List<String>> cars;
    private List<String> car;
    private int x_pos;
    private double perspective;

    public CarView(CarModel model) {
        super(model);
        cars = new ArrayList<>();
        cars.add(loadSprite("car/car1.txt"));
        cars.add(loadSprite("car/car2.txt"));
        cars.add(loadSprite("car/car3.txt"));
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        getPosition(gui);
        drawSprite(gui.getGraphics(), car, 'R', x_pos, model.getY());
    }

    private void getPosition(GUI gui) {
        Size size = new Size(gui.getGraphics().getSize().getColumns(),gui.getGraphics().getSize().getRows());

        perspective = (double)(model.getY() - size.getHeight() / 2) / (size.getHeight() / 2);
        System.out.println(perspective);
        double lane_distance = size.getWidth() * 0.3 * perspective;

        int i = (int)(perspective * cars.size());
        i = Math.min(i, cars.size() - 1);
        car = cars.get(i);
        model.setHeight(car.size());

        x_pos = (int)(size.getWidth() / 2 - getSize(car) / 2);
        x_pos += model.getLane() * (int)(0.1 * lane_distance + 0.8 * lane_distance);
    }
}
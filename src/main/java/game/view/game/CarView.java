package game.view.game;
import com.googlecode.lanterna.TerminalSize;
import game.gui.GUI;
import game.model.Size;
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
        TerminalSize size = new TerminalSize(gui.getGraphics().getSize().getColumns(),gui.getGraphics().getSize().getRows());

        double perspective = (double)(model.getY() - size.getRows() / 2) / (size.getRows() / 2);
        double lane_distance = size.getColumns() * 0.3 * perspective;

        x_pos = (int)(size.getColumns() / 2 - getSize(car) / 2);
        x_pos += model.getLane() * (int)(0.1 * lane_distance + 0.8 * lane_distance);
    }
}
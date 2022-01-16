package game.view.game;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.game.CarModel;
import game.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarView extends View<CarModel> {
    private int size;
    private List<String> car;

    public CarView(CarModel model) {
        super(model);
        car = loadSprite("car1.txt");

    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        int width = gui.getGraphics().getSize().getColumns();
        int x_pos = (int)(width / 2 - getSize(car) / 2 + model.getLane() * (width * 0.3));
        int y_pos = (int)(0.95 * (gui.getGraphics().getSize().getRows() - car.size()));
        drawSprite(gui.getGraphics(), car, 'Y', x_pos, y_pos);
    }
}
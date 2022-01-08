package view;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import model.CarModel;

public class CarView extends CarModel {
    CarModel model;
    public CarView(CarModel model) {
        super(model.getPosition());
        this.model = model;

    }

    public void draw(TextGraphics screen){
        screen.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        screen.enableModifiers(SGR.BOLD);
        screen.fillTriangle(new TerminalPosition(model.getPosition().getX() - 5, model.getPosition().getY()), new TerminalPosition(model.getPosition().getX() + 5, model.getPosition().getY()), new TerminalPosition(model.getPosition().getX(), model.getPosition().getY() - 5), ' ');
    }
}

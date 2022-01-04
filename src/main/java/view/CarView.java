package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.CarModel;

public class CarView extends CarModel {
    CarModel model;
    public CarView(CarModel model) {
        super(model.getPosition());
        this.model = model;

    }

    public void draw(TextGraphics screen){
        screen.setForegroundColor(TextColor.Factory.fromString("#F000FF"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(model.getPosition().getX(), model.getPosition().getY(), "X" );
    }
}

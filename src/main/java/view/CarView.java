package view;

import com.googlecode.lanterna.*;
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
        screen.setForegroundColor(TextColor.Factory.fromString("#f24616"));
        screen.setBackgroundColor(TextColor.Factory.fromString("#8f8f8f"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(model.getPosition().getX(), model.getPosition().getY(), "X" );
    }
}

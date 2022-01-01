package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.CarModel;

public class CarView extends CarModel {

    public CarView(CarModel model) {
        super(model.getPosition());

    }

    public void draw(TextGraphics screen){
        screen.setForegroundColor(TextColor.Factory.fromString("#7CFC00"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(getPosition().getX(), getPosition().getY(), "C" );
    }
}

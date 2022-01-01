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

    }
}

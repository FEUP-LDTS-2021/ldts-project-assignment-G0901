package game.view.game;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.model.game.CarModel;

public class CarView  {
    public CarView() {
    }

    public void draw(TextGraphics screen, CarModel model){
        screen.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        screen.enableModifiers(SGR.BOLD);
        screen.fillTriangle(new TerminalPosition(model.getPosition().getX() - 5, model.getPosition().getY()), new TerminalPosition(model.getPosition().getX() + 5, model.getPosition().getY()), new TerminalPosition(model.getPosition().getX(), model.getPosition().getY() - 5), ' ');
    }
}

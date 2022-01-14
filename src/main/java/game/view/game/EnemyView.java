package game.view.game;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.model.game.EnemyModel;

public class EnemyView extends EnemyModel {
    public EnemyView() {
    }

    public void draw(TextGraphics screen, EnemyModel model){
        screen.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        screen.enableModifiers(SGR.BOLD);
        screen.fillTriangle(new TerminalPosition(model.getPosition().getX() - 1, model.getPosition().getY()), new TerminalPosition(model.getPosition().getX() + 1, model.getPosition().getY()), new TerminalPosition(model.getPosition().getX(), model.getPosition().getY()-1), ' ');
    }
}
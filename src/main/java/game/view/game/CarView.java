package game.view.game;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.model.game.CarModel;

import java.util.ArrayList;
import java.util.List;

public class CarView  {
    private int size;
    private List<String> car;

    public CarView() {
        car = new ArrayList<String>() {{
            //add("  ################     ");
            add("  ################     ");
            add("        ###     ");
            add("BBBB  #######  BBBB");
            add("BBBB###########BBBB");
            add("BBBB    ###    BBBB");}};

        size = getSize();
    }

    public void draw(TextGraphics screen, CarModel model) {
        int x_pos = screen.getSize().getColumns() / 2 - size / 2 + model.getLane() * 12;
        screen.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        for (int i = 0; i < car.size(); i++)
        {
            for (int j = 0; j < car.get(i).length(); j++) {
                char c = car.get(i).charAt(j);
                if (c != ' ') {
                    if (c == 'B') {
                        screen.setBackgroundColor(TextColor.Factory.fromString("#000000"));
                    }
                    else if (c == '#') {
                        screen.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
                    }
                    screen.putString(x_pos + j, model.getY() + i, " ");
                }
            }
        }

    }

    private int getSize() {
        int max = 0;
        for (int i = 0; i < car.size(); i++) {
            if (car.get(i).length() > max) max = car.get(i).length();
        }
        return max;
    }
}

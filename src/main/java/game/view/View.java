package game.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.game.CarModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public abstract class View<Model> {
    protected Model model;
    Map<Character, String> colors = new HashMap<>();

    public View(Model model) {
        this.model = model;
        loadColors();
    }

    public void loadColors() {
        colors.put('B', "#000000");
        colors.put('Y', "#FFFF00");
        colors.put('R', "#ff2800");
    }

    public void draw(GUI gui) throws IOException{
        drawElements(gui);
    }

    public abstract void drawElements(GUI gui) throws IOException;

    protected void drawSprite(TextGraphics screen, List<String> sprite, Character color, int x, int y) {
        screen.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        for (int i = 0; i < sprite.size(); i++)
        {
            for (int j = 0; j < sprite.get(i).length(); j++) {
                char c = sprite.get(i).charAt(j);
                if (c != ' ') {
                    if (c == '#')
                        screen.setBackgroundColor(TextColor.Factory.fromString(colors.get(color)));
                    else
                        screen.setBackgroundColor(TextColor.Factory.fromString(colors.get(c)));
                    screen.putString(x + j, y + i, " ");
                }
            }
        }
    }

    protected void drawMenu(List<String> sprite, String color, GUI gui, int row, boolean selected)
    {
        int column = gui.getGraphics().getSize().getColumns() / 2 - sprite.get(0).length() / 2;
        int count = 0;
        gui.graphics.setForegroundColor(TextColor.Factory.fromString(color));
        for (int i = 0; i < sprite.size(); i++)
        {
            if (selected)
                gui.getGraphics().putString(column, row + count, sprite.get(i), SGR.BLINK);
            else gui.getGraphics().putString(column, row + count, sprite.get(i), SGR.BOLD);

            count += 1;
        }
    }

    protected int getSize(List<String> sprite) {
        int max = 0;
        for (int i = 0; i < sprite.size(); i++) {
            if (sprite.get(i).length() > max) max = sprite.get(i).length();
        }
        return max;
    }

    protected List<String> loadSprite(String file_path) {
        URL resource = getClass().getClassLoader().getResource(file_path);
        List<String> list = new ArrayList<String>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(resource.toURI()));
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        }
        return list;
    }
}

package game.model.menu;

import game.model.Model;

public class MenuModel implements Model {
    public final String[] items;
    public String title = "title.txt";


    private int width, height;

    public int current_item = 0;

    public MenuModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.items = new String[]{"start.txt", "rules.txt", "about.txt", "quit.txt"};
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[] getItems() {
        return items;
    }

    public void nextItem() {
        current_item += 1;
        if (current_item > getNumberItems() - 1)
            current_item = 0;
    }

    public void previousItem() {
        current_item -= 1;
        if (current_item < 0)
            current_item = getNumberItems() - 1;
    }

    public boolean isSelected(int item) {return current_item == item;}

    public int whichSelected() {return current_item;}

    public int getNumberItems() {return items.length;}

    public String getItem(int i) {return items[i];}
}

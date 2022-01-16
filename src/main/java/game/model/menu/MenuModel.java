package game.model.menu;

import game.model.Model;

public class MenuModel implements Model {
    public final String[] items;
    private String title;

    private int width, height;

    public int current_item = 0;

    public MenuModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.items = new String[]{"Start", "Rules", "About", "Quit"};
        title = "Game";
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

package game.model.menu;

public class MenuModel {
    public final String[] items;
    public String title;
    public int current_item;

    public MenuModel() {
        this.items = new String[]{"menu/start.txt", "menu/rules.txt", "menu/about.txt", "menu/quit.txt"};
        current_item = 0;
        title = "menu/title.txt";
    }

    public String getTitle() {
        return title;
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

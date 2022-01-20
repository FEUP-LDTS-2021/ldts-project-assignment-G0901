package game.model.menu;

public abstract class GenericTabModel {
    protected String[] items;
    protected String title;
    private int current_item;

    public GenericTabModel() {
        items = new String[]{};
        title = "";
        current_item = 0;
    }

    public String getTitle() {
        return title;
    }

    public String[] getItems() {
        return items;
    }

    public int getNumberItems() {
        return items.length;
    }

    public boolean isSelected(int item) {
        return current_item == item;
    }

    public String getSelected() {
        return items[current_item];
    }

    public int getCurrentItem() {
        return current_item;
    }

    public Boolean isFirst() {
        return (current_item == 0);
    }

    public Boolean isLast() {
        return (current_item == items.length - 1);
    }

    public String getItem(int i) {
        return items[i];
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public void nextItem() {
        current_item = Math.min(current_item + 1, items.length - 1);
    }

    public void previousItem() {
        current_item = Math.max(current_item - 1, 0);
    }
}

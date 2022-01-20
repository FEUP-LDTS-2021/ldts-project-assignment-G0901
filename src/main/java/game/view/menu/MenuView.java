package game.view.menu;

import game.model.menu.MenuModel;

public class MenuView extends GenericTabView {
    public MenuView(MenuModel model) {
        super(model);
        number_of_items = model.getNumberItems();
        title = loadSprite(model.getTitle());
        loadItemsSprites(item_list, model.getItems());
    }
}

package game.model.menu;

public class MenuModel extends GenericTabModel {
    public MenuModel() {
        this.items = new String[]{"menu/start.txt",
                "menu/rules.txt",
                "menu/about.txt",
                "menu/quit.txt"};

        title = "menu/title.txt";
    }
}

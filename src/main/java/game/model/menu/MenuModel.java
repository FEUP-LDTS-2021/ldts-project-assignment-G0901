package game.model.menu;

import game.model.Model;

public class MenuModel implements Model {
    private String title;

    private String background_color;
    private String text_color;

    public MenuModel() {
        title = "Game";
        background_color = "#353535";
        text_color = "#D9D9D9";
    }

    public String getTitle() {
        return title;
    }

    public String getBackgroundColor() {
        return background_color;
    }

    public String getTextColor() {
        return text_color;
    }
}

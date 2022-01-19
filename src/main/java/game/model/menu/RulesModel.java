package game.model.menu;

public class RulesModel {
    public String title;
    public String keys;
    public String description;
    public String proceed;
    public int current_item;

    public RulesModel() {
        current_item = 0;
        title = "rules/rules.txt";
        keys = "rules/keys.txt";
        description = "rules/description.txt";
        proceed = "rules/proceed.txt";
    }

    public String getTitle () {return title;}

    public String getKeys () {return keys;}

    public String getDescription () {return description;}

    public String getProceed () {return proceed;}

}

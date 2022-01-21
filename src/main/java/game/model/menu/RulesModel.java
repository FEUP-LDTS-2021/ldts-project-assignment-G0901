package game.model.menu;

public class RulesModel extends GenericTabModel {
    private String keys;
    private String description;
    private String proceed;

    public RulesModel() {
        title = "rules/rules.txt";
        keys = "rules/keys.txt";
        description = "rules/description.txt";
        proceed = "rules/proceed.txt";
    }

    public String getKeys () {return keys;}

    public String getDescription () {return description;}

    public String getProceed () {return proceed;}
}

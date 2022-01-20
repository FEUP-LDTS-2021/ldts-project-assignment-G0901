package game.model.menu;

public class AboutModel {
    String title;
    String text;

    public AboutModel() {
        title = "about/title.txt";
        text = "about/text.txt";
    }

    public String getTitle() {return title;}
    public String getText() {return text;}
}

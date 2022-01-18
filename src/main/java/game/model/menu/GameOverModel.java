package game.model.menu;

import com.googlecode.lanterna.TerminalSize;

public class GameOverModel {
    public final String[] items;
    public String title;
    public TerminalSize size;
    public String score_string;
    public int current_item;
    public int score;
    String track;

    public GameOverModel(TerminalSize size, String track) {
        this.size = size;
        this.track = track;
        this.items = new String[]{"game_over/restart.txt", "game_over/menu.txt"};
        current_item = 0;

        title = "game_over/game_over.txt";
        score_string = "game_over/score.txt";
    }

    public String getTitle() {
        return title;
    }

    public String getScore_string() {return score_string;}

    public TerminalSize getSize() {
        return size;
    }

    public String[] getItems() {
        return items;
    }

    public String getTrack() { return track; }

    public int getScore() {return score;}

    public void setScore(int score) {this.score = score;}

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

    public boolean isSelected(int item) {
        return current_item == item;
    }

    public int whichSelected() {
        return current_item;
    }

    public int getNumberItems() {
        return items.length;
    }

    public String getItem(int i) {
        return items[i];

    }
}

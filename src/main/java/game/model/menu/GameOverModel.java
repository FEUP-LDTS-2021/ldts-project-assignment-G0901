package game.model.menu;

public class GameOverModel extends GenericTabModel {
    private int score;
    private String score_string;
    private String track;

    public GameOverModel(String track) {
        this.track = track;
        this.items = new String[]{"game_over/restart.txt", "game_over/menu.txt"};

        title = "game_over/game_over.txt";
        score_string = "game_over/score.txt";
    }

    public String getScore_string() {return score_string;}

    public String getTrack() { return track; }

    public int getScore() {return score;}

    public void setScore(int score) {this.score = score;}
}

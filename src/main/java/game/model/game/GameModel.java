package game.model.game;

import com.googlecode.lanterna.TerminalSize;
import game.model.Model;
import game.model.Size;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements Model {
    CarModel carModel;
    TrackModel trackModel;
    List<CarModel> enemies;
    String track;
    int velocity = 4;
    int score;
    TerminalSize size;

    public GameModel(TerminalSize size, String track) {
        this.size = size;
        this.track = track;
        carModel = new CarModel(0, (int)(size.getRows() * 0.90));
        trackModel = new TrackModel();
        trackModel.loadTrack(track);
        enemies = new ArrayList<CarModel>();
        score = 0;
    }

    public TerminalSize getSize() { return size; }

    public CarModel getCarModel() {
        return carModel;
    }

    public TrackModel getTrackModel() {
        return trackModel;
    }

    public String getTrack() {
        return track;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getScore() {return score;}

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public void setTrackModel(TrackModel trackModel) {
        this.trackModel = trackModel;
    }

    public void setScore(int score) {this.score = score;}

    public void moveTrack() {
        this.trackModel.move(this.velocity);
    }

    public List<CarModel> getEnemies() {return enemies;}

    public void addEnemy(CarModel enemy) {
        enemies.add(enemy);
    }

}

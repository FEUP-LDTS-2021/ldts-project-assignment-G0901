package game.model.game;

import java.util.ArrayList;
import java.util.List;

public class GameModel {
    CarModel carModel;
    TrackModel trackModel;
    List<CarModel> enemies;
    String track;
    int velocity;
    int score;

    public GameModel(String track) {
        this.track = track;
        carModel = new CarModel(0, 70);
        trackModel = new TrackModel();
        trackModel.loadTrack(track);
        enemies = new ArrayList<CarModel>();
        score = 0;
        velocity = trackModel.getVelocity();
    }

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

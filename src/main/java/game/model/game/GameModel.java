package game.model.game;

import game.model.Model;

import java.util.ArrayList;
import java.util.List;

public class GameModel implements Model {
    CarModel carModel;
    TrackModel trackModel;
    List<CarModel> enemies;

    int velocity = 1;
    int width, height;

    public GameModel(CarModel car, TrackModel track){
        carModel = car;
        trackModel = track;
    }

    public GameModel(int width, int height) {
        this.width = width;
        this.height = height;
        carModel = new CarModel(0, (int)(height * 0.95));
        trackModel = new TrackModel();
        enemies = new ArrayList<CarModel>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public TrackModel getTrackModel() {
        return trackModel;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public void setTrackModel(TrackModel trackModel) {
        this.trackModel = trackModel;
    }

    public void moveTrack() {
        this.trackModel.move(this.velocity);
    }

    public List<CarModel> getEnemies() {return enemies;}

    public void addEnemy(CarModel enemy) {
        enemies.add(enemy);
    }

}

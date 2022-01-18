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

    int velocity = 4;
    TerminalSize size;

    public GameModel(CarModel car, TrackModel track){
        carModel = car;
        trackModel = track;
    }

    public GameModel(TerminalSize size, String track) {
        this.size = size;
        carModel = new CarModel(0, (int)(size.getRows() * 0.90));
        trackModel = new TrackModel();
        trackModel.loadTrack(track);
        enemies = new ArrayList<CarModel>();
    }

    public TerminalSize getSize() { return size; }

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

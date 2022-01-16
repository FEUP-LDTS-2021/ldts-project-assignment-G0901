package game.model.game;

import game.model.Model;

import java.util.List;

public class GameModel implements Model {
    CarModel carModel;
    TrackModel trackModel;
    EnemyModel enemyModel;
    List<EnemyModel> enemies;

    public GameModel(CarModel car, TrackModel track, EnemyModel enemy){
        carModel = car;
        trackModel = track;
        enemyModel = enemy;
    }

    public GameModel() {
        carModel = new CarModel();
        trackModel = new TrackModel();
        enemyModel = new EnemyModel();
        enemies = enemyModel.createEnemies();
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public TrackModel getTrackModel() {
        return trackModel;
    }

    public EnemyModel getEnemyModel() {return enemyModel; }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public void setTrackModel(TrackModel trackModel) {
        this.trackModel = trackModel;
    }

    public void setEnemyModel(EnemyModel enemyModel) {
        this.enemyModel = enemyModel;
    }

    public List<EnemyModel> getEnemies() {return enemies;}

}

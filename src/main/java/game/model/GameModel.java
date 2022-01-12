package game.model;

public class GameModel implements Model{
    CarModel carModel;
    TrackModel trackModel;

    public GameModel(CarModel car, TrackModel track){
        carModel = car;
        trackModel = track;
    }

    public GameModel() {
        carModel = new CarModel();
        trackModel = new TrackModel();
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public TrackModel getTrackModel() {
        return trackModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public void setTrackModel(TrackModel trackModel) {
        this.trackModel = trackModel;
    }
}

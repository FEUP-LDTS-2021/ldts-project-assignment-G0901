package game.model.game;

import game.model.Model;
import game.model.Position;

public class CarModel implements Model {
    int lane;
    int y;

    public CarModel() {
        this.lane = 0;
        this.y = 70;
    }

    public CarModel(int lane, int y)
    {
        this.lane = lane;
        this.y = y;
    }

    public void moveY(int velocity) {
        this.y += velocity;
    }

    public int getLane() {
        return lane;
    }

    public int getY() {
        return y;
    }

    public void moveLeft(){
        lane -= 1;
    }

    public void moveRight(){
        lane += 1;
    }
}

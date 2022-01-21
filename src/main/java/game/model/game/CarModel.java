package game.model.game;

public class CarModel {
    private int lane;
    private int y;
    private int height;
    private Character color;

    public CarModel() {
        this.lane = 0;
        this.y = 70;
        this.height = 7;
        this.color = 'R';
    }

    public CarModel(int lane, int y)
    {
        this.lane = lane;
        this.y = y;
        this.height = 7;
        this.color = 'R';
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

    public int getHeight() {
        return  height;
    }



    public void moveLeft(){
        lane -= 1;
    }

    public void moveRight(){
        lane += 1;
    }

    public Character getColor() {
        return color;
    }

    public void setColor(Character color) {
        this.color = color;
    }
}

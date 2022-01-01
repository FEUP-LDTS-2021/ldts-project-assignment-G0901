package model;

public class CarModel implements Model {
    Position position;

    public CarModel(Position position)
    {
        this.position = position;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public void moveLeft(){
        int x = position.getX() - 1;
        position = new Position(x, position.getY());
    }

    public  void moveRight(){
        int x = position.getX() + 1;
        position = new Position(x, position.getY());
    }
}

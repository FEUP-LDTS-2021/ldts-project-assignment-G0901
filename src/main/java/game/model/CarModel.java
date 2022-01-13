package game.model;

public class CarModel implements Model {
    Position initPosition;
    Position position;
    int mov;

    public CarModel() {
        initPosition = new Position(40, 37);
        this.position = initPosition;
        mov = 12;
    }

    public CarModel(Position position)
    {
        initPosition = position;
        this.position = position;
        mov = 12;
    }

    public Position getInitPosition() {return initPosition;}

    public Position getPosition() {
        return position;
    }

    public int getMov() {return mov;}

    public void setPosition(Position position){
        this.position = position;
    }

    public void moveLeft(){
        int x = position.getX() - mov;
        position = new Position(x, position.getY());
    }

    public  void moveRight(){
        int x = position.getX() + mov;
        position = new Position(x, position.getY());
    }
}

package game.model.game;

import game.model.Position;

import java.util.Random;


public class EnemyModel {
    Position position;
    int lane = (int) Math.random() * 3;

    public EnemyModel()
    {
        this.position = new Position(38+lane*2,20);
    }

    public EnemyModel(Position position)
    {
        this.position = position;
    }

    public Position getPosition()
    {
        return position;
    }

    public void getCloser(int speed)
    {
        int y = position.getY() + speed;
        position = new Position(position.getX(), y);
    }
}



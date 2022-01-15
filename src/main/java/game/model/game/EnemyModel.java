package game.model.game;

import game.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EnemyModel {
    public List<EnemyModel> enemies;
    Position position;
    final int number_of_enemies = 30;

    Random rand = new Random();
    int lane = (int) rand.nextInt(3);

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

    public Position setPosition(Position position) {return this.position = position;}

    public void getCloserY(int speed)
    {
        int y = position.getY() + speed;
        position = new Position(position.getX(), y);
    }

    public void getCloserX() {
        if (lane == 0) position = new Position(position.getX() - 1, position.getY());
        if (lane == 2) position = new Position(position.getX() + 1, position.getY());
    }

    public List<EnemyModel> createEnemies() {
        int count = 0;
        List<EnemyModel> temp = new ArrayList<>();
        for (int i = 0; i < number_of_enemies; i++) {
            EnemyModel tempE = new EnemyModel();
            tempE.setPosition(new Position(tempE.getPosition().getX(), tempE.getPosition().getY() - count));
            temp.add(tempE);
            count += 30;
        }
        return temp;
    }
}



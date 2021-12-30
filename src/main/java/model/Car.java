package model;

public class Car {
    private int x, y;

    public Car(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveX(int distance) {
        x += distance;
    }

    public void moveY(int distance) {
        y += distance;
    }
}

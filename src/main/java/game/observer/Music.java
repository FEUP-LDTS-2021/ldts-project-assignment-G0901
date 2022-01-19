package game.observer;

import game.Application;

public class Music extends Observer {
    Application app;

    public Music(Application app)  {
        this.app = app;
        app.addObserver(this);
    }

    @Override
    public void update() {

    }

}

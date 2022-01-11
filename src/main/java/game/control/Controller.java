package game.control;

import game.Application;

public abstract class Controller<Model> {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public abstract void step(Application application);
}
package game.states;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.view.View;

import java.io.IOException;

public abstract class State<Model> {
    private Model model;
    protected View view;
    protected Controller<Model> controller;

    public State(Model model)
    {
        this.model = model;
    }

    public abstract void step(Application app, GUI gui) throws IOException;
}

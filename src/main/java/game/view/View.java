package game.view;

import game.gui.GUI;

import java.io.IOException;

public abstract class View<Model> {
    protected Model model;

    public View(Model model) {
        this.model = model;
    }

    public void draw(GUI gui) throws IOException{
        drawElements(gui);
    }

    public abstract void drawElements(GUI gui) throws IOException;

}

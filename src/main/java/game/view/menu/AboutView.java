package game.view.menu;

import com.googlecode.lanterna.TerminalSize;
import game.gui.GUI;
import game.model.menu.AboutModel;
import game.view.View;

import java.io.IOException;
import java.util.List;


public class AboutView extends View<AboutModel> {
    private List<String> title;
    private List<String> text;

    public AboutView(AboutModel model) {
        super(model);
        title = loadSprite(model.getTitle());
        text = loadSprite(model.getText());
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        TerminalSize size = gui.getGraphics().getSize();

        gui.fillScreen(background_color);

        drawMenu(title, title_color, gui, size.getRows() / 5, false);
        drawMenu(text, title_color, gui, (int) (size.getRows() * 0.45), false);
        gui.refresh();
    }
}

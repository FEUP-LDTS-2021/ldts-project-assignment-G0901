package game.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class GUI {
    public static int height;
    public static int width;
    public static final String background_colour = "#7CFC00";

    private Screen screen;
    private TextGraphics graphics;

    public GUI (int width, int height) {
        this.width = width;
        this.height = height;
        initScreen();
    }

    private void initScreen() {
        try {
            DefaultTerminalFactory factory = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height));
            Terminal terminal = factory.createTerminal();

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            graphics = screen.newTextGraphics();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() throws IOException {
        screen.clear();
    }

    public void refresh() throws IOException{
        screen.refresh();
    }

    public Screen getScreen(){
        return screen;
    }

    public TextGraphics getGraphics(){
        return graphics;
    }

}

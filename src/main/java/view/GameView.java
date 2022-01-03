package view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import model.CarModel;
import model.Position;

import java.io.IOException;

public class GameView {
    public static final int height = 40;
    public static final int width = 20;
    public static final String background_colour = "#7CFC00";

    private Screen screen;
    private TextGraphics graphics;

    public void initScreen() {
        try {
            DefaultTerminalFactory factory = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(height, width));
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
        graphics.setBackgroundColor(TextColor.Factory.fromString(background_colour));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
    }

    public Screen getScreen(){
        return screen;
    }

    public TextGraphics getGraphics(){
        return graphics;
    }
}
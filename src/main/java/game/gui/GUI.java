package game.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class GUI {
    public enum ACTION {NONE, QUIT, LEFT, RIGHT};
    public static int height;
    public static int width;
    public static final String background_colour = "#7CFC00";

    public Screen screen;
    public TextGraphics graphics;

    public GUI (int width, int height) {
        this.width = width;
        this.height = height;
        initScreen();
    }

    public void initScreen() {
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

    public ACTION getAction() throws IOException {
        KeyStroke key_stroke = screen.pollInput();

        if (key_stroke == null) return ACTION.NONE;

        if (key_stroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;

        if (key_stroke.getKeyType() == KeyType.ArrowRight ||
                (key_stroke.getKeyType() == KeyType.Character &&
                        key_stroke.getCharacter() == 'd')) return ACTION.RIGHT;

        if (key_stroke.getKeyType() == KeyType.ArrowLeft ||
                (key_stroke.getKeyType() == KeyType.Character &&
                        key_stroke.getCharacter() == 'a')) return ACTION.LEFT;

        return ACTION.NONE;
    }

    public void fillScreen(String color) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.fill(' ');
        screen.refresh();
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

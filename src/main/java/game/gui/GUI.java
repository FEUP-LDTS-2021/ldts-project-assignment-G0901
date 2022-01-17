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
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import game.model.Size;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class GUI {
    public enum ACTION {NONE, QUIT, LEFT, RIGHT, UP, DOWN, ESC, ENTER};
    public static TerminalSize size;
    public static final String background_colour = "#7CFC00";

    public Screen screen;
    public TextGraphics graphics;

    public GUI (TerminalSize size) {
        this.size = size;
        initScreen();
    }

    public void initScreen() {
        try {
            URL resource = getClass().getClassLoader().getResource("ticketing.ttf");
            File fontFile = new File(resource.toURI());
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

            DefaultTerminalFactory factory = new DefaultTerminalFactory().setInitialTerminalSize(size);

            Font loadedFont = font.deriveFont(Font.PLAIN, 8);
            AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
            factory.setTerminalEmulatorFontConfiguration(fontConfig);
            factory.setForceAWTOverSwing(true);

            Terminal terminal = factory.createTerminal();

            ((AWTTerminalFrame)terminal).addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    e.getWindow().dispose();
                }
            });

            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            graphics = screen.newTextGraphics();


        } catch (IOException | FontFormatException | URISyntaxException e) {
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

        if (key_stroke.getKeyType() == KeyType.ArrowUp ||
                (key_stroke.getKeyType() == KeyType.Character &&
                        key_stroke.getCharacter() == 'w')) return ACTION.UP;

        if (key_stroke.getKeyType() == KeyType.ArrowDown ||
                (key_stroke.getKeyType() == KeyType.Character &&
                        key_stroke.getCharacter() == 's')) return ACTION.DOWN;

        if (key_stroke.getKeyType() == KeyType.Escape ||
                (key_stroke.getKeyType() == KeyType.Character &&
                        key_stroke.getCharacter() == 'q')) return ACTION.ESC;

        if (key_stroke.getKeyType() == KeyType.Enter) return ACTION.ENTER;

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

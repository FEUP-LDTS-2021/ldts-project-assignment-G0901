package game.observer;

import game.Application;
import game.states.game.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ObserverTest {
    private Observer observer;
    private Application app;
    private  List<Observer> observers_list;
    private GameState game_state;

    @BeforeEach
    void setUp() throws LineUnavailableException {
        observers_list = new ArrayList<>();
        app = Mockito.mock(Application.class);
        game_state = Mockito.mock(GameState.class);

        Mockito.when(app.getObservers()).thenReturn(observers_list);

    }

    @Test
    void addObserver() throws LineUnavailableException {
        observer = new Music(app);

        Mockito.verify(app, Mockito.times(1)).addObserver(observer);
    }

    @Test
    void update() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Clip clip = Mockito.mock(Clip.class);
        observer = new Music(app, clip);

        observer.update();

        Mockito.verify(clip, Mockito.times(1)).stop();
        Mockito.verify(clip, Mockito.times(1)).close();
    }
}

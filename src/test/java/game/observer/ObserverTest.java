package game.observer;

import game.Application;
import game.states.game.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.sound.sampled.LineUnavailableException;
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

        observer = new Music(app);
        Mockito.when(app.getObservers()).thenReturn(observers_list);

    }

    @Test
    void getObserver() {
        assertEquals(observers_list, app.getObservers());
    }

    @Test
    void addObserver() {
        assertEquals(0, app.getObservers().size());
        app.getObservers().add(observer);
        assertEquals(1, app.getObservers().size());

    }

}

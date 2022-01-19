package game.observer;

import game.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ObserverTest {
    private Observer observer;
    private Application app;

    @BeforeEach
    void setUp() throws LineUnavailableException {
        app = new Application();
        observer = Mockito.mock(Observer.class);
    }

    @Test
    void addObserver() {
        // when app is loaded it automatically adds an Observer to the list
        assertEquals(1, app.getObservers().size());

        app.addObserver(observer);
        assertEquals(2, app.getObservers().size());
    }

    @Test
    void notifyObservers() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        app.addObserver(observer);
        app.setState(null);

        Mockito.verify(observer, Mockito.times(1)).update();

    }



}

package game.observer;

import game.Application;
import game.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverTest {
    private Observer observer;
    private Application app;
    private  List<Observer> observers_list;

    @BeforeEach
    void setUp() throws LineUnavailableException {
        observers_list = new ArrayList<>();
        app = Mockito.mock(Application.class);

        observer = new Music(app);

    }

    @Test
    void getObserver() {
        assertEquals(observers_list, app.getObservers());
    }

    @Test
    void addObserver() {
        Mockito.when(app.getObservers()).thenReturn(observers_list);

        assertEquals(0, app.getObservers().size());
        app.getObservers().add(observer);
        assertEquals(1, app.getObservers().size());

    }

}

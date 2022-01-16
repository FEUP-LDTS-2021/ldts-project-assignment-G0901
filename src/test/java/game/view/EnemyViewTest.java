package game.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class EnemyViewTest {
    private TextGraphics graphics;
    private EnemyModel model;
    private EnemyView view;

    @BeforeEach
    void setUp() {
        graphics = mock(TextGraphics.class);
        model = mock(EnemyModel.class);
        when(model.getPosition()).thenReturn(new Position(0, 0));
        view = new EnemyView();
    }

    @Test
    void testEnemyView()  {
        view.draw(graphics, model);
        view.draw(graphics, model);
        verify(graphics, times(2)).setBackgroundColor(any(TextColor.class));
    }
}

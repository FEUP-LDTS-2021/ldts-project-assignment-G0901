package view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.TrackModel;

public class TrackView extends TrackModel {
    public TrackView(TrackModel model) {
        super();
    }

    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#7CFC00"));
    }
}

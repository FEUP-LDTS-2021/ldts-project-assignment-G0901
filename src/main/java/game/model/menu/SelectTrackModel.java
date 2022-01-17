package game.model.menu;

import com.googlecode.lanterna.TerminalSize;

import java.util.ArrayList;
import java.util.List;

public class SelectTrackModel {
    private TerminalSize size;
    private int current_track;

    private final List<String> tracks = new ArrayList<String>(){{
        add("Monza");
        add("Spa");
    }};

    public SelectTrackModel(TerminalSize size) {
        this.size = size;
        this.current_track = 0;
    }

    public Boolean isFirst() {
        return (current_track == 0);
    }

    public Boolean isLast() {
        return (current_track == tracks.size() - 1);
    }

    public void nextItem() {
        current_track = Math.min(current_track + 1, tracks.size() - 1);
    }

    public void previousItem() {
        current_track = Math.max(current_track - 1, 0);
    }

    public String getCurrentTrack() {
        return tracks.get(current_track);
    }

    public TerminalSize getSize() {
        return size;
    }

    public List<String> getTracks() {
        return tracks;
    }
}

package game.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.model.game.TrackModel;

import static java.lang.Math.*;


public class TrackView {
        private int rows, columns;
        private int road_width, road_width_view;
        private int offset;
        private int left_grass_x, left_kerb_x, right_grass_x, right_kerb_x;
        private double perspective;

        private String grass_color;
        private String kerb_color;

        public TrackView() {
            road_width = 30;
            offset = 20;
        }

        public void draw(TextGraphics screen, TrackModel track) {
            rows = screen.getSize().getRows();
            columns = screen.getSize().getColumns();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    computeValues(i, j, track);

                    if (i < rows / 2) {
                        screen.setBackgroundColor(TextColor.Factory.fromString(track.getBackgroundColor()));
                    }
                    else {
                        if (j < left_grass_x || right_grass_x < j) {
                            screen.setBackgroundColor(TextColor.Factory.fromString(grass_color));
                        }
                        else if (j < left_kerb_x || right_kerb_x < j) {
                            screen.setBackgroundColor(TextColor.Factory.fromString(kerb_color));
                        }
                        else {
                            screen.setBackgroundColor(TextColor.Factory.fromString(track.getRoadColor()));
                        }
                    }
                    screen.fillRectangle(new TerminalPosition(j, i), new TerminalSize(1, 1), ' ');
                }
            }
        }

        private void computeValues(int i, int j, TrackModel track) {
            perspective = (double)(i - rows / 2) / (rows / 2);
            road_width_view = (int)(0.1 * road_width + 0.8 * road_width * perspective);
            int kerb_width = (int)(0.35 * road_width_view);
            left_grass_x = (columns / 2 - road_width_view - kerb_width);
            left_kerb_x = (columns / 2 - road_width_view);
            right_kerb_x = (columns / 2 + road_width_view);
            right_grass_x = (columns / 2 + road_width_view + kerb_width);

            if (sin(offset * pow((1 - perspective), 3) + track.getDistance() * 0.1) > 0) grass_color = track.getTerrainColor().get(0);
            else grass_color = track.getTerrainColor().get(1);
            if (sin(offset * pow((1 - perspective), 3) + track.getDistance() * 0.1) > 0) kerb_color = track.getKerbColor().get(0);
            else kerb_color = track.getKerbColor().get(1);

        }
}

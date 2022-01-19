package game.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.game.TrackModel;
import game.view.View;

import static java.lang.Math.pow;
import static java.lang.Math.sin;


public class TrackView extends View<TrackModel> {
        private int rows, columns;
        private int road_width, road_width_view;
        private int offset;
        private int left_grass_x, left_kerb_x, right_grass_x, right_kerb_x;
        private double perspective;

        private String grass_color;
        private String kerb_color;

        public TrackView(TrackModel model) {
            super(model);
            offset = 20;
        }

        @Override
        public void drawElements(GUI gui) {
            TextGraphics graphics = gui.getGraphics();
            road_width = (int)(graphics.getSize().getColumns() * 0.7);
            rows = graphics.getSize().getRows();
            columns = graphics.getSize().getColumns();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    computeValues(i, j);
                    setColor(graphics, i, j);
                    graphics.fillRectangle(new TerminalPosition(j, i),
                            new TerminalSize(1, 1), ' ');
                }
            }
        }

        private void setColor(TextGraphics graphics, int i, int j) {
            if (i < rows / 2) { //sky
                graphics.setBackgroundColor(TextColor.Factory.fromString(model.getBackgroundColor()));
            }
            else {
                if (j < left_grass_x || right_grass_x < j) { //terrain
                    graphics.setBackgroundColor(TextColor.Factory.fromString(grass_color));
                }
                else if (j < left_kerb_x || right_kerb_x < j) { //kerbs
                    graphics.setBackgroundColor(TextColor.Factory.fromString(kerb_color));
                }
                else { //road
                    graphics.setBackgroundColor(TextColor.Factory.fromString(model.getRoadColor()));
                }
            }
        }

    private void computeValues(int i, int j) {
        //Calculate de dimensions
        perspective = (double)(i - rows / 2) / (rows / 2);
        road_width_view = (int)(0.1 * road_width + 0.8 * road_width * perspective);
        int kerb_width = (int)(0.35 * road_width_view);

        //Calculate the positions of each element
        left_grass_x = (columns / 2 - road_width_view - kerb_width);
        left_kerb_x = (columns / 2 - road_width_view);
        right_kerb_x = (columns / 2 + road_width_view);
        right_grass_x = (columns / 2 + road_width_view + kerb_width);

        //Determine the colors using a trigonometric function
        if (sin(offset * pow((1 - perspective), 3) + model.getDistance() * 0.1) > 0)
            grass_color = model.getTerrainColor().get(0);
        else grass_color = model.getTerrainColor().get(1);

        if (sin(offset * pow((1 - perspective), 3) + model.getDistance() * 0.1) > 0)
            kerb_color = model.getKerbColor().get(0);
        else kerb_color = model.getKerbColor().get(1);
        }
}

package model;

import java.util.ArrayList;
import java.util.List;

public class TrackModel implements Model {
    String terrain_color1;
    String terrain_color2;
    String kerb_color1;
    String kerb_color2;
    String road_color;

    public TrackModel()
    {
        terrain_color1 = "#04de0f";
        terrain_color2 = "#05ad0e";
        kerb_color1 = "#e80505";
        kerb_color2 = "#ffffff";
        road_color = "#8f8f8f";
    }

    public TrackModel(String terrain_color1, String terrain_color2, String kerb_color1, String kerb_color2, String road_color)
    {
        this.terrain_color1 = terrain_color1;
        this.terrain_color2 = terrain_color2;
        this.kerb_color1 = kerb_color1;
        this.kerb_color2 = kerb_color2;
        this.road_color = road_color;
    }

    List<String> getTerrainColor() {
        List<String> colors = new ArrayList<String>();
        colors.add(terrain_color1);
        colors.add(terrain_color2);
        return colors;
    }

    List<String> getKerbColor() {
        List<String> colors = new ArrayList<String>();
        colors.add(kerb_color1);
        colors.add(kerb_color2);
        return colors;
    }

    String getRoadColor() {
        return road_color;
    }

    void setTerrainColor (String terrain_color1, String terrain_color2){
        this.terrain_color1 = terrain_color1;
        this.terrain_color2 = terrain_color2;
    }

    void setKerbColor (String kerb_color1, String kerb_color2) {
        this.kerb_color1 = kerb_color1;
        this.kerb_color2 = kerb_color2;
    }

    void setRoadColor (String road_color) {
        this.road_color = road_color;
    }
}

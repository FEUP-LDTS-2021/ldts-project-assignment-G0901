package game.model.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrackModel {
    private int distance;
    private String title;
    private String background_color;
    private String terrain_color1;
    private String terrain_color2;
    private String kerb_color1;
    private String kerb_color2;
    private String road_color;
    private Integer velocity;

    public TrackModel()
    {
        distance = 0;
        title = "Track";
        background_color = "#03fce8";
        terrain_color1 = "#04de0f";
        terrain_color2 = "#05ad0e";
        kerb_color1 = "#e80505";
        kerb_color2 = "#ffffff";
        road_color = "#8f8f8f";
    }

    public void loadTrack(String file_path) {
        file_path = "Track/" + file_path + ".txt";
        URL resource = getClass().getClassLoader().getResource(file_path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(resource.toURI()));

            title = scanner.nextLine();
            background_color = scanner.nextLine();
            terrain_color1 = scanner.nextLine();
            terrain_color2 = scanner.nextLine();
            kerb_color1 = scanner.nextLine();
            kerb_color2 = scanner.nextLine();
            road_color = scanner.nextLine();
            velocity = Integer.valueOf(scanner.nextLine());

            scanner.close();
        } catch (FileNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getBackgroundColor() {
        return background_color;
    }

    public List<String> getTerrainColor() {
        List<String> colors = new ArrayList<String>();
        colors.add(terrain_color1);
        colors.add(terrain_color2);
        return colors;
    }

    public List<String> getKerbColor() {
        List<String> colors = new ArrayList<String>();
        colors.add(kerb_color1);
        colors.add(kerb_color2);
        return colors;
    }

    public String getRoadColor() {
        return road_color;
    }

    public Integer getVelocity() {return velocity;}

    public void setBackgroundColor (String background_color) {
        this.background_color = background_color;
    }

    public void setTerrainColor (String terrain_color1, String terrain_color2){
        this.terrain_color1 = terrain_color1;
        this.terrain_color2 = terrain_color2;
    }
    public void setKerbColor (String kerb_color1, String kerb_color2) {
        this.kerb_color1 = kerb_color1;
        this.kerb_color2 = kerb_color2;
    }

    public void setRoadColor (String road_color) {
        this.road_color = road_color;
    }

    public void move(int amount) {
        this.distance += amount;
    }
}

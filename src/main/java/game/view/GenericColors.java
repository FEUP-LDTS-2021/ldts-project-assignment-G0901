package game.view;

import java.util.HashMap;
import java.util.Map;

public interface GenericColors {
    String background_color = "#f2cc8f";
    String item_color = "#e07a5f";
    String title_color = "#e07a5f";
    String selected_color = "#3d405b";

    Map<Character, String> colors = new HashMap<>(){{
        put('B', "#000000");
        put('Y', "#FFFF00");
        put('R', "#ff2800");
        put('G', "#008c45");
        put('W', "#ffffff");
        put('U', "#2a9d8f");
        put('Z', item_color);
    }};
}

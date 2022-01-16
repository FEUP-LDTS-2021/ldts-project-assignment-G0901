package game.view.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.view.View;

import java.io.IOException;

public class MenuView extends View<MenuModel> {
    public String background_color = "#353535";
    private String text_color = "#D9D9D9";
    private String title_color = "#293241";
    private String selected_color = "#d44ede";

    public MenuView(MenuModel model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        TerminalSize size = gui.getGraphics().getSize();
        gui.getGraphics().setBackgroundColor(TextColor.Factory.fromString(background_color));
        gui.getGraphics().fillRectangle(new TerminalPosition(0, 0), new TerminalSize(size.getColumns(), size.getRows()), ' ');

        int number_of_items = model.getNumberItems();

        gui.getGraphics().setForegroundColor(TextColor.Factory.fromString(text_color));

        drawTitle(gui, size);

        for (int i = 0; i < model.getNumberItems(); i++) {
            gui.getGraphics().setForegroundColor(TextColor.Factory.fromString(text_color));


            if (model.isSelected(i))
                gui.getGraphics().setForegroundColor(TextColor.Factory.fromString(selected_color));

            drawItems(gui, size, i, number_of_items);
        }
        gui.refresh();
    }




    public void drawTitle(GUI gui, TerminalSize size) {
        String s1 = "8888888888 .d88888b.  8888888b.  888b     d888 888     888 888             d8888          d8888";
        String s2 = "888       d88P   Y88b 888   Y88b 8888b   d8888 888     888 888            d88888         d8P888";
        String s3 = "888       888     888 888    888 88888b.d88888 888     888 888           d88P888        d8P 888";
        String s4 = "8888888   888     888 888   d88P 888Y88888P888 888     888 888          d88P 888       d8P  888";
        String s5 = "888       888     888 8888888P   888 Y888P 888 888     888 888         d88P  888      d88   888";
        String s6 = "888       888     888 888 T88b   888  Y8P  888 888     888 888        d88P   888      888888888";
        String s7 = "888       Y88b. .d88P 888  T88b  888       888 Y88b. .d88P 888       d8888888888            888";
        String s8 = "888         Y88888P   888   T88b 888       888   Y88888P   88888888 d88P     888            888";

        int column = size.getColumns() / 2 - s1.length() / 2;
        int first_row = size.getRows() / 5;

        gui.getGraphics().setForegroundColor(TextColor.Factory.fromString(title_color));

        gui.getGraphics().putString(column, first_row, s1);
        gui.getGraphics().putString(column,first_row + 1 , s2, SGR.BOLD);
        gui.getGraphics().putString(column, first_row + 2, s3, SGR.BOLD);
        gui.getGraphics().putString(column, first_row + 3, s4, SGR.BOLD);
        gui.getGraphics().putString(column, first_row + 4, s5, SGR.BOLD);
        gui.getGraphics().putString(column, first_row + 5, s6, SGR.BOLD);
        gui.getGraphics().putString(column, first_row + 6, s7, SGR.BOLD);
        gui.getGraphics().putString(column, first_row + 7, s8, SGR.BOLD);
    }

    public void drawItems(GUI gui, TerminalSize size, int item, int number_of_items) {
        switch (item) {
            case 0:
                String s1 = "_____ _____ _____ _____ _____  ";
                String s2 = "|   __|_   _|  _  | __  |_   _|";
                String s3 = "|__   | | | |     |    -| | |  ";
                String s4 = "|_____| |_| |__|__|__|__| |_|  ";

                int column = size.getColumns() / 2 - s1.length() / 2;
                int first_row = size.getRows() / 2;

                gui.getGraphics().putString(column, first_row, s1);
                gui.getGraphics().putString(column,first_row + 1 , s2, SGR.BOLD);
                gui.getGraphics().putString(column, first_row + 2, s3, SGR.BOLD);
                gui.getGraphics().putString(column, first_row + 3, s4, SGR.BOLD);

                break;

            case 1:
                String s5 = "_____      _         ";
                String s6 = "| __  |_ _| |___ ___ ";
                String s7 = "|    -| | | | -_|_ -|";
                String s8 = "|__|__|___|_|___|___|";

                column = size.getColumns() / 2 - s5.length() / 2;
                first_row = size.getRows() / 2 + ((size.getRows() / 2) / number_of_items);

                gui.getGraphics().putString(column, first_row, s5);
                gui.getGraphics().putString(column,first_row + 1 , s6, SGR.BOLD);
                gui.getGraphics().putString(column, first_row + 2, s7, SGR.BOLD);
                gui.getGraphics().putString(column, first_row + 3, s8, SGR.BOLD);

                break;

            case 2:
                String s9  = "_____ _           _    ";
                String s10 = "|  _  | |_ ___ _ _| |_ ";
                String s11 = "|     | . | . | | |  _|";
                String s12 = "|__|__|___|___|___|_|  ";

                column = size.getColumns() / 2 - s9.length() / 2;
                first_row = size.getRows() / 2 + ((size.getRows() / 2) / number_of_items * 2);

                gui.getGraphics().putString(column, first_row, s9);
                gui.getGraphics().putString(column,first_row + 1 , s10, SGR.BOLD);
                gui.getGraphics().putString(column, first_row + 2, s11, SGR.BOLD);
                gui.getGraphics().putString(column, first_row + 3, s12, SGR.BOLD);

                break;

            case 3:
                String s13 = "_____     _ _    ";
                String s14 = "|     |_ _|_| |_ ";
                String s15 = "|  |  | | | |  _|";
                String s16 = "|__  _|___|_|_|  ";
                String s17 = "|__|             ";

                column = size.getColumns() / 2 - s13.length() / 2;
                first_row = size.getRows() / 2 + ((size.getRows() / 2) / number_of_items * 3);

                gui.getGraphics().putString(column, first_row, s13);
                gui.getGraphics().putString(column,first_row + 1 , s14, SGR.BOLD);
                gui.getGraphics().putString(column, first_row + 2, s15, SGR.BOLD);
                gui.getGraphics().putString(column, first_row + 3, s16, SGR.BOLD);
                gui.getGraphics().putString(column, first_row + 4, s17, SGR.BOLD);

                break;
        }
    }
}


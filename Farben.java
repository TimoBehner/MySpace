package MySpace;

public class Farben {
    /*
     * Farben
     */

    //Resetten der Farbe
    public static final String reset = "\u001B[0m";

    //Schriftfarbe
    public static final String color_black = "\u001B[30m";  // BLACK
    public static final String color_red = "\u001B[31m";    // RED
    public static final String color_green = "\u001B[32m";  // GREEN
    public static final String color_yellow = "\u001B[33m"; // YELLOW
    public static final String color_blue = "\u001B[34m";   // BLUE
    public static final String color_purple = "\u001B[35m"; // PURPLE
    public static final String color_cyan = "\u001B[36m";   // CYAN
    public static final String color_white = "\u001B[37m";  // WHITE

    //Schriftfarbe & Unterstrichen
    public static final String color_black_underlined = "\033[4;30m";  // BLACK
    public static final String color_red_underlined = "\033[4;31m";    // RED
    public static final String color_green_underlined = "\033[4;32m";  // GREEN
    public static final String color_yellow_underlined = "\033[4;33m"; // YELLOW
    public static final String color_blue_underlined = "\033[4;34m";   // BLUE
    public static final String color_purple_underlined = "\033[4;35m"; // PURPLE
    public static final String color_cyan_underlined = "\033[4;36m";   // CYAN
    public static final String color_white_underlined = "\033[4;37m";  // WHITE
}

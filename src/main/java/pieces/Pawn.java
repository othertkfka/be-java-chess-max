package pieces;

public class Pawn {
    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";

    private final String color;

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

package snek;

import java.awt.*;

/**
 * The type of a tile.
 */
public enum Type {

    EMPTY(Color.BLACK), HEAD(Color.CYAN), SNEK(Color.GREEN), APPLE(Color.RED);

    /**
     * The color tiles of this type should appear as in the GUI.
     */
    public final Color color;

    Type(Color color) {
        this.color = color;
    }
}

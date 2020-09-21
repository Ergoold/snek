package snek;

import java.awt.*;

public enum Type {
    EMPTY, HEAD, SNEK, APPLE;

    public Color toColor() {
        return switch (this) {
            case EMPTY -> Color.BLACK;
            case HEAD -> Color.CYAN;
            case SNEK -> Color.GREEN;
            case APPLE -> Color.RED;
        };
    }
}

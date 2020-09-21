package snek;

import java.util.Random;

public class Tile {
    private static final Random r = new Random();

    public int x;
    public int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(Tile tile) {
        this(tile.x, tile.y);
    }

    public Tile(int size) {
        this(r.nextInt(size), r.nextInt(size));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile)o;
        return x == tile.x && y == tile.y;
    }
}

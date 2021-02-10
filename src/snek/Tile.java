package snek;

import java.util.Random;

/**
 * A tile on the game board.
 *
 * @see Board
 */
public class Tile {

    /**
     * The {@link Random} variable used to generate random tiles.
     */
    private static final Random r = new Random();

    /**
     * The x coordinate of this tile.
     */
    public int x;

    /**
     * The y coordinate of this tile.
     */
    public int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(Tile tile) {
        this(tile.x, tile.y);
    }

    /**
     * Constructs a {@code Tile} with a random coordinate within a board of size {@code size}.
     *
     * @param size the size of the board
     */
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

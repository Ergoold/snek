package snek;

/**
 * A game board for the game of snek.
 */
public class Board {

    /**
     * The size of this game board.
     */
    public final int size;

    /**
     * The apple that is currently on this game board.
     */
    private Tile apple;

    /**
     * The snek that is on this game board.
     */
    public final Snek snek;

    /**
     * Constructs a new board with a size of {@code size} by {@code size}.
     *
     * @param size the size of the board
     */
    public Board(int size) {
        this.size = size;
        this.snek = new Snek(new Tile(size / 2, size / 2));
        newApple();
    }

    /**
     * Generates an apple if one does not already exist.
     */
    private void newApple() {
        while (apple == null || snek.isOn(apple))
            apple = new Tile(size);
    }

    /**
     * Moves the snek on this board in {@code direction}.
     *
     * @param direction the direction to move the snek in
     * @return {@code true} if the game should end after moving; {@code false} otherwise
     */
    public boolean moveSnek(Direction direction) {
        if (!snek.move(direction, apple, size)) return false;
        if (snek.headOn(apple)) newApple();
        return true;
    }

    /**
     * Get the type of the tile at coordinates ({@code i}, {@code j}).
     *
     * @param i the x coordinate of the tile
     * @param j the x coordinate of the tile
     * @return the type of the tile at ({@code i}, {@code j})
     */
    public Type getTile(int i, int j) {
        final Tile tile = new Tile(i, j);
        if (snek.headOn(tile))
            return Type.HEAD;
        if (snek.isOn(tile))
            return Type.SNEK;
        if (tile.equals(apple))
            return Type.APPLE;
        return Type.EMPTY;
    }

    public int getScore() {
        return snek.size() - 3;
    }
}

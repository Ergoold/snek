package snek;

public class Board {
    public final int size;

    private Tile apple;
    public final Snek snek;

    public Board(int size) {
        this.size = size;
        this.snek = new Snek(new Tile(size / 2, size / 2));
        newApple();
    }

    public boolean moveSnek(Direction direction) {
        if (!snek.move(direction, apple, size)) return false;
        if (snek.headOn(apple)) newApple();
        return true;
    }

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

    private void newApple() {
        while (apple == null || snek.isOn(apple))
            apple = new Tile(size);
    }

    public int getScore() {
        return snek.size() - 3;
    }
}

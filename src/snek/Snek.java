package snek;

import java.util.LinkedList;

/**
 * A snek that moves on a board and eats apples.
 */
public class Snek {

    /**
     * All of the tiles in this snek's body.
     */
    private final LinkedList<Tile> body;

    /**
     * Constructs a snek with its head at {@code location}, facing {@link Direction}{@code .UP}.
     *
     * @param location the location of the snek's head
     */
    public Snek(Tile location) {
        body = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            Tile tail = new Tile(location);
            tail.y += i;
            body.add(tail);
        }
    }

    public int size() {
        return body.size();
    }

    public boolean isOn(Tile tile) {
        return body.contains(tile);
    }

    public boolean headOn(Tile tile) {
        return body.getFirst().equals(tile);
    }

    /**
     * Moves one {@code Tile} in {@code direction}.
     * <p>
     * This method also grows the snek's body if the new {@code Tile} has an apple on it.
     *
     * @param direction the direction to move in
     * @param apple     the location of the apple
     * @param size      the size of the board
     * @return {@code true} if the snek is alive after moving; {@code false} otherwise
     */
    public boolean move(Direction direction, Tile apple, int size) {
        Tile head = new Tile(body.getFirst());
        switch (direction) {
            case UP -> head.y--;
            case DOWN -> head.y++;
            case LEFT -> head.x--;
            case RIGHT -> head.x++;
        }
        if (!head.equals(apple))
            body.removeLast();
        // check whether the head is within 0..size on each axis && not on the body
        boolean isDead = head.x < 0 || head.x >= size || head.y < 0 || head.y >= size || isOn(head);
        body.addFirst(head);
        return !isDead;
    }
}

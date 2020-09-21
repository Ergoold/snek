package snek;

import java.util.LinkedList;

public class Snek {
    private final LinkedList<Tile> body;

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

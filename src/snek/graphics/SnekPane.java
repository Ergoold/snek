package snek.graphics;

import snek.Board;
import snek.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnekPane extends JPanel {
    public final int size;

    private Board board;

    public final int side;

    private Direction direction;

    public SnekPane(int size, int side, int delay) {
        this.size = size;
        this.board = new Board(size);
        this.side = side;
        this.setPreferredSize(new Dimension(size * side, size * side));
        this.direction = Direction.UP;
        this.setFocusable(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> direction = Direction.UP;
                    case KeyEvent.VK_DOWN -> direction = Direction.DOWN;
                    case KeyEvent.VK_LEFT -> direction = Direction.LEFT;
                    case KeyEvent.VK_RIGHT -> direction = Direction.RIGHT;
                }
            }
        });

        new Timer(delay, e -> {
            if (board.moveSnek(direction)) {
                repaint();
            } else {
                int option = JOptionPane.showConfirmDialog(this,
                        "You Lose With a Score of " + board.getScore() + " Points. Play Again?",
                        "LoserError", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                if (option == JOptionPane.CANCEL_OPTION) System.exit(0);
                board = new Board(size);
                direction = Direction.UP;
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < size; i++)       // rows (y)
            for (int j = 0; j < size; j++) { // cols (x)
                g.setColor(board.getTile(j, i).toColor());
                g.fillRect(j * side, i * side, side, side);
            }
    }
}

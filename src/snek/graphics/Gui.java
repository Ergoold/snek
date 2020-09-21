package snek.graphics;

import javax.swing.*;

public class Gui extends JFrame {
    public Gui() {
        this.setTitle("Snek");
        this.setContentPane(new SnekPane(15, 30, 100));
        this.pack();
        this.setResizable(false);
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}

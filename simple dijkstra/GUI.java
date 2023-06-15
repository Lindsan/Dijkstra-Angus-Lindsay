/**
 * 
 *
 * @Angus Lindsay
 * @10/6/2023
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GUI extends JFrame {
    // Represents the GUI for displaying the graph.

    // instance variables
    // instance variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;
    private Graph graph; // Reference to the Graph object

    /**
     * Constructor for objects of class GUI
     */
    public GUI() {
        int windowX = 1100;
        int windowY = 600;
        setTitle("Dijkstra's algorithm");
        this.getContentPane().setPreferredSize(new Dimension(windowX, windowY));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.toFront();

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(windowX, windowY));
        myGraphic = new Canvas();
        panel.add(myGraphic);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menu = new JMenu("Menu");
        menuBar.add(menu);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.getContentPane().setPreferredSize(new Dimension(windowX, windowY));
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        // Trigger the painting of the graphics
        repaint(); // Calls the paint method to draw the graphics.
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        int nodeNum =graph.getNodeCount();
        int circleSize = 30;
        char c = 'A';

        // Draws the nodes on the canvas.
        for (int i = 0; i <26 ; i++) {
            Random rand = new Random();
            int x = rand.nextInt(1000) + 50;
            int y = rand.nextInt(550) + 50;
            g2.setColor(Color.BLACK);
            g2.fillOval(x, y, circleSize, circleSize);
            String s = String.valueOf(c);
            g2.setColor(Color.RED);
            g2.drawString(s, x + (circleSize / 2), y + (circleSize / 2));
            c++;
        }
    }
}

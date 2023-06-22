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
import java.util.Map;
import java.awt.geom.Line2D;

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
    public GUI(Graph graph) {
        this.graph = graph; // Assign the provided graph object to the instance variable

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
        this.graph = graph; // Assign the provided graph object to the instance variable

        // Trigger the painting of the graphics
        repaint(); // Calls the paint method to draw the graphics.
    }

    public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2 = (Graphics2D) g;
    int circleSize = 60;

    // Pre-calculate the positions of the nodes
    for (Node node : graph.getNodes()) {
        Random rand = new Random();
        int x = rand.nextInt(1000) + 50;
        int y = rand.nextInt(550) + 50;
        node.setX(x);
        node.setY(y);
    }

    // Draws the edges (lines) between connected nodes.
    g2.setColor(Color.BLACK);
    for (Node node : graph.getNodes()) {
        int startX = node.getX() + (circleSize / 2);
        int startY = node.getY() + (circleSize / 2);
        for (Map.Entry<Node, Integer> entry : node.getAdjacentNodes().entrySet()) {
            Node adjacentNode = entry.getKey();
            int endX = adjacentNode.getX() + (circleSize / 2);
            int endY = adjacentNode.getY() + (circleSize / 2);
            g2.setStroke(new BasicStroke(10));
            g2.draw(new Line2D.Float(startX, startY, endX, endY));
        }
    }

    // Draws the nodes on the canvas.
    for (Node node : graph.getNodes()) {
        g2.setColor(Color.BLACK);
        int x = node.getX();
        int y = node.getY();
        g2.fillOval(x, y, circleSize, circleSize);

        g2.setColor(Color.WHITE);
        g2.drawString(node.getName(), x + 10, y + (circleSize / 2));
    }
}


}





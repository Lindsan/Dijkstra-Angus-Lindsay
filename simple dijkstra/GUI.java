/**
 * 
 *
 * @Angus Lindsay
 * @10/6/2023
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    // instance variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;
    private Graph graph; // Reference to the Graph object

    /**
     * Constructor for objects of class AddingAMenu
     */
    public GUI() {
        setTitle("Dijkstra's algorithm");
        this.getContentPane().setPreferredSize(new Dimension(1000, 1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.toFront();

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 1000));
        myGraphic = new Canvas();
        panel.add(myGraphic);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menu = new JMenu("Menu");
        menuBar.add(menu);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.getContentPane().setPreferredSize(new Dimension(1000, 1000));
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        // Trigger the painting of the graphics
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        //int nodeNum =graph.getNodeCount();
        int x = 100;
        int y = 100;
        int circleSize = 30;
        char c='A';
        for (int i=0;i<8;i++) {
            g2.setColor(Color.BLACK);
            g2.fillOval(x, y, circleSize, circleSize);
              
            String s=String.valueOf(c);  
            g2.setColor(Color.RED);
            g2.drawString(s,x+(circleSize/2),y+(circleSize/2));
            x += 100;
            c++;
        }
    }
}

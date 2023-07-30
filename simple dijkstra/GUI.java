/**
 * This class provides a graphical user interface to display the graph.
 * It extends the JFrame class and uses the Canvas class to draw the nodes and edges of the graph.
 * It receives a Graph object in its constructor and utilizes the node and edge information to visualize the graph.
 * @Angus Lindsay
 * @25/6/2023
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Map;
import java.awt.geom.Line2D;

public class GUI extends JFrame {

    // instance variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;
    private Graph graph; // Reference to the Graph object
    int WINDOWX = 1100;
    int WINDOWY = 600;

    public GUI(Graph graph) {
        this.graph = graph; // Assign the provided graph object to the instance variable

        setTitle("Dijkstra's algorithm");
        this.getContentPane().setPreferredSize(new Dimension(WINDOWX, WINDOWY));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.toFront();

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(WINDOWX, WINDOWY));
        myGraphic = new Canvas();
        panel.add(myGraphic);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menu = new JMenu("Menu");
        menuBar.add(menu);

        
        // Add "Add Node" menu item
        menuItem = new JMenuItem("Add Node");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt the user for the name of the new node using JOptionPane
                String nodeName = JOptionPane.showInputDialog(null, "Enter the name of the new node:");
                if (nodeName != null && !nodeName.isEmpty()) {
                    // Create a new Node instance with the given name
                    Node newNode = new Node(nodeName);
                    // Add the new node to the graph
                    graph.addNode(newNode);
                    // Repaint the GUI to reflect the changes
                    repaint();
                }
            }
        });

        // Add "Remove Node" menu item
        menuItem = new JMenuItem("Remove Node");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt the user for the name of the node to remove using JOptionPane
                String nodeName = JOptionPane.showInputDialog(null, "Enter the name of the node to remove:");
                if (nodeName != null && !nodeName.isEmpty()) {
                    // Get the Node instance corresponding to the given name
                    Node nodeToRemove = graph.getNode(nodeName);
                    if (nodeToRemove != null) {
                        // Remove the node from the graph
                        graph.getNodes().remove(nodeToRemove);
                        // Remove any edges involving the removed node
                        for (Node node : graph.getNodes()) {
                            node.getAdjacentNodes().remove(nodeToRemove);
                        }
                        // Repaint the GUI to reflect the changes
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "Node not found in the graph!");
                    }
                }
            }
        });

        // Add "Change Weight" menu item
        menuItem = new JMenuItem("Change Weight");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt the user for the names of the source and destination nodes, and the new weight
                String sourceNodeName = JOptionPane.showInputDialog(null, "Enter the name of the source node:");
                String destinationNodeName = JOptionPane.showInputDialog(null, "Enter the name of the destination node:");
                String weightStr = JOptionPane.showInputDialog(null, "Enter the new weight between the nodes:");
                
                if (sourceNodeName != null && !sourceNodeName.isEmpty() &&
                    destinationNodeName != null && !destinationNodeName.isEmpty() &&
                    weightStr != null && !weightStr.isEmpty()) {
                    // Get the Node instances corresponding to the given names
                    Node sourceNode = graph.getNode(sourceNodeName);
                    Node destinationNode = graph.getNode(destinationNodeName);
                    if (sourceNode != null && destinationNode != null) {
                        try {
                            // Convert the input weight to an integer
                            int newWeight = Integer.parseInt(weightStr);
                            // Update the edge weight between the source and destination nodes
                            sourceNode.addDestination(destinationNode, newWeight);
                            destinationNode.addDestination(sourceNode, newWeight);
                            // Repaint the GUI to reflect the changes
                            repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid weight format! Please enter a valid integer.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "One or both nodes not found in the graph!");
                    }
                }
            }
        });
        // Add quit menu item
        menuItem = new JMenuItem("Quit");
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0); // Exit the application when "Quit" is selected
                }
            });

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        this.getContentPane().setPreferredSize(new Dimension(WINDOWX, WINDOWY));
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
        int CIRCLESIZE = 60;
        int lineWidth=5;
        // Pre-calculate the positions of the nodes
        for (Node node : graph.getNodes()) {
            Random rand = new Random();
            int x = rand.nextInt(WINDOWX - 50) + 50;//sets the node x and y position and adds 50 so the nodes aren't right on the border of the GUI window

            int y = rand.nextInt(WINDOWY - 50) + 50;//sets the node x and y position and adds 50 so the nodes aren't right on the border of the GUI window
            node.setX(x);
            node.setY(y);
        }

        // Draws the edges (lines) between connected nodes.
        for (Node node : graph.getNodes()) {
            int startX = node.getX() + (CIRCLESIZE / 2);//CIRCLESIZE/2 so that it starts in the center of the node
            int startY = node.getY() + (CIRCLESIZE / 2);
            for (Map.Entry<Node, Integer> entry : node.getAdjacentNodes().entrySet()) {
                Node adjacentNode = entry.getKey();
                int endX = adjacentNode.getX() + (CIRCLESIZE / 2);
                int endY = adjacentNode.getY() + (CIRCLESIZE / 2);

                // Check if the adjacentNode is part of the shortest path
                if (node.getShortestPath().contains(adjacentNode) || adjacentNode.getShortestPath().contains(node)) {
                    g2.setColor(Color.RED); // Set color to red for shortest path
                } else {
                    g2.setColor(Color.BLACK); // Set color to black for other edges
                }

                g2.setStroke(new BasicStroke(lineWidth));//line width
                g2.draw(new Line2D.Float(startX, startY, endX, endY));
            }
        }

        // Draws the nodes on the canvas.
        for (Node node : graph.getNodes()) {
            int x = node.getX();
            int y = node.getY();

            if (node.getDistance() == 0) {
                g2.setColor(Color.RED); // Set color to red for the starting node
            } else {
                g2.setColor(Color.BLACK); // Set color to black for other nodes
            }

            g2.fillOval(x, y, CIRCLESIZE, CIRCLESIZE);

            g2.setColor(Color.WHITE);
            g2.drawString(node.getName(), x + 10, y + (CIRCLESIZE / 2)); //adds 10 so the name isn't written in the start of the circle and hard to read
        }

        //g2.drawString("This is gonna be awesome",70,20);
    }
}
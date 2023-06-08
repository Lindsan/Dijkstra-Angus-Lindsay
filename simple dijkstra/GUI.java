/**
 * This demonstrates a lines and circles
 *
 * @Angus Lindsay
 * @8/6/23
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
public class GUI extends JFrame{
    // instance variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItem;
    Canvas myGraphic;
    
    
    /**
     * Constructor for objects of class AddingAMenu
     */
    public GUI()
    {

        setTitle("Dijkstra's algorythm");
        this.getContentPane().setPreferredSize(new Dimension(1000,1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.toFront();

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000,1000));
        myGraphic = new Canvas();
        panel.add(myGraphic);

        menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);

        menu = new JMenu("Menu");
        menuBar.add(menu);



        
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        this.getContentPane().setPreferredSize(new Dimension(1000, 1000));
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void paint (Graphics g) {

        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for(int i=0;i<10;i++){
            
            
            
            g2.setColor(Color.BLACK);
            int x=0;
            int y=100;
            int h=100;
            int w=100;
            
            if (i%2==0)
                for(int j=0;j<10;j+=2){
                    x+=100;
                    g2.fillOval( x, y, h, w);//Oval
                }
                else{
                    for(int j=0;j<10;j+=2){
                        y+=100;
                        g2.fillOval( x, y, h, w);//Oval
                }
                }
        }
        
        /*
        g2.setColor(Color.BLACK);
        g2.fillOval(0,100,100,100);//Oval
        g2.fillOval(200,100,100,100);//Oval
        g2.fillOval(0,300,100,100);
        g2.fillOval(200,300,100,100);
        
        g2.setColor(Color.BLACK);
        Line2D lin = new Line2D.Float(50,150,250,150);
        g2.draw(lin);//1-2
        Line2D lin2 = new Line2D.Float(50,150,50,350);
        g2.draw(lin2);//1-3
        Line2D lin3 = new Line2D.Float(250,150,250,350);
        g2.draw(lin3);//2-4
        Line2D lin4 = new Line2D.Float(50,350,250,350);
        g2.draw(lin4);//3-4
        Line2D lin5 = new Line2D.Float(50,150,250,350);
        g2.draw(lin5);//1-4
        Line2D lin6 = new Line2D.Float(250,150,50,350);
        g2.draw(lin6);//2-3
        g2.setColor(Color.RED);
        g2.drawString("1",50,150);
        g2.drawString("2",250,150);
        g2.drawString("3",50,350);
        g2.drawString("4",250,350);
        */
    }

}
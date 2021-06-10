package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import controleur.ControlChangeListener;
import org.emp.gl.timer.service.RebotChangeListener;

import java.beans.PropertyChangeEvent;

public class Gui implements RebotChangeListener{




    static JFrame f= new JFrame("Labyreinte");
    JButton b2=new JButton("Button 2");
    Pan panel=new Pan();

    public Gui() {
        f.setSize(1000,1000);
        f.setLayout(null);
        f.setVisible(true);
        panel.setBounds(0,0,1000,1000);
        f.add(panel);


    }

    public void change(int x, int y)
    {
        panel.updateRect(x,y);
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        String prop= pce.getPropertyName();
        if (prop.equals(RebotChangeListener.MOVE)) {
            int[] position= (int[]) pce.getNewValue();
            System.out.println(position[1]+" "+position[0]);
            change(position[1]*100,position[0]*100);
        }
    }

}

class Pan extends JPanel
{
    Point[] obstacles;

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        g.setColor(Color.BLACK);



        for(int i=0;i<1000;i=i+100)
        {
            g.drawLine(i,0,i,1000);
        }
        for(int i=0;i<1000;i=i+100)
        {
            g.drawLine(0,i,1000,i);
        }


        g.fillRect(100,100,100,100);
        g.fillRect(200,100,100,100);
        g.fillRect(200,200,100,100);


        g.setColor(Color.GREEN);
        g.drawRect(x,y,100,100);
        g.fillRect( x, y, 100, 100 );

    }
    private int x=0;private int y=0;
    public void updateRect(int x, int y ){
        this.x=x;
        this.y=y;
        paint(getGraphics());

    }



}
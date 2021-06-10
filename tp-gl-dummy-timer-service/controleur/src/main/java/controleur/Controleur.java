package controleur;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeSupport;

public class Controleur implements ControlChangeProvider {

    public Controleur (){
        JFrame f = new JFrame("Control");
        JButton boutonGauche = new JButton("<");
        JButton boutonUp = new JButton("up");
        JButton boutonDown = new JButton("down");
        JButton boutonDroit = new JButton(">");
        JPanel panneau = new JPanel();
        panneau.add(boutonGauche);
        panneau.add(boutonUp);
        panneau.add(boutonDown);
        panneau.add(boutonDroit);
        f.add(panneau);
        f.getDefaultCloseOperation();
        f.setSize(300,200);
        f.repaint();
        f.setVisible(true);
        boutonGauche.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                propertyChangeSupportDelegate.firePropertyChange(ControlChangeListener.GAUCHE,0,1);
            }
        });
        boutonUp.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                propertyChangeSupportDelegate.firePropertyChange(ControlChangeListener.UP,0,1);
            }
        });
        boutonDown.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                propertyChangeSupportDelegate.firePropertyChange(ControlChangeListener.DOWN,0,1);
            }
        });
        boutonDroit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                propertyChangeSupportDelegate.firePropertyChange(ControlChangeListener.DROIT,0,1);
            }
        });




    }

    private PropertyChangeSupport propertyChangeSupportDelegate = new PropertyChangeSupport(this);



    @Override
    public void addControlChangeListener(ControlChangeListener pl) {
        propertyChangeSupportDelegate.addPropertyChangeListener(pl);
    }

    @Override
    public void removeControlChangeListener(ControlChangeListener pl) {
        propertyChangeSupportDelegate.removePropertyChangeListener(pl);
    }

    //propertyChangeSupportDelegate.firePropertyChange(TimerChangeListener.MOVE,0,position);
}

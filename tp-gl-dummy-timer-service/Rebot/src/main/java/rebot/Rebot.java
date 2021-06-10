package rebot;



import controleur.ControlChangeListener;
import org.emp.gl.timer.service.RebotChangeListener;
import org.emp.gl.timer.service.RebotChangeProvider;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.Timer;
import java.util.TimerTask;

public class Rebot  extends TimerTask
        implements RebotChangeProvider, ControlChangeListener {


    public int [ ] position ;
    RebotStat state ;
    private PropertyChangeSupport propertyChangeSupportDelegate = new PropertyChangeSupport(this);

    @Override
    public void addRebotChangeListener(RebotChangeListener pl) {

        propertyChangeSupportDelegate.addPropertyChangeListener(pl);
    }

    @Override
    public void removeTimeChangeListener(RebotChangeListener pl) {

        propertyChangeSupportDelegate.removePropertyChangeListener(pl);
    }
    @Override
    public void run() {
        timeChanged();
    }
    private void timeChanged() {
        avancer();
    }



    public Rebot(){
        this.position = new int[]{0, 0};
        state=new RebotDroit(this);
        Timer timer = new Timer();


        timer.scheduleAtFixedRate(this, 1000, 1000);

    }
    public void avancer(){
        state.avancer();
        propertyChangeSupportDelegate.firePropertyChange(RebotChangeListener.MOVE,0,position);
    }

    public boolean avancerGauche(){
        if(state.avancerGauche())
        {
            propertyChangeSupportDelegate.firePropertyChange(RebotChangeListener.MOVE,0,position);
            return true;
        }
        return false;
    }
    public boolean avancerDroit(){
        if(state.avancerDroit()){
            propertyChangeSupportDelegate.firePropertyChange(RebotChangeListener.MOVE,0,position);
            return true;
        }
        return false;
    }
    public boolean avancerHaut(){
        if(state.avancerHaut()){
            propertyChangeSupportDelegate.firePropertyChange(RebotChangeListener.MOVE,0,position);
            return true;
        }
        return false;
    }
    public boolean avancerBas(){
        if(state.avancerBas()){
            propertyChangeSupportDelegate.firePropertyChange(RebotChangeListener.MOVE,0,position);
            return true;
        }
        return false;
    }

    void setState(RebotStat state){
        this.state=state;
    }


    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        String prop= pce.getPropertyName();
        if (prop.equals(ControlChangeListener.GAUCHE)) {
            avancerGauche();
        }
        if (prop.equals(ControlChangeListener.DROIT)) {
            avancerDroit();
        }
        if (prop.equals(ControlChangeListener.DOWN)) {
            avancerBas();
        }
        if (prop.equals(ControlChangeListener.UP)) {
            avancerHaut();
        }
    }
}

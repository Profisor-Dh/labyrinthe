package controleur;

import java.beans.PropertyChangeListener;

public interface ControlChangeListener extends PropertyChangeListener {

    final static String MOVE = "move" ;
    final static String GAUCHE="g";
    final static String DROIT="d";
    final static String UP="up";
    final static String DOWN="down";



}
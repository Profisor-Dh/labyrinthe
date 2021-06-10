package org.emp.gl.core.launcher;

import controleur.ControlChangeListener;
import controleur.ControlChangeProvider;
import controleur.Controleur;
import gui.Gui;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.timer.service.RebotChangeProvider;
import rebot.Rebot;

public class App {

    static {
        Lookup.getInstance().register(RebotChangeProvider.class, new Rebot());
        Lookup.getInstance().register(ControlChangeProvider.class, new Controleur());
    }

    public static void main(String[] args) {

        testDuTimeService();
    }


    private static void testDuTimeService() {

        RebotChangeProvider rebot = Lookup.getInstance().getService(RebotChangeProvider.class);
        ControlChangeProvider control=Lookup.getInstance().getService(ControlChangeProvider.class);

        Gui gui=new Gui();
        rebot.addRebotChangeListener(gui);
        control.addControlChangeListener((ControlChangeListener) rebot);

    }

}

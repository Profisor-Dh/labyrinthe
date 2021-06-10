package rebot;

import java.awt.*;

public abstract class RebotStat {
    public Rebot rebot;
    private Point obstacles = new Point();
    public RebotStat(Rebot rebot){
        this.rebot=rebot;

    }

    public boolean avancerGauche() {
        if(!(rebot.position[1]-1==-1 || (rebot.position[1]-1==2 && rebot.position[0]==1) || (rebot.position[1]-1==2 && rebot.position[0]==2) )) {
            rebot.position[1] -= 1;
            return true;
        }
        return false;
    }


    public boolean avancerDroit() {
        if(!(rebot.position[1]+1==10 || (rebot.position[1]+1==1&&rebot.position[0]==1) || (rebot.position[1]+1==2&&rebot.position[0]==2)  )){
            rebot.position[1]+=1;
            return true;
        }
        return false;
    }


    public boolean avancerHaut() {
        if(!(rebot.position[0]-1==-1 || (rebot.position[0]-1==2 && rebot.position[1]==2) || (rebot.position[0]-1==1 && rebot.position[1]==1))){
            rebot.position[0]-=1;
            return true;
        }
        return false;

    }


    public boolean avancerBas() {
        if (!(rebot.position[0]+1==10 || (rebot.position[0]+1==1&&rebot.position[1]==1) || (rebot.position[0]+1==1&&rebot.position[1]==2) )){
            rebot.position[0]+=1;
            return true;
        }
        return false;
    }

    public abstract void avancer();
}

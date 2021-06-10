package rebot;

public class RebotHaut extends RebotStat{
    public RebotHaut(Rebot rebot) {
        super(rebot);
    }

    @Override
    public boolean avancerGauche() {
        if(super.avancerGauche()){
            rebot.setState(new RebotGauche(rebot));
            return true;
        }
        System.out.println("ne peut pas avancer");
        return false;
    }

    @Override
    public boolean avancerDroit() {
        if(super.avancerDroit()){
            rebot.setState(new RebotDroit(rebot));
            return true;
        }
        System.out.println("ne peut pas avancer");
        return false;
    }

    @Override
    public boolean avancerHaut() {
        if(super.avancerHaut()){
            rebot.setState(new RebotHaut(rebot));
            return true;
        }
        System.out.println("ne peut pas avancer");
        return false;

    }

    @Override
    public boolean avancerBas() {
        System.out.println("ne peut pas avancer");
        return false;
    }

    @Override
    public void avancer(){
        super.avancerHaut();
    }
}

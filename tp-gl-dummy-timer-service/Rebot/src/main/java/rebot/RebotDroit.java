package rebot;

public class RebotDroit extends RebotStat{
    public RebotDroit(Rebot rebot){
        super(rebot);
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
        if(super.avancerBas()){
            rebot.setState(new RebotBas(rebot));
            return true;
        }
        System.out.println("ne peut pas avancer");
        return false;

    }

    @Override
    public boolean avancerGauche() {
        System.out.println("ne peut pas avancer");
        return false;
    }

    @Override
    public void avancer(){
        super.avancerDroit();
    }
}

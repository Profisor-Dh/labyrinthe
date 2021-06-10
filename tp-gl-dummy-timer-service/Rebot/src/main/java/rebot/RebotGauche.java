package rebot;

public class RebotGauche extends RebotStat{
    public RebotGauche(Rebot rebot){
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
    public boolean avancerDroit() {
        System.out.println("ne peut pas avancer");
        return false;
    }

    @Override
    public void avancer(){
        super.avancerGauche();
    }
}

package rebot;

public class RebotBas extends RebotStat{
    public RebotBas(Rebot rebot){
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
    public boolean avancerBas() {
        if(super.avancerBas()){
            rebot.setState(new RebotBas(rebot));
            return true;
        }
        System.out.println("ne peut pas avancer");
        return false;
    }

    @Override
    public boolean avancerHaut() {
        System.out.println("ne peut pas avancer");
        return false;
    }
    @Override
    public void avancer(){
        super.avancerBas();
    }



}

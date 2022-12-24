package proxy;

import metier.IMetier;
import metier.IMetierImpl;

public class Proxy implements IMetier {
    private IMetierImpl metier;
    @Override
    public double cacul() {
        if (metier==null) metier= new IMetierImpl();
        System.out.println("Ouverture d'une transaction");
        double res;
        try {
             res = metier.cacul();
            System.out.println("comit");
        } catch (Exception e){
            System.out.println("Rollback");
            throw (e);
        }

        return res;
    }
}

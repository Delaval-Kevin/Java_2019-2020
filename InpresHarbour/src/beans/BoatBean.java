/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package beans;

import add.FichierLog;
import add.Parametres;
import java.util.Date;
import java.util.Vector;
import java.io.Serializable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;



public class BoatBean implements Serializable, PropertyChangeListener
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private String _type;
    private FichierLog _log;
    private Vector _boatListeners;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public BoatBean()
    {     
        //System.out.println("Création du bean BoatBean");
        setBoatListeners(new Vector());
        
        Parametres param = new Parametres();
        
        setLog(new FichierLog(param.searchParam("phareLog")));
    }

    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setBoatListeners(Vector boatListeners)
    {
        _boatListeners = boatListeners;
    }
    
    public void setType(String type)
    {
        _type = type;
    }
    
    public void setLog(FichierLog log)
    {
        _log = log;
    }

    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public Vector getBoatListeners()
    {
        return _boatListeners;
    }
    
    public String getType()
    {
        return _type;
    }
    
    public FichierLog getLog()
    {
        return _log;
    }

    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/  
    
    public void notifyBoatDetected()
    {
        getLog().ecritLigne("BoatBean", "notifyBoatDetected");
        BoatEvent e = new BoatEvent(this); //On génère l'événement
        e.setPavillon(assignPavillon());
        e.setType(getType());
        e.setDate(new Date());
        
        getLog().ecritLigne("BoatBean", "envoie d'un BoatEvent");
        int n = getBoatListeners().size();
        for(int i = 0 ; i < n ; i++)
        {
            BoatListener obj = (BoatListener) getBoatListeners().elementAt(i);
            obj.BoatDetected(e);
        }
    }
    
    public void addBoatListener(BoatListener bl)
    {
        getLog().ecritLigne("BoatBean", "addBoatListener");
        if(!getBoatListeners().contains(bl))
        {
            getBoatListeners().addElement(bl);
        }
    }
    
    public void removeBoatListener(BoatListener bl)
    {
        getLog().ecritLigne("BoatBean", "removeBoatListener");
        if(getBoatListeners().contains(bl))
        {
            getBoatListeners().removeElement(bl);
        }        
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) 
    {
        setType(evt.getNewValue().toString());
        
        notifyBoatDetected();
    }
    
    public String assignPavillon()
    {
        int choix;
        Double dr;

        dr = new Double(Math.random()*(1000));
        choix = dr.intValue();
        choix = choix%5;
        switch(choix)
        {
            case 0:
                return "FR";
                
            case 1:
                return "BE";
                
             case 2:
                return "UK";

            case 3:
                return "DE";  
                
            case 4:
                return "NL";
        }
        return null;
    }
}

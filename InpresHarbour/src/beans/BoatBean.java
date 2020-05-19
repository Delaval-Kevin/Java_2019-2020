/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package beans;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Vector;



public class BoatBean implements PropertyChangeListener
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private Vector _boatListeners;
    private String _type;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public BoatBean()
    {     
        //System.out.println("Création du bean BoatBean");
        setBoatListeners(new Vector());
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
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/  
    
    public void notifyBoatDetected()
    {
        BoatEvent e = new BoatEvent(this); //On génère l'événement
        e.setPavillon(assignPavillon());
        e.setType(getType());
        e.setDate(new Date());
        
        int n = getBoatListeners().size();
        for(int i = 0 ; i < n ; i++)
        {
            BoatListener obj = (BoatListener) getBoatListeners().elementAt(i);
            obj.BoatDetected(e);
        }
    }
    
    public void addBoatListener(BoatListener bl)
    {
        if(!getBoatListeners().contains(bl))
        {
            getBoatListeners().addElement(bl);
        }
    }
    
    public void removeBoatListener(BoatListener bl)
    {
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

/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package beans;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import threadsutils.ThreadRandomGenerator;
import threadsutils.UtilisateurNombre;


public class KindOfBoatBean implements UtilisateurNombre, Serializable
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private boolean _enMarche;
    private String _info;
    private PropertyChangeSupport GestProp = new PropertyChangeSupport(this);
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public KindOfBoatBean()
    {
        //System.out.println("Création du bean KindOfBoat");
    }
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setEnMarche(boolean enMarche)
    {
        _enMarche = enMarche;
    }
    
    public void setInfo(String info)
    {
        String ancienneValeur = _info;
        _info = info;

        GestProp.firePropertyChange("Info", ancienneValeur, info);
    }
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public boolean isEnMarche()
    {
        return _enMarche;
    }
    
    
    public String getInfo()
    {
        return _info;
    }
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/ 
    
    public void init()
    {
        setEnMarche(true);
    }
    
    public void stop()
    {
        setEnMarche(false);
    }
    
    public void run()
    {
        if(isEnMarche())
        {
            ThreadRandomGenerator thread = new ThreadRandomGenerator(this, 0, 1000, 2, 2);  
            thread.start();
        }
    }
    
    public void addPropertyChangeListener(PropertyChangeListener l)
    {
        GestProp.addPropertyChangeListener(l);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener l)
    {
        GestProp.removePropertyChangeListener(l);
    }
    
    @Override
    public String getIdentifiant() 
    {
        return "KindOfBoatBean";
    }

    @Override
    public void traiteNombre(int n) 
    {       
        int value;
        Double dr;

        dr = new Double(Math.random()*(1000));
        value = dr.intValue();

        if(value%7 == 0)
        {
            setInfo("Plaisance");
        }
        else if(value%17 == 0)
        {
            setInfo("Peche");
        }
    }
}

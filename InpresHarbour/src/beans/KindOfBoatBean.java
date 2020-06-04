/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package beans;

import add.FichierLog;
import add.Parametres;
import java.io.Serializable;
import threadsutils.UtilisateurNombre;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;
import threadsutils.ThreadRandomGenerator;


public class KindOfBoatBean implements UtilisateurNombre, Serializable
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private int _bornInf;
    private int _bornSup;
    private String _info;
    private FichierLog _log;
    private boolean _enMarche;
    private Parametres _parametres;
    private PropertyChangeSupport GestProp = new PropertyChangeSupport(this);
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public KindOfBoatBean()
    {
        setParametres(new Parametres());
        setBornInf(Integer.parseInt(getParametres().searchParam("nombreRef1")));
        setBornSup(Integer.parseInt(getParametres().searchParam("nombreRef2")));  
        
        setLog(new FichierLog(getParametres().searchParam("phareLog")));
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
    
    public void setParametres(Parametres parametres)
    {
        _parametres = parametres;
    }
    
    public void setBornInf(int bornInf)
    {
        _bornInf = bornInf;
    }
    
    public void setBornSup(int bornSup)
    {
        _bornSup = bornSup;
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
    
    public boolean isEnMarche()
    {
        return _enMarche;
    }
    
    
    public String getInfo()
    {
        return _info;
    }
        
    public Parametres getParametres()
    {
        return _parametres;
    }
    
    public int getBornInf()
    {
        return _bornInf;
    }
    
    public int getBornSup()
    {
        return _bornSup;
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
    
    public void init()
    {
        getLog().ecritLigne("KindOfBoatBean", "init");
        setEnMarche(true);
    }
    
    public void stop()
    {
        getLog().ecritLigne("KindOfBoatBean", "stop");
        setEnMarche(false);
    }
    
    public void run()
    {
        getLog().ecritLigne("KindOfBoatBean", "run");
        if(isEnMarche())
        {
            int tempsPause = Integer.parseInt(getParametres().searchParam("tempsSommeil"));
            
            getLog().ecritLigne("KindOfBoatBean", "Creation de ThreadRandomGenerator");
            ThreadRandomGenerator thread = new ThreadRandomGenerator(this, 0, tempsPause, 2, 2);  
            thread.start();
        }
    }
    
    public void addPropertyChangeListener(PropertyChangeListener l)
    {
        getLog().ecritLigne("KindOfBoatBean", "addPropertyChangeListener");
        GestProp.addPropertyChangeListener(l);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener l)
    {
        getLog().ecritLigne("KindOfBoatBean", "removePropertyChangeListener");
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

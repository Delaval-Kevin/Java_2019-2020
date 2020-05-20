/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package humain;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;



public class Equipage implements Serializable
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private Marin _capitaine;
    private Marin _second;
    private Vector<Marin> _marins;
    
    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    //Constructeur d'initialisation 3 paramètres
    public Equipage(Marin capitaine, Marin second, Vector<Marin> marins)
    {
        setCapitaine(capitaine);
        setSecond(second);
        
        if(marins == null)
        {
            setMarins(new Vector<Marin>());
        }
        else
        {
            setMarins(marins);
        }
    }   
 
    //Constructeur d'initialisation 2 paramètres
    public Equipage(Marin capitaine, Marin second)
    {
        this(capitaine, second, null);
    }
    
    //Constructeur d'initialisation 2 paramètres
    public Equipage(Marin capitaine, Vector<Marin> marins)
    {
        this(capitaine, null, marins);
    }   

    //Constructeur d'initialisation 1 paramètre
    public Equipage(Marin capitaine)
    {
        this(capitaine, null, null);
    }   
    
    //Constructeur par défaut
    public Equipage()
    {
         setMarins(new Vector<Marin>());
    } 
    
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/   
    
    public Marin getCapitaine()
    {
        return _capitaine;
    }

    public Marin getSecond()
    {
        return _second;
    }
  
    public Vector<Marin> getMarins()
    {
        return _marins;
    }
    
    
    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/     
    
    public void setCapitaine(Marin capitaine)
    {
        _capitaine = capitaine;
    }
    
    public void setSecond(Marin second)
    {
        _second = second;
    }
    
    public void setMarins(Vector<Marin> marins)
    {
        _marins = marins;
    }
    
 
    /***************************/
    /*                         */
    /*        Méthodes         */
    /*                         */
    /***************************/
    
    public void Affiche()
    {
        getCapitaine().Affiche();
        
        if(getSecond() != null)
        {
            getSecond().Affiche();
        }
        
        if(getMarins().size() > 0)
        {
            Enumeration e;
            for( e = getMarins().elements() ; e.hasMoreElements() ; )
            {
                Marin mar = (Marin)e.nextElement();
                mar.Affiche();
            }
        }
    }
    
    public void AddMarins(Marin marin)
    {
        getMarins().add(marin);
    }
}

/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package amarrages;
import java.io.Serializable;
import vehicules.AUnIdentifiant;


public abstract class Amarrage implements AUnIdentifiant, Serializable
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private int _capacite;
    private String _nom;
    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    public Amarrage(int capacite)
    {
        setCapacite(capacite);
        setNom("");
    }
            
    public Amarrage()
    {
        this(0);
    }
    
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/   
    
    public int getCapacite()
    {
        return _capacite;
    }
     
    public String getNom()
    {
        return _nom;
    }
    
    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/     
    
    public void setCapacite(int capacite)
    {
        _capacite = capacite;
    }
    
    public void setNom(String nom)
    {
        _nom = nom;
    }  
}

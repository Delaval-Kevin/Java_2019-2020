/***********************************************************/
/*Auteur : DELAVAL Kevin                                   */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package amarrages;
import vehicules.AUnIdentifiant;


public abstract class Amarrage implements AUnIdentifiant
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private int _capacite;
    
    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    public Amarrage(int capacite)
    {
        setCapacite(capacite);
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
     
     
    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/     
    
    public void setCapacite(int capacite)
    {
        _capacite = capacite;
    }
}

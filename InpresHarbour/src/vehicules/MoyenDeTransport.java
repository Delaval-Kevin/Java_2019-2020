/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package vehicules;


public abstract class MoyenDeTransport implements AvecHumains
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private Combustible _combustible;
    
    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/

    //Constructeur d'initialisation
    public MoyenDeTransport(Combustible combustible)
    {
        setCombustible(combustible);
    }
    
    //Constructeur par défaut
    public MoyenDeTransport()
    {
        this(Combustible.autre);
    }
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/
    
    public Combustible getCombustible()
    {
        return _combustible;
    }
    
    
    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/
    
    public void setCombustible(Combustible combustible)
    {
        _combustible = combustible;
    }
    
    
    /***************************/
    /*                         */
    /*        Méthodes         */
    /*                         */
    /***************************/
    
    public void Affiche()
    {
        System.out.println("Type de combustible : " + getCombustible());
    }
}

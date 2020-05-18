/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package vehicules;


public abstract class MoyenDeTransportSurEau extends MoyenDeTransport
{   
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private boolean _submersible;
    
    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    //Constructeur d'initialisation
    public MoyenDeTransportSurEau(Combustible combustible , boolean submersible)
    {
        super(combustible);
        setSubmersible(submersible);
    }
    
    //Constructeur par défaut
    public MoyenDeTransportSurEau()
    {
        super(Combustible.autre);
        setSubmersible(false);
    }  
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/
    
    public boolean getSubmersible()
    {
        return _submersible;
    }

        
    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/
    
    public void setSubmersible(boolean submersible)
    {
        _submersible = submersible;
    }
    
    
    /***************************/
    /*                         */
    /*        Méthodes         */
    /*                         */
    /***************************/
    
    @Override
    public void Affiche()
    {
        super.Affiche();
        System.out.println("Est submersible : " + getSubmersible());
    }
}

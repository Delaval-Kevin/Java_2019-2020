/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package amarrages;
import vehicules.MoyenDeTransportSurEau;


public class Quai extends Amarrage
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private MoyenDeTransportSurEau[] _liste;
    
    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    public Quai(int capacite)
    {
        super(capacite);
        setListe(new MoyenDeTransportSurEau[getCapacite()]);
    }
            
    public Quai()
    {
        this(0);
    }
    
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/   
    
    @Override
    public String getIdentifiant()
    {
        return getNom();
    }
     
    public MoyenDeTransportSurEau[] getListe()
    {
        return _liste;
    }
    
    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/    
    
    public void setListe(MoyenDeTransportSurEau[] liste)
    {
        _liste = liste;
    }  
        
    /***************************/
    /*                         */
    /*        Méthodes         */
    /*                         */
    /***************************/ 
}

/***********************************************************/
/*Auteur : DELAVAL Kevin                                   */
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
    
    private String _nom;
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
    
    public String getNom()
    {
        return _nom;
    }
    
    @Override
    public String getIdentifiant()
    {
        return _nom;
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
    
    public void setNom(String nom)
    {
        _nom = nom;
    }  
    
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

/***********************************************************/
/*Auteur : DELAVAL Kevin                                   */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package amarrages;
import vehicules.MoyenDeTransportSurEau;


public class Ponton extends Amarrage
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private String _nom;
    private MoyenDeTransportSurEau[][] _liste;
    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    public Ponton(int capacite) throws OddPontoonException
    {
        super(capacite);
        
        if(getCapacite()%2 != 0)
        {
            throw new OddPontoonException("La taille du ponton ne peut pas être impair");
        }
        
        setListe(new MoyenDeTransportSurEau[2][getCapacite()/2]);
    }
            
    public Ponton() throws OddPontoonException
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
    
    public MoyenDeTransportSurEau[] getListe(int cote)
    {
        if(cote == 1)
        {
            return _liste[1];
        }
        else if(cote == 2)
        {
            return _liste[2];
        }
        return null;
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
    
    public void setListe(MoyenDeTransportSurEau[][] liste)
    {
        _liste = liste;
    }  
    
    /***************************/
    /*                         */
    /*        Méthodes         */
    /*                         */
    /***************************/     
}

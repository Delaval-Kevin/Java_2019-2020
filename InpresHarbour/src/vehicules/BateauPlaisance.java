/***********************************************************/
/*Auteur : DELAVAL Kevin                                   */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package vehicules;
import humain.Equipage;
import humain.SailorWithoutIdentificationException;


public class BateauPlaisance extends Bateau
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private String _permis;


    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    //Constructeur d'initialisation
    public BateauPlaisance(String nom, String portAttache, String pavillon, int tonnage, int longueur, String permis,  Combustible combustible , boolean submersible, Equipage equipage) throws ShipWithoutIdentificationException
    {
        super(nom, portAttache, pavillon, tonnage, longueur, combustible, submersible, equipage);
        
        setPermis(permis);
    }
    
     //Constructeur par défaut
    public BateauPlaisance() throws ShipWithoutIdentificationException, SailorWithoutIdentificationException
    {
        this("Les Francs", "Calais", "FR", 5, 15, "plaisance option côtière", Combustible.essence, false, new Equipage());
    }   
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/    
    
    public String getPermis() 
    {
        return _permis;
    }


    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/  
    
    public void setPermis(String permis) 
    {
        _permis = permis;
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
        System.out.println("Permis : " + getPermis());
    }
}

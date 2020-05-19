/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package vehicules;

import humain.Equipage;
import humain.SailorWithoutIdentificationException;


public class BateauPeche extends Bateau
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private String _type;

    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    //Constructeur d'initialisation
    public BateauPeche(String nom, String portAttache, String pavillon, int tonnage, int longueur, String type,  Combustible combustible , boolean submersible, Equipage equipage) throws ShipWithoutIdentificationException
    {
        super(nom, portAttache, pavillon, tonnage, longueur, combustible, submersible, equipage);
        
        setType(type);
    }   
 
    //Constructeur par défaut
    public BateauPeche() 
    {
        
    }   
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/   
    
    public String getType() 
    {
        return _type;
    }


    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/  
    
    public void setType(String type) 
    {
        _type = type;
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
        System.out.println("Type : " + getType());
    }
}

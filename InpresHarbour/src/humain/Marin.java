/***********************************************************/
/*Auteur : DELAVAL Kevin                                   */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package humain;
import vehicules.AUnIdentifiant;


public class Marin extends Humain implements AUnIdentifiant
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private String _fonction;

    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    //Constructeur d'initialisation
    public Marin(String nom, String prenom, String dateNaissance, String fonction) throws SailorWithoutIdentificationException
    {
        super(nom, prenom, dateNaissance);
        setFonction(fonction);
    }   
 
      //Constructeur par défaut
    public Marin() throws SailorWithoutIdentificationException
    {
        this("Presley", "Elvis", "12/03/1820", "capitaine");
    }   
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/   
    
    public String getFonction()
    {
        return _fonction;
    }

    @Override
    public String getIdentifiant()
    {
        return getNom() + getPrenom() + getDateNaissance();
    }

    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/  
    
    public void setFonction(String fonction)
    {
        _fonction = fonction;
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
        System.out.println("Fonction : " + getFonction());
    }
}

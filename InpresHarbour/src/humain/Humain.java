/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package humain;


public class Humain 
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
    
    private String _nom;
    private String _prenom;
    private String _dateNaissance;

    
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    //Constructeur d'initialisation
    public Humain(String nom, String prenom, String dateNaissance)
    {   
        setNom(nom);
        setPrenom(prenom);
        setDateNaissance(dateNaissance);
    }   
 
    //Constructeur par défaut
    /*public Humain()
    {
        this("Dupond", "Jean", "29/11/1985");
    }*/
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/   
    
    public String getNom()
    {
        return _nom;
    }
    
    public String getPrenom()
    {
        return _prenom;
    }    

    public String getDateNaissance()
    {
        return _dateNaissance;
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

    public void setPrenom(String prenom)
    {
        _prenom = prenom;
    }
    
    public void setDateNaissance(String dateNaissance)
    {
        _dateNaissance = dateNaissance;
    }
    
    
    /***************************/
    /*                         */
    /*        Méthodes         */
    /*                         */
    /***************************/
    
    
    public void Affiche()
    {
        System.out.println("Nom : " + getNom());
        System.out.println("Prenom : " + getPrenom());
        System.out.println("Date de naissance : " + getDateNaissance());
    }
}

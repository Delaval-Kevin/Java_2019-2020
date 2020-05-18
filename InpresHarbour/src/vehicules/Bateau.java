/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package vehicules;
import humain.Equipage;
import humain.SailorWithoutIdentificationException;


public class Bateau extends MoyenDeTransportSurEau implements AUnIdentifiant
{
    /***************************/
    /*                         */
    /*    Variables membres    */
    /*                         */
    /***************************/
 
    private int         _tonnage;
    private int         _longueur;
    private String      _nom;
    private String      _pavillon;
    private String      _portAttache;
    private Equipage    _equipage;

   
    /***************************/
    /*                         */
    /*      Constructeurs      */
    /*                         */
    /***************************/
    
    //Constructeur d'initialisation
    public Bateau(String nom, String portAttache, String pavillon, int tonnage, int longueur,  Combustible combustible , boolean submersible, Equipage equipage) throws ShipWithoutIdentificationException
    {
        super(combustible, submersible);
        
        if (nom.length() == 0 || portAttache.length() == 0) 
        {
           throw new ShipWithoutIdentificationException("Identification du bateau invalide");
        }
        
        setNom(nom);
        setPortAttache(portAttache);
        setPavillon(pavillon);
        setTonnage(tonnage);
        setLongueur(longueur);
        setEquipage(equipage);
    }
    
    //Constructeur par défaut
    /*public Bateau() throws ShipWithoutIdentificationException, SailorWithoutIdentificationException
    {
        this("Belgica", "Anvers", "BE", 4, 11, Combustible.autre, false, new Equipage());
    }*/   
    
    public Bateau(String nom, String pavillon, int longueur,  Combustible combustible , boolean submersible, Equipage equipage)
    {
        super(combustible, submersible);
        
        setNom(nom);
        setPavillon(pavillon);
        setLongueur(longueur);
        setEquipage(equipage);
    }    
    
    /***************************/
    /*                         */
    /*         Getters         */
    /*                         */
    /***************************/
    
    public int getTonnage()
    {
        return _tonnage;
    }
    
    public int getLongueur() 
    {
        return _longueur;
    }

    public String getNom() 
    {
        return _nom;
    }
    
    public String getPavillon() 
    {
        return _pavillon;
    }
    
    public String getPortAttache() 
    {
        return _portAttache;
    }
    
    public Equipage getEquipage()
    {
        return _equipage;
    }
 
    @Override
    public String getIdentifiant()
    {
        return getNom() + getPortAttache();
    }
    
    @Override
    public int getNombreHumains() 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /***************************/
    /*                         */
    /*         Setters         */
    /*                         */
    /***************************/    
    
    public void setTonnage(int tonnage) 
    {
        _tonnage = tonnage;
    }

    public void setLongueur(int longueur) 
    {
        _longueur = longueur;
    }

    public void setNom(String nom) 
    {
        _nom = nom;
    }

    public void setPavillon(String pavillon) 
    {
        _pavillon = pavillon;
    }

    public void setPortAttache(String portAttache) 
    {
        _portAttache = portAttache;
    }    
    
    public void setEquipage(Equipage equipage)
    {
        _equipage = equipage;
    }
    
    
    /***************************/
    /*                         */
    /*        Méthodes         */
    /*                         */
    /***************************/
    
    public void Affiche()
    {
        System.out.println("Nom du bateau : " + getNom());
        System.out.println("Port d'attache : " + getPortAttache());
        System.out.println("Pavillon : " + getPavillon());
        System.out.println("Tonnage : " + getTonnage());
        System.out.println("Longueur : " + getLongueur());
        getEquipage().Affiche();
    }
    
    @Override
    public String toString()
    {
        return getNom() + " : " + getPortAttache();
    }
}

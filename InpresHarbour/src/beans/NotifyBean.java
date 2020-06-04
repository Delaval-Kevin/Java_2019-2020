/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package beans;

import add.FichierLog;
import add.Parametres;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;


public class NotifyBean implements Serializable, BoatListener
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private FichierLog _log;
    private DefaultListModel _bateauxEntrant;
    
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public NotifyBean()
    {     
        //System.out.println("Création du bean NotifyBean"); 
        setBateauxEntrant(null);
        
        Parametres param = new Parametres();
        
        setLog(new FichierLog(param.searchParam("phareLog")));
    }

    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setBateauxEntrant(DefaultListModel bateauxEntrant)
    {
        _bateauxEntrant = bateauxEntrant;
    }
    
    public void setLog(FichierLog log)
    {
        _log = log;
    }
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public DefaultListModel getBateauxEntrant()
    {
        return _bateauxEntrant;
    }
    
    public FichierLog getLog()
    {
        return _log;
    }
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/        
    
    @Override
    public void BoatDetected(BoatEvent e) 
    {
        getLog().ecritLigne("NotifyBean", "BoatDetected, ajout à la liste");
        JOptionPane.showMessageDialog(null,
             "Bateau en approche", "Arrivage bateau", JOptionPane.INFORMATION_MESSAGE);

        String indent = e.getType()+"/"+e.getPavillon();
        getBateauxEntrant().addElement(indent);       
    }
    
}

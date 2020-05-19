/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package beans;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class NotifyBean implements BoatListener
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
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
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public DefaultListModel getBateauxEntrant()
    {
        return _bateauxEntrant;
    }
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/        
    
    @Override
    public void BoatDetected(BoatEvent e) 
    {
        JOptionPane.showMessageDialog(null,
             "Bateau en approche", "Arrivage bateau", JOptionPane.INFORMATION_MESSAGE);

        String indent = e.getType()+"/"+e.getPavillon();
        getBateauxEntrant().addElement(indent);       
    }
    
}

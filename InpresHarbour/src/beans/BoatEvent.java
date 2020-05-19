/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 18/05/2020             */
/***********************************************************/

package beans;
import java.util.Date;
import java.util.EventObject;


public class BoatEvent extends EventObject 
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private String _pavillon;
    private String _type;
    private Date _heureReception;
    
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public BoatEvent(Object source)
    {
        super(source);
    }
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
        
    public void setPavillon(String pavillon)
    {
        _pavillon = pavillon;
    }
    
    public void setType(String type)
    {
        _type = type;
    }
    
    public void setDate(Date heureReception)
    {
        _heureReception = heureReception;
    }
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public String getPavillon()
    {
        return _pavillon;
    }
    
    public String getType()
    {
        return _type;
    }
    
    public Date getDate()
    {
        return _heureReception;
    }
    
}

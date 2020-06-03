/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 18/05/2020             */
/***********************************************************/

package beans;
import java.util.EventListener;


public interface DepartListener extends EventListener
{
    public void DepartDetected(DepartEvent e);
}

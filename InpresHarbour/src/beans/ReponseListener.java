/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 18/05/2020             */
/***********************************************************/

package beans;
import java.util.EventListener;


public interface ReponseListener extends EventListener
{
    public void ReponseDetected(ReponseEvent e);
}

/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 18/05/2020             */
/***********************************************************/

package utilisateurs;


public class LoginException extends Exception 
{

    public LoginException() {}

    public LoginException(String msg) {
        super(msg);
    }
}

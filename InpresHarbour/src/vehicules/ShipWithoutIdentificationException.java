/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package vehicules;


public class ShipWithoutIdentificationException extends Exception 
{
    
    public ShipWithoutIdentificationException() {}


    public ShipWithoutIdentificationException(String msg) 
    {
        super(msg);
    }
}

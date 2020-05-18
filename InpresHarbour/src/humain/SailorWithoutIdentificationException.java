/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package humain;


public class SailorWithoutIdentificationException extends Exception 
{


    public SailorWithoutIdentificationException() {}

    public SailorWithoutIdentificationException(String msg) 
    {
        super(msg);
    }
}

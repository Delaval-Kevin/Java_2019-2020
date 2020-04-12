/***********************************************************/
/*Auteur : DELAVAL Kevin                                   */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 04/04/2020             */
/***********************************************************/

package inpresharbour;
import humain.*;
import vehicules.*;



public class InpresHarbour 
{

    public static void main(String[] args) 
    {
        Bateau bateau = null;
        BateauPeche bateauPeche = null;
        BateauPlaisance bateauPlaisance = null;
        
        
        Humain humain = null;
        Marin marin = null;
        try 
        {
            bateau = new Bateau();
            
            bateauPeche = new BateauPeche();
            
            bateauPlaisance = new BateauPlaisance();
            
            humain = new Humain();
            
            marin = new Marin();
            
            bateau.getEquipage().setSecond(new Marin("Delaval", "Kevin", "29/01/1987", "second"));
            bateau.getEquipage().AddMarins(new Marin("refref", "frefr", "29/01/4655", "erff"));
            bateau.getEquipage().AddMarins(new Marin("zzzz", "zzzzdddd", "22/11/1111", "aaaaaa"));
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        
        

        bateau.Affiche();
        System.out.println("\n------------------------------\n");
        bateauPeche.Affiche();
        System.out.println("\n------------------------------\n");
        bateauPlaisance.Affiche();
        System.out.println("\n------------------------------\n");
        humain.Affiche();
        System.out.println("\n------------------------------\n");
        marin.Affiche();
    }
}

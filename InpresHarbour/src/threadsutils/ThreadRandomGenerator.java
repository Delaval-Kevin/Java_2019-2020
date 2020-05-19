/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 18/05/2020             */
/***********************************************************/

package threadsutils;


public class ThreadRandomGenerator extends java.lang.Thread
{
    private UtilisateurNombre utilisateurThread;
    private int borneInferieure, borneSuperieure, multipleDeclenchement1, multipleDeclenchement2, tempsPause;
    private int nombreProduit;
    
    public ThreadRandomGenerator(UtilisateurNombre un, int bi, int bs, int md1, int md2, int tp)
    {         
        utilisateurThread = un;
        borneInferieure=bi;
        borneSuperieure=bs;
        multipleDeclenchement1 = md1;
        multipleDeclenchement2 = md2;
        tempsPause = tp;
        nombreProduit = -1;
    }
    
    public void run()      
    {
        Double dr;
        while (true) 
        { 
            dr = new Double(borneInferieure +  Math.random()*(borneSuperieure - borneInferieure));
            nombreProduit = dr.intValue(); 
            //System.out.println(utilisateurThread.getIdentifiant() + "> nombreProduit = " + nombreProduit);
            
            if (nombreProduit % multipleDeclenchement1 == 0 || nombreProduit % multipleDeclenchement2 == 0)
            {     
                //System.out.println(utilisateurThread.getIdentifiant() +  "> -------------- !!!!!!! " + nombreProduit + "!!!!");
                utilisateurThread.traiteNombre(nombreProduit); 
            } 
            
            try 
            {
                Thread.sleep(tempsPause*1000);
            } 
            catch (InterruptedException e) 
            {
                System.out.println("Erreur de thread interrompu : " + e.getMessage()); 
            }             
        } 
    } 
}

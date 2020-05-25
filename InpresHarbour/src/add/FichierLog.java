/***********************************************************/
/*Auteurs : DELAVAL Kevin & COLLETTE Loïc                  */
/*Groupe : 2203                                            */
/*Application : InpresHarbour                              */
/*Date de la dernière mise à jour : 11/04/2020             */
/***********************************************************/

package add;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class FichierLog 
{
    /**************************/
    /*                        */
    /*   VARIABLES MEMBRES    */
    /*                        */
    /**************************/
    
    private String _nomFichier;
    
    /**************************/
    /*                        */
    /*      CONSTRUCTEURS     */
    /*                        */
    /**************************/
    
    public FichierLog(String n)
    {
        String file = System.getProperty("user.dir")+System.getProperty("file.separator")+n;
        setNomFichier(file);
    }
    
    /**************************/
    /*                        */
    /*         SETTERS        */
    /*                        */
    /**************************/
    
    public void setNomFichier(String nomFichier)
    {
        _nomFichier = nomFichier;
    }
    
    /**************************/
    /*                        */
    /*         GETTERS        */
    /*                        */
    /**************************/
    
    public String getNomFichier()
    {
        return _nomFichier;
    }
    
    
    
    /**************************/
    /*                        */
    /*        METHODES        */
    /*                        */
    /**************************/ 
    
    public void ecritLigne(String ligne)
    {
        try 
        { 
            FileWriter f = new FileWriter(getNomFichier(), true);
            BufferedWriter bf = new BufferedWriter(f);
            bf.write("["+new Date() + "] : " + ligne);
            bf.newLine();     bf.close(); 
        }
        catch(IOException e) 
        {
            System.out.println(e.getMessage()); 
        }     
    }     
    
    public void ecritLigne(String entete, String info)
    {
        ecritLigne(entete + "> " + info);
    }
    
    public ArrayList lireFichier()
    {
        ArrayList<String> tab = new ArrayList<String>();;
        try 
        { 
            FileReader r = new FileReader(getNomFichier());
            BufferedReader br = new BufferedReader(r);
            String s; 
            while((s=br.readLine()) != null)
            {
                tab.add(s);
            }
        }
        catch(IOException e) 
        {
            System.out.println(e.getMessage()); 
        }   
        
        return tab;
    }
}
